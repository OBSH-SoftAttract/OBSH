package presentation.controller;

import java.rmi.RemoteException;

import ResultMessage.ResultMessage;
import blservice.HotelBLService;
import blservice.OrderBLService;
import blservice.UserBLService;

import client_rmi.RemoteHelper_client;

import presentation.view.UserViewControllerService;
import vo.UserVo;


public class UserViewControllerImpl implements UserViewControllerService {
	private OrderBLService orderService;
	private UserBLService userService;
	private HotelBLService hotelService;

	public UserViewControllerImpl() {
		orderService = RemoteHelper_client.getInstance().getOrderBLService();
		userService = RemoteHelper_client.getInstance().getUserBLService();
	}

	@Override
	public ResultMessage Login(String id, String password) throws  RemoteException {
		// TODO Auto-generated method stub
		if(id.equals("")||password.equals(""))return ResultMessage.NULL;
		if (!isNum(id)||id.length()!=6)return ResultMessage.FormatWrong;
			return userService.login(Integer.parseInt(id), password);
	}
	
	@Override
	public ResultMessage Register(String id, String password, String phone) throws  RemoteException{
		// TODO Auto-generated method stub
		if(id.equals("")||password.equals("")||phone.equals(""))return ResultMessage.NULL;
		UserVo vo=new UserVo();
		vo.setID(Integer.parseInt(id));
		vo.setPassword(password);
		vo.setPhone(phone);
		return userService.AddClient(vo);
	}
	
	private static boolean isNum(String str) {
		for (int i = str.length(); --i >= 0;) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}


}