package server_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
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
	public List<HotelPo> Views(String address, String commercialDistrict) {
		// TODO Auto-generated method stub
		return userblservice.Views(address, commercialDistrict);
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
	public void Cancel(UserVo vo) {
		// TODO Auto-generated method stub
		userblservice.Cancel(vo);
	}

	@Override
	public List<HotelroomVo> filterbystate(int state) {
		// TODO Auto-generated method stub
		return userblservice.filterbystate(state);
	}

	@Override
	public List<HotelroomVo> SortByTime(List<HotelroomVo> list) {
		// TODO Auto-generated method stub
		return userblservice.SortByTime(list);
	}

	@Override
	public boolean ViewDetail(int hotelid) {
		// TODO Auto-generated method stub
		return userblservice.ViewDetail(hotelid);
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
	public void createByPersonal(int id, String birthday) {
		// TODO Auto-generated method stub
		memberblservice.createByPersonal(id, birthday);
	}

	@Override
	public void createByBusiness(int id, String name) {
		// TODO Auto-generated method stub
		memberblservice.createByBusiness(id, name);
	}

	@Override
	public int getRank(double credit) {
		// TODO Auto-generated method stub
		return memberblservice.getRank(credit);
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
	public int Addhotel(int hotelNo) {
		// TODO Auto-generated method stub
		return hotelblservice.Addhotel(hotelNo);
	}

	@Override
	public void Updatehotel() {
		// TODO Auto-generated method stub
		hotelblservice.Updatehotel();
	}

	@Override
	public int Addprice(int price) {
		// TODO Auto-generated method stub
		return hotelblservice.Addprice(price);
	}

	@Override
	public int Addstar(int star) {
		// TODO Auto-generated method stub
		return hotelblservice.Addstar(star);
	}

	@Override
	public String Addlocation(String location) {
		// TODO Auto-generated method stub
		return hotelblservice.Addlocation(location);
	}

	@Override
	public String Addsummary(String summary) {
		// TODO Auto-generated method stub
		return hotelblservice.Addsummary(summary);
	}

	@Override
	public String Addservices(String services) {
		// TODO Auto-generated method stub
		return hotelblservice.Addservices(services);
	}

	@Override
	public String Addkind(String kind) {
		// TODO Auto-generated method stub
		return hotelblservice.Addkind(kind);
	}

	@Override
	public Object Addprice(double price) {
		// TODO Auto-generated method stub
		return hotelblservice.Addprice(price);
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
	public void Updateroom() {
		// TODO Auto-generated method stub
		hotelroomblservice.Updateroom();
	}



	@Override
	public boolean Checkin(HotelroomVo vo) {
		// TODO Auto-generated method stub
		return hotelroomblservice.Checkin(vo);
	}



	@Override
	public String Timein(String datein) {
		// TODO Auto-generated method stub
		return hotelroomblservice.Timein(datein);
	}



	@Override
	public int IDin(int id) {
		// TODO Auto-generated method stub
		return hotelroomblservice.IDin(id);
	}



	@Override
	public String TimeOutpro(String dateoutpro) {
		// TODO Auto-generated method stub
		return hotelroomblservice.TimeOutpro(dateoutpro);
	}



	@Override
	public String Timeout(String timeout) {
		// TODO Auto-generated method stub
		return hotelroomblservice.Timeout(timeout);
	}



	@Override
	public int IDout(int id) {
		// TODO Auto-generated method stub
		return hotelroomblservice.IDout(id);
	}
	@Override
	public CreditPo getCredit(int id) {
		// TODO Auto-generated method stub
		return creditblservice.getCredit(id);
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
	public String[] getProvince() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public String[] getRelatedCity(int p) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public String[] getRelatedDistrict(int c) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public String[] getRelatedCommercial(int c) {
		// TODO Auto-generated method stub
		return null;
	}

}
