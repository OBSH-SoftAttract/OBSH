package server_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.util.List;

import blservice.*;
import blserviceImpl.*;
import po.OrderPo;
import po.PromotionPo;
import po.CreditPo;
import po.HotelPo;
import po.HotelroomPo;
import vo.HotelVo;
import vo.HotelroomVo;
import vo.OrderVo;
import vo.PromotionVo;
import vo.UserVo;

public class DataRemoteObject extends UnicastRemoteObject implements UserBLService,HotelroomBLService,
PromotionBLService,CreditBLService,HotelBLService,OrderBLService,MemberBLService{

	private static final long serialVersionUID = 4029039744279087114L;
	private UserBLService userblservice;
	private PromotionBLService promotionblservice;
	private CreditBLService creditblservice;
	private HotelBLService hotelblservice;
	private OrderBLService orderblservice;
	private MemberBLService memberblservice;
	private HotelroomBLService hotelroomblservice;
	
	protected DataRemoteObject() throws RemoteException{
		userblservice=new UserBLServiceImpl();
		promotionblservice=new PromotionBLServiceImpl();
		creditblservice=new CreditBLServiceImpl();
		hotelblservice=new HotelBLServiceImpl();
		orderblservice=new OrderBLServiceImpl();
		memberblservice=new MemberBLServiceImpl();
		hotelroomblservice=new HotelroomBLServiceImpl();
		// TODO Auto-generated constructor stub
	}

	
	
	@Override
	public boolean login(int id, String password) {
		// TODO Auto-generated method stub
		return userblservice.login(id, password);
	}


	@Override
	public boolean ModifyMessage(UserVo vo) {
		// TODO Auto-generated method stub
		return userblservice.ModifyMessage(vo);
	}

	@Override
	public boolean ModifyHotelMessage(HotelVo vo) {
		// TODO Auto-generated method stub
		return userblservice.ModifyHotelMessage(vo);
	}

	@Override
	public boolean ModifyPassword(UserVo vo) {
		// TODO Auto-generated method stub
		return userblservice.ModifyPassword(vo);
	}

	@Override
	public boolean AddClient(UserVo vo) {
		// TODO Auto-generated method stub
		return userblservice.AddClient(vo);
	}

	@Override
	public List<OrderPo> GetOrderHistory(int id) {
		// TODO Auto-generated method stub
		return userblservice.GetOrderHistory(id);
	}

	@Override
	public void createByBusiness(int id, String name) {
		// TODO Auto-generated method stub
		memberblservice.createByBusiness(id, name);
	}

	@Override
	public int getMemberRank(int id) {
		// TODO Auto-generated method stub
		return memberblservice.getMemberRank(id);
	}

	@Override
	public boolean isMember(int id) {
		// TODO Auto-generated method stub
		return memberblservice.isMember(id);
	}

	@Override
	public boolean Cancellation(OrderVo ordervo) throws RemoteException {
		// TODO Auto-generated method stub
		return orderblservice.Cancellation(ordervo);
	}

	@Override
	public  boolean IFpassTime(OrderVo ordervo) throws RemoteException {
		// TODO Auto-generated method stub
		return orderblservice.IFpassTime(ordervo);
	}

	@Override
	public void CancelKillCredit(OrderVo ordervo) throws RemoteException {
		// TODO Auto-generated method stub
		orderblservice.CancelKillCredit(ordervo);
	}

	@Override
	public boolean Assess(int score, String comment, OrderVo ordervo) throws RemoteException {
		// TODO Auto-generated method stub
		return orderblservice.Assess(score, comment, ordervo);
	}

	@Override
	public boolean Add(OrderVo ordervo) throws RemoteException {
		// TODO Auto-generated method stub
		return orderblservice.Add(ordervo);
	}

	@Override
	public boolean CreditCheck(OrderVo ordervo) throws RemoteException {
		// TODO Auto-generated method stub
		return orderblservice.CreditCheck(ordervo);
	}

	@Override
	public PromotionPo CalPromotion(int userid) throws RemoteException {
		// TODO Auto-generated method stub
		return orderblservice.CalPromotion(userid);
	}

	@Override
	public double CalPrice(OrderVo vo) throws RemoteException {
		// TODO Auto-generated method stub
		return orderblservice.CalPrice(vo);
	}

	@Override
	public void Solve(OrderVo vo) throws RemoteException {
		// TODO Auto-generated method stub
		orderblservice.Solve(vo);
	}

	@Override
	public boolean ComplainDeal(OrderVo vo) throws RemoteException {
		// TODO Auto-generated method stub
		return orderblservice.ComplainDeal(vo);
	}

	@Override
	public OrderPo ViewByOrderID(String orderid) throws RemoteException {
		// TODO Auto-generated method stub
		return orderblservice.ViewByOrderID(orderid);
	}

	@Override
	public List<OrderPo> ViewByCustom(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return orderblservice.ViewByCustom(id);
	}

	@Override
	public List<OrderVo> ViewByDaily(List<OrderVo> list) throws RemoteException {
		// TODO Auto-generated method stub
		return orderblservice.ViewByDaily(list);
	}

	@Override
	public List<OrderPo> ViewByState(int state,int id) throws RemoteException {
		// TODO Auto-generated method stub
		return orderblservice.ViewByState(state,id);
	}

	@Override
	public List<OrderVo> TimeSort(List<OrderVo> orderlist) throws RemoteException {
		// TODO Auto-generated method stub
		return orderblservice.TimeSort(orderlist);
	}

	@Override
	public String CreateID(int hotelid) throws RemoteException {
		// TODO Auto-generated method stub
		return orderblservice.CreateID(hotelid);
	}

	@Override
	public void addCredit(int id,double value) {
		// TODO Auto-generated method stub
		creditblservice.addCredit(id,value);
	}

	@Override
	public void recoverCredit(int id,double price, int tag) {
		// TODO Auto-generated method stub
		creditblservice.recoverCredit(id,price, tag);
	}

	@Override
	public int judge(int id) {
		// TODO Auto-generated method stub
		return promotionblservice.judge(id);
	}

	@Override
	public PromotionVo createNewItem(PromotionVo vo) {
		// TODO Auto-generated method stub
		return promotionblservice.createNewItem(vo);
	}

	@Override
	public boolean Del(PromotionVo vo) {
		// TODO Auto-generated method stub
		return promotionblservice.Del(vo);
	}

	@Override
	public boolean update(PromotionVo vo) {
		// TODO Auto-generated method stub
		return promotionblservice.update(vo);
	}

	@Override
	public List<PromotionPo> getLineItem(String itemName) {
		// TODO Auto-generated method stub
		return promotionblservice.getLineItem(itemName);
	}



	@Override
	public int Addroom(double room) {
		// TODO Auto-generated method stub
		return hotelroomblservice.Addroom(room);
	}




	@Override
	public List<OrderPo> ViewByHotel(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return orderblservice.ViewByHotel(id);
	}



	@Override
	public List<CreditPo> getHistoryCredit(int id) {
		// TODO Auto-generated method stub
		return userblservice.getHistoryCredit(id);
	}



	@Override
	public void CutCreditForCancel(int id, double price) {
		// TODO Auto-generated method stub
		creditblservice.CutCreditForCancel(id, price);
	}



	@Override
	public void Administration(int id) {
		// TODO Auto-generated method stub
		userblservice.Administration(id);
	}



	@Override
	public boolean AddHotelMember(UserVo vo) {
		// TODO Auto-generated method stub
		return userblservice.AddHotelMember(vo);
	}



	@Override
	public boolean AddMarketer(UserVo vo) {
		// TODO Auto-generated method stub
		return userblservice.AddMarketer(vo);
	}



	@Override
	public boolean Addhotel(HotelVo hotelvo) {
		// TODO Auto-generated method stub
		return hotelblservice.Addhotel(hotelvo);
	}




	@Override
	public String ViewHotelDetail(int hotelid) {
		// TODO Auto-generated method stub
		return hotelblservice.ViewHotelDetail(hotelid);
	}



	@Override
	public HotelPo SearchByName(String hotel) {
		// TODO Auto-generated method stub
		return hotelblservice.SearchByName(hotel);
	}



	@Override
	public List<HotelPo> Views(String address, String commercialDistrict) {
		// TODO Auto-generated method stub
		return hotelblservice.Views(address, commercialDistrict);
	}



	@Override
	public void createByPersonal(int id, Date birthday) {
		// TODO Auto-generated method stub
		memberblservice.createByPersonal(id, birthday);
	}



	@Override
	public List<HotelPo> FilterByStar(int star, List<HotelPo> list) {
		// TODO Auto-generated method stub
		return hotelblservice.FilterByStar(star, list);
	}



	@Override
	public List<HotelPo> SortByStar(List<HotelPo> list) {
		// TODO Auto-generated method stub
		return hotelblservice.SortByStar(list);
	}



	@Override
	public List<HotelPo> FilterByPrice(double min, double max, List<HotelPo> list) {
		// TODO Auto-generated method stub
		return hotelblservice.FilterByPrice(min, max, list);
	}



	@Override
	public List<HotelPo> SortByPrice(List<HotelPo> list) {
		// TODO Auto-generated method stub
		return hotelblservice.SortByPrice(list);
	}



	@Override
	public List<HotelPo> FilterByScore(double min, double max, List<HotelPo> list) {
		// TODO Auto-generated method stub
		return hotelblservice.FilterByScore(min, max, list);
	}



	@Override
	public List<HotelPo> SortByScore(List<HotelPo> list) {
		// TODO Auto-generated method stub
		return hotelblservice.SortByScore(list);
	}



	@Override
	public List<HotelPo> FilterByRoomType(String type, List<HotelPo> list) {
		// TODO Auto-generated method stub
		return hotelblservice.FilterByRoomType(type, list);
	}



	@Override
	public List<HotelroomPo> SortByTime(List<HotelroomPo> list) {
		// TODO Auto-generated method stub
		return hotelblservice.SortByTime(list);
	}



	@Override
	public CreditPo getCredit(int id) {
		// TODO Auto-generated method stub
		return creditblservice.getCredit(id);
	}

}
