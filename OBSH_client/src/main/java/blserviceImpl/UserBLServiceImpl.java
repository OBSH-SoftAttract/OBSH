package blserviceImpl;

import java.rmi.RemoteException;
import java.util.List;

import ResultMessage.ResultMessage;
import blservice.OrderBLService;
import blservice.UserBLService;
import data.dao.CreditDao;
import data.dao.HotelDao;
import data.dao.HotelStaffDao;
import data.dao.MarketerDao;
import data.dao.UserDao;
import data.dao.impl.CreditDaoImpl;
import data.dao.impl.HotelDaoImpl;
import data.dao.impl.HotelStaffDaoImpl;
import data.dao.impl.MarketerDaoImpl;
import data.dao.impl.UserDaoImpl;
import po.CreditPo;
import po.HotelPo;
import po.OrderPo;
import po.UserPo;
import vo.HotelVo;
import vo.UserVo;

public class UserBLServiceImpl implements UserBLService{

	private UserDao userdao;
	private HotelDao hoteldao;
	private CreditDao creditdao;
	private OrderBLService orderbl;
	private MarketerDao marketerdao;
	private HotelStaffDao hotelstaffdao;
	private final double DefaultCredit=0;
	private PresentTimeGet nowtime;
	
	public UserBLServiceImpl(){
		userdao=UserDaoImpl.getInstance();
		hoteldao=HotelDaoImpl.getInstance();
		orderbl=new OrderBLServiceImpl();
		creditdao=CreditDaoImpl.getInstance();
		marketerdao=MarketerDaoImpl.getInstance();
		hotelstaffdao=HotelStaffDaoImpl.getInstance();
		nowtime=new PresentTimeGet();
	}
	
	@Override
	public ResultMessage login(int id, String password) {
		UserPo po=userdao.getUser(id);
		if(null==po)return ResultMessage.NotExist;
		if(!po.getPassword().equals(password))
			return ResultMessage.WrongPassword;
		else
			return ResultMessage.PASS;
	}
	
	@Override
	public ResultMessage ModifyMessage(UserVo vo) {
		UserPo po=new UserPo(vo);
		if( userdao.updateUser(po))
			return ResultMessage.UpdateSuccess;
		return ResultMessage.UpdateFail;
	}

	@Override
	public ResultMessage ModifyHotelMessage(HotelVo vo){
		if(hoteldao.updateHotel(new HotelPo(vo)))
			return ResultMessage.UpdateSuccess;
		return ResultMessage.UpdateFail;
	}

	@Override
	public ResultMessage ModifyPassword(UserVo vo) {
		UserPo po=userdao.getUser(vo.getID());
		po.setPassword(vo.getPassword());
		if(userdao.updateUser(po))
			return ResultMessage.UpdateSuccess;
		return ResultMessage.UpdateFail;
	}


	@Override
	public int AddClient(UserVo vo) {	
		UserPo po=new UserPo(vo);
		int userid=userdao.addUser(po);
		CreditPo creditpo=new CreditPo(userid, nowtime.NowTime(), DefaultCredit);
		creditdao.setCredit(creditpo);
		return userid;
	}
	
	@Override
	public ResultMessage AddHotelMember(UserVo vo) {
		String id=String.valueOf(vo.getID());
		if(id.length()!=4)return ResultMessage.FormatWrong;
		
		if(hotelstaffdao.addHotelStaff(new UserPo(vo)))return ResultMessage.Success;
		return ResultMessage.IDExsit;
	}

	@Override
	public ResultMessage AddMarketer(UserVo vo) {
		String id=String.valueOf(vo.getID());
		if(id.length()!=3)return ResultMessage.FormatWrong;
		
		if(marketerdao.addMarketer(new UserPo(vo)))return ResultMessage.Success;
		return ResultMessage.IDExsit;
	}

	@Override
	public List<OrderPo> GetOrderHistory(int id) throws RemoteException {
		List<OrderPo> list=orderbl.ViewByCustom(id);
		return list;
	}

	@Override
	public List<CreditPo> getHistoryCredit(int id) {
		return creditdao.getCredit(id);
	}


	@Override
	public UserPo GetUserByID(int ID)  {
		return userdao.getUser(ID);
	}



}
