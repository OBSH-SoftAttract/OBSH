package blserviceImpl;

import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import blservice.OrderBLService;
import data.dao.CreditDao;
import data.dao.HotelDao;
import data.dao.OrderDao;
import data.dao.PromotionDao;
import data.dao.impl.CreditDaoImpl;
import data.dao.impl.HotelDaoImpl;
import data.dao.impl.OrderDaoImpl;
import data.dao.impl.PromotionDaoImpl;
import po.CreditPo;
import po.HotelPo;
import po.OrderPo;
import po.PromotionPo;
import vo.PromotionVo;
import vo.OrderVo;


public class OrderBLServiceImpl implements OrderBLService{

	private CreditDao creditdao;
	private OrderDao orderdao;
	private HotelDao hoteldao;
	private PromotionDao promotiondao;
	
	private static int scoreCount=0;
	private final double CREDIT=0;
	private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private final long AttemptedTime=21600000;//6小时
	
	private CreditBLServiceImpl cre;
	
	public OrderBLServiceImpl(){
		creditdao=CreditDaoImpl.getInstance();
		orderdao=OrderDaoImpl.getInstance();
		hoteldao=HotelDaoImpl.getInstance();
		promotiondao=PromotionDaoImpl.getInstance();
		cre=new CreditBLServiceImpl();
	}
	
	@Override
	public boolean Cancellation(OrderVo ordervo)throws RemoteException{
		if(0!=ordervo.getOrderState()){
			return false;
		}
		ordervo.setOrderState(2);
		OrderPo po=orderdao.getOrder(ordervo.getOrderID());
		po.setOrderState(2);
		
		Date date=new Date();
		Timestamp now=new Timestamp(date.getTime());
		if(now.getTime()-ordervo.getStartTime().getTime()>AttemptedTime){
			cre.CutCreditForCancel(ordervo.getUserID(),ordervo.getPrice());
		}
		return orderdao.updateOrder(po);
	}

	@Override
	public boolean IFpassTime(OrderVo ordervo) throws RemoteException{
		Timestamp deadline=ordervo.getLastTime();		
		Date date = new Date();       
		Timestamp now = new Timestamp(date.getTime());
		if(deadline.getTime()<now.getTime())return true;		
		return false;
	}
	

	@Override
	public void CancelKillCredit(OrderVo ordervo)throws RemoteException {
		double precredit=cre.getCredit(ordervo.getUserID()).getCreditResult();
		Date date=new Date();
		Timestamp now=new Timestamp(date.getTime());
		CreditPo creditpo=new CreditPo(ordervo.getUserID(),now ,precredit-ordervo.getPrice());
		creditdao.addCredit(creditpo);
	}

	@Override
	public boolean Assess(int score, String comment, OrderVo ordervo) throws RemoteException{
		HotelPo hotelpo=hoteldao.getHotel(ordervo.getHotelID());
		double prescore=hotelpo.getScore();
		if(score!=-1){
			prescore*=scoreCount++;
			prescore+=score;
			hotelpo.setScore(prescore/scoreCount);
		}
		if(null!=comment)
			hotelpo.addSummary(comment);
		return hoteldao.updateHotel(hotelpo);
	}

	@Override
	public boolean Add(OrderVo ordervo) throws RemoteException{
		OrderPo orderPo=new OrderPo(ordervo);
		return orderdao.addOrderPo(orderPo);
	}

	@Override
	public boolean CreditCheck(OrderVo ordervo) throws RemoteException{
		int id=ordervo.getUserID();
		double credit=cre.getCredit(id).getCreditResult();
		if(credit>=CREDIT)return true;
		return false;
	}

