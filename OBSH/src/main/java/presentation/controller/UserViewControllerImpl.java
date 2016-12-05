package presentation.controller;

import blservice.HotelBLService;
import blservice.OrderBLService;
import blservice.UserBLService;
import blserviceImpl.OrderBLServiceImpl;
import blserviceImpl.UserBLServiceImpl;
import javafx.scene.Scene;
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
	public void backtoMain(Stage primaryStage) {
		view.backtoMain(primaryStage);
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
	public void jumptoSearchHotelMainFrame(Stage primaryStage) {
		view.jumptoSearchHotelMainFrame(primaryStage);
	}
	@Override
	public void jumptoRegisterFrame(Stage primaryStage) {
		view.jumptoRegisterFrame(primaryStage);
	}
	@Override
	public void jumptoUserMainFrame(Stage primaryStage) {
		view.jumptoUserMainFrame(primaryStage);
	}
	@Override
	public void jumptoCheckOrder(Stage primaryStage) {
		view.jumptoCheckOrder(primaryStage);
		
	}
	@Override
	public void jumptoMaintainPersonalInfo(Stage primaryStage) {
		view.jumptoMaintainPersonalInfo(primaryStage);		
	}
}