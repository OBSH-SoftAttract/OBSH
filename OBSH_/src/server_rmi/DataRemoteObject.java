package server_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import blservice.*;
import blserviceImpl.*;
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
	public boolean login(long id, String password) {
		// TODO Auto-generated method stub
		return userblservice.login(id, password);
	}

	@Override
	public ArrayList<HotelroomVo> Views(String address, String commercialDistrict) {
		// TODO Auto-generated method stub
		return userblservice.Views(address, commercialDistrict);
	}

	@Override
	public boolean GetCredit(UserVo vo) {
		// TODO Auto-generated method stub
		return userblservice.GetCredit(vo);
	}

	@Override
	public void ModifyMessage(UserVo vo) {
		// TODO Auto-generated method stub
		userblservice.ModifyMessage(vo);
	}

	@Override
	public boolean ModifyHotelMessage(HotelroomVo vo) {
		// TODO Auto-generated method stub
		return userblservice.ModifyHotelMessage(vo);
	}

	@Override
	public void Administration(long id) {
		// TODO Auto-generated method stub
		userblservice.Administration(id);
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
	public ArrayList<HotelroomVo> filterbystate(int state) {
		// TODO Auto-generated method stub
		return userblservice.filterbystate(state);
	}

	@Override
	public ArrayList<HotelroomVo> SortByTime(ArrayList<HotelroomVo> list) {
		// TODO Auto-generated method stub
		return userblservice.SortByTime(list);
	}

	@Override
	public boolean ViewDetail(HotelroomVo hotel) {
		// TODO Auto-generated method stub
		return userblservice.ViewDetail(hotel);
	}

	@Override
	public void EndSearch() {
		// TODO Auto-generated method stub
		userblservice.EndSearch();
	}

	@Override
	public boolean AddClient(UserVo vo) {
		// TODO Auto-generated method stub
		return userblservice.AddClient(vo);
	}

	@Override
	public boolean GetOrderHistory(int id) {
		// TODO Auto-generated method stub
		return userblservice.GetOrderHistory(id);
	}

	@Override
	public void createByPersonal(long id, String birthday) {
		// TODO Auto-generated method stub
		memberblservice.createByPersonal(id, birthday);
	}

	@Override
	public void createByBusiness(long id, String name) {
		// TODO Auto-generated method stub
		memberblservice.createByBusiness(id, name);
	}

	@Override
	public int getRank(double credit) {
		// TODO Auto-generated method stub
		return memberblservice.getRank(credit);
	}

	@Override
	public boolean isMember(long id) {
		// TODO Auto-generated method stub
		return memberblservice.isMember(id);
	}

	@Override
	public boolean Cancellation(OrderVo ordervo) {
		// TODO Auto-generated method stub
		return orderblservice.Cancellation(ordervo);
	}

	@Override
	public String CancelTime(OrderVo ordervo) {
		// TODO Auto-generated method stub
		return orderblservice.CancelTime(ordervo);
	}

	@Override
	public boolean CancelKillCredit(OrderVo ordervo) {
		// TODO Auto-generated method stub
		return orderblservice.CancelKillCredit(ordervo);
	}

	@Override
	public boolean Assess(int score, String comment, OrderVo ordervo) {
		// TODO Auto-generated method stub
		return orderblservice.Assess(score, comment, ordervo);
	}

	@Override
	public boolean Add(OrderVo ordervo) {
		// TODO Auto-generated method stub
		return orderblservice.Add(ordervo);
	}

	@Override
	public boolean CreditCheck(OrderVo ordervo) {
		// TODO Auto-generated method stub
		return orderblservice.CreditCheck(ordervo);
	}

	@Override
	public PromotionVo CalPromotion(int userid) {
		// TODO Auto-generated method stub
		return orderblservice.CalPromotion(userid);
	}

	@Override
	public OrderVo CalPrice(PromotionVo vo1, OrderVo vo2) {
		// TODO Auto-generated method stub
		return orderblservice.CalPrice(vo1, vo2);
	}

	@Override
	public boolean Solve(OrderVo vo) {
		// TODO Auto-generated method stub
		return orderblservice.Solve(vo);
	}

	@Override
	public boolean ComplainDeal(OrderVo vo) {
		// TODO Auto-generated method stub
		return orderblservice.ComplainDeal(vo);
	}

	@Override
	public OrderVo ViewByID(int orderid) {
		// TODO Auto-generated method stub
		return orderblservice.ViewByID(orderid);
	}

	@Override
	public ArrayList<OrderVo> Views(int userid) {
		// TODO Auto-generated method stub
		return orderblservice.Views(userid);
	}

	@Override
	public ArrayList<OrderVo> ViewByCustom(int id) {
		// TODO Auto-generated method stub
		return orderblservice.ViewByCustom(id);
	}

	@Override
	public ArrayList<OrderVo> ViewByDaily(String date) {
		// TODO Auto-generated method stub
		return orderblservice.ViewByDaily(date);
	}

	@Override
	public ArrayList<OrderVo> ViewByState(int state) {
		// TODO Auto-generated method stub
		return orderblservice.ViewByState(state);
	}

	@Override
	public ArrayList<OrderVo> TimeSort(ArrayList<OrderVo> orderlist) {
		// TODO Auto-generated method stub
		return orderblservice.TimeSort(orderlist);
	}

	@Override
	public int CreateID() {
		// TODO Auto-generated method stub
		return orderblservice.CreateID();
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
	public boolean addUser(long id) {
		// TODO Auto-generated method stub
		return creditblservice.addUser(id);
	}

	@Override
	public double addCredit(double value) {
		// TODO Auto-generated method stub
		return creditblservice.addCredit(value);
	}

	@Override
	public double recoverCredit(double price, int tage) {
		// TODO Auto-generated method stub
		return creditblservice.recoverCredit(price, tage);
	}

	@Override
	public int judge(long id) {
		// TODO Auto-generated method stub
		return promotionblservice.judge(id);
	}

	@Override
	public PromotionVo createNewItem(PromotionVo vo) {
		// TODO Auto-generated method stub
		return promotionblservice.createNewItem(vo);
	}

	@Override
	public PromotionVo Del(PromotionVo vo) {
		// TODO Auto-generated method stub
		return promotionblservice.Del(vo);
	}

	@Override
	public PromotionVo update(PromotionVo vo) {
		// TODO Auto-generated method stub
		return promotionblservice.update(vo);
	}

	@Override
	public List getLineItem(String itemName) {
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

}