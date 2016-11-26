package blserviceImpl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import blservice.OrderBLService;
import data.dao.CreditDao;
import data.dao.HotelDao;
import data.dao.OrderDao;
import data.dao.impl.CreditDaoImpl;
import data.dao.impl.HotelDaoImpl;
import data.dao.impl.OrderDaoImpl;
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
	
	private static int scoreCount=0;
	private final double CREDIT=0;
	private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public OrderBLServiceImpl(){
		creditdao=CreditDaoImpl.getInstance();
		orderdao=OrderDaoImpl.getInstance();
		hoteldao=HotelDaoImpl.getInstance();
	}
	
	@Override
	public boolean Cancellation(OrderVo ordervo)throws RemoteException{
		if(0!=ordervo.getOrderState()){
			return false;
		}
		ordervo.setOrderState(2);
		orderdao.getOrder(ordervo.getOrderID()).setOrderState(2);
		return false;
	}

	@Override
	public String CancelTime(OrderVo ordervo) throws RemoteException{//返回的格式为：dd hh：mm：ss
		String time = null;
		/*try{		
		    Date d1 = df.parse(df.format(new Date()));
		    Date d2 = df.parse(ordervo.getStartTime().toString());
		    long l=d1.getTime()-d2.getTime();
		    long day=l/(24*60*60*1000);
		    long hour=(l/(60*60*1000)-day*24);
		    long min=((l/(60*1000))-day*24*60-hour*60);
		    long s=(l/1000-day*24*60*60-hour*60*60-min*60);
		    time=String.valueOf(day)+" "+String.valueOf(hour)+":"+String.valueOf(min)+":"+String.valueOf(s);
		}
		catch (Exception e){
			e.printStackTrace();
		}*/
		return time;
	}

	@Override
	public void CancelKillCredit(OrderVo ordervo)throws RemoteException {
		double precredit=creditdao.getCredit(ordervo.getUserID()).getCredit();
		CreditPo creditpo=new CreditPo(ordervo.getUserID(), precredit-ordervo.getPrice());
		creditdao.updateCredit(creditpo);
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
		double cre=creditdao.getCredit(id).getCredit();
		if(cre>=CREDIT)return true;
		return false;
	}

	@Override
	public PromotionPo CalPromotion(int userid) throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderVo CalPrice(PromotionVo vo1, OrderVo vo2) throws RemoteException{
		
		return null;
	}

	@Override
	public boolean Solve(OrderVo vo) throws RemoteException{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ComplainDeal(OrderVo vo) throws RemoteException{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public OrderPo ViewByOrderID(int orderid) throws RemoteException{
		return orderdao.getOrder(orderid);	
	}
	
	@Override
	public List<OrderPo> ViewByHotel(int id) throws RemoteException {
		return orderdao.getOrders(id);
	}

	@Override
	public List<OrderPo> ViewByCustom(int id) throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderPo> ViewByDaily(String date) throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public List<OrderPo> ViewByState(int state,int id) throws RemoteException{
		List<OrderPo> orderList;
		
		return null;
	}


	@Override
	public List<OrderPo> TimeSort(ArrayList<OrderVo> orderlist) throws RemoteException{
		// TODO Auto-generated method stub
		return null;
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