	@Override
	public PromotionPo CalPromotion(int userid) throws RemoteException{
		List<PromotionPo> list=promotiondao.getLineItem();
		Iterator<PromotionPo> ite=list.iterator();
		
		Date date = new Date();
		Timestamp now = new Timestamp(date.getTime());
		double best=1;
		PromotionPo res=null;
		while(ite.hasNext()){
			PromotionPo temp=ite.next();
			if(temp.getEndTime().getTime()<=now.getTime()&&
					now.getTime()>=temp.getStartTime().getTime()){
				if(temp.getDiscount()<best){
					best=temp.getDiscount();
					res=temp;
				}
					
			}
		}
		return res;
	}

	@Override
	public double CalPrice(OrderVo vo) throws RemoteException{//未考虑会员的折扣
		
		PromotionPo promotion=CalPromotion(vo.getUserID());
		if(promotion!=null)
		   return promotion.getDiscount()*vo.getPrice();
		return vo.getPrice();
	}

	@Override
	public void Solve(OrderVo vo) throws RemoteException{
		OrderPo orderpo=orderdao.getOrder(vo.getOrderID());//先修改状态
		orderpo.setOrderState(1);
		orderdao.updateOrder(orderpo);
		
		double incre=orderpo.getPrice();
		CreditPo po=cre.getCredit(orderpo.getUserID());
		po.setCreditResult((incre+cre.getCredit(orderpo.getUserID()).getCreditResult()));
		creditdao.addCredit(po);
	}

	@Override
	public boolean ComplainDeal(OrderVo vo) throws RemoteException{
		OrderPo po=orderdao.getOrder(vo.getOrderID());
		if(po.getOrderState()!=3)
		return false;
		else{
			po.setOrderState(2);
			return orderdao.updateOrder(po);
		}
	}

	@Override
	public OrderPo ViewByOrderID(String orderid) throws RemoteException{
		return orderdao.getOrder(orderid);	
	}
	
	@Override
	public List<OrderPo> ViewByHotel(int id) throws RemoteException {
		return orderdao.getOrders(id);
	}

	@Override
	public List<OrderPo> ViewByCustom(int id) throws RemoteException{
		return orderdao.getOrderByUserID(id);
	}

	@Override
	public List<OrderVo> ViewByDaily(List<OrderVo> list) throws RemoteException{
		for(int i=0;i<list.size()-1;i++){
			for(int j=1;j<list.size();j++){
				if(list.get(i).getStartTime().getTime()<list.get(j).getStartTime().getTime()){
					OrderVo vo=list.get(i);
					list.set(i, list.get(j));
					list.set(j, vo);
				}
			}
		}
		return list;
	}
	
	
	@SuppressWarnings("null")
	@Override
	public List<OrderPo> ViewByState(int state,int id) throws RemoteException{
		List<OrderPo> orderList=ViewByCustom(id);
		Iterator<OrderPo> ite=orderList.iterator();
		List<OrderPo> orderAfter = null;
		while(ite.hasNext()){
			OrderPo po=ite.next();
			if(po.getOrderState()==state)
				orderAfter.add(po);
		  }			
		return orderAfter;
	}


	@Override
	public List<OrderVo> TimeSort(List<OrderVo> orderlist) throws RemoteException{
		
		if(orderlist.size()<=1) return orderlist;
		for(int i=0;i<orderlist.size()-1;i++){
			for(int j=1;j<orderlist.size();j++){
				OrderVo vo;
				if(orderlist.get(i).getStartTime().getTime()<orderlist.get(j).getStartTime().getTime()){
					vo=orderlist.get(i);
					orderlist.set(i, orderlist.get(j));
					orderlist.set(j, vo);
				}
			}
		}
		return orderlist;
	}

	@Override
	public String CreateID(int hotelroomid) throws RemoteException{
		String s="";
		try{
			Date date = new Date();
			s=df.format(date);
			s=s.substring(0,4)+s.substring(5, 7)+s.substring(8, 10)+s.substring(11, 13)+s.substring(14, 16)+
					s.substring(17, 19);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		s=s+Integer.toString(hotelroomid);
		return  s;
	}


	
}
