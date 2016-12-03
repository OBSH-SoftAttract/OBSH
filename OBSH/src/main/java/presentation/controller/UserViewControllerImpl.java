package presentation.controller;

import blservice.HotelBLService;
import blservice.OrderBLService;
import blservice.UserBLService;
import blserviceImpl.OrderBLServiceImpl;
import blserviceImpl.UserBLServiceImpl;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import presentation.view.UserView;
import presentation.view.UserViewControllerService;
import vo.UserVo;

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
	public void backtoMain() {
		view.backtoMain();
	}
	@Override
	public void jumptoSearchHotelMainFrame() {
		view.jumptoSearchHotelMainFrame();
	}
	@Override
	public String[] getProvince() {
		return hotelService.getProvince();
	}
	@Override
	public String[] getRelatedCity(int p) {
		return hotelService.getRelatedCity(p);
	}
	@Override
	public String[] getRelatedDistrict(int c) {
		return hotelService.getRelatedDistrict(c);
	}
	@Override
	public String[] getRelatedCommercial(int c) {
		return hotelService.getRelatedCommercial(c);
	}
	@Override
	public void jumptoRegisterFrame() {
		view.jumptoRegisterFrame();
	}
	@Override
	public void jumptoUserMainFrame() {
		view.jumptoUserMainFrame();
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
}