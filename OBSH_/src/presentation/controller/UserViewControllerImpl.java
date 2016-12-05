package presentation.controller;

import java.util.List;
import blservice.HotelBLService;
import blservice.OrderBLService;
import blservice.UserBLService;
import blserviceImpl.OrderBLServiceImpl;
import blserviceImpl.UserBLServiceImpl;
import javafx.stage.Stage;
import po.HotelPo;
import presentation.view.UserView;
import presentation.view.UserViewControllerService;
import vo.UserVo;
import vo.HotelVo;
import po.HotelPo;

public class UserViewControllerImpl implements UserViewControllerService{
	private int userId;
	private int password;
	private UserView view;
	private UserVo userVo;
	private OrderBLService orderService;	
	private UserBLService userService;
	private HotelBLService hotelService;
	
	public UserViewControllerImpl(int userId){
		this.userId=userId;
		orderService = new OrderBLServiceImpl();
		userService = new UserBLServiceImpl();
	}
	@Override
	public int getUserId() {
		return userId;
	}

	@Override
	public int getUserPassword() {
		return password;
	}

	@Override
	public void setView(UserView view) {
		this.view = view;	
	}

	@Override
	public boolean successLogin(int userId, String password){
		if(userVo.getID() == userId&&userVo.getPassword() == password){
			return true;
		}
		else{
			return false;
		}
	}
	@Override
	public String[] getHotelName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String[] getRelatedHotelStarLevel() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String[] getRelatedHotelPrice() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String[] getRelatedHotelMark() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void SortbyPopularity() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<HotelPo> Views(String address, String commercialDistrict) {
		return userService.Views(address, commercialDistrict);
	}
	@Override
	public void registeruser(String username, String password, String conpassword, String phonenum) {
		// TODO Auto-generated method stub
		
	}
}