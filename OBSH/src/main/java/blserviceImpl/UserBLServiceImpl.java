package blserviceImpl;

import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import blservice.UserBLService;
import data.dao.CreditDao;
import data.dao.HotelDao;
import data.dao.OrderDao;
import data.dao.UserDao;
import data.dao.impl.CreditDaoImpl;
import data.dao.impl.HotelDaoImpl;
import data.dao.impl.OrderDaoImpl;
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
	private OrderDao orderdao;
	private CreditDao creditdao;
	private final double DefaultCredit=0;
	
	public UserBLServiceImpl(){
		userdao=UserDaoImpl.getInstance();
		hoteldao=HotelDaoImpl.getInstance();
		orderdao=OrderDaoImpl.getInstance();
		creditdao=CreditDaoImpl.getInstance();
	}
	
	@Override
	public boolean login(int id, String password) throws RemoteException{
		UserPo po=userdao.getUser(id);
		if(null==po)return false;
		return po.getPassword().equals(password);
	}
	
	@Override
	public boolean ModifyMessage(UserVo vo) throws RemoteException{
		UserPo po=new UserPo(vo);
		return userdao.updateUser(po);
	}

	@Override
	public boolean ModifyHotelMessage(HotelVo vo) throws RemoteException{
		return hoteldao.updateHotel(new HotelPo(vo));
	}

	@Override
	public void Administration(int id) throws RemoteException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean ModifyPassword(UserVo vo) throws RemoteException{
		UserPo po=userdao.getUser(vo.getID());
		po.setPassword(vo.getPassword());
		return userdao.updateUser(po);
	}


	@Override
	public boolean AddClient(UserVo vo) throws RemoteException{
		String id=String.valueOf(vo.getID());
		if(id.length()!=9)return false;
		
		UserPo po=new UserPo(vo);
		
		Date date=new Date();
		Timestamp now =new Timestamp(date.getTime());
		
		CreditPo creditpo=new CreditPo(vo.getID(), now, DefaultCredit);
		return userdao.addUser(po)&&creditdao.setCredit(creditpo);
	}
	
	@Override
	public boolean AddHotelMember(UserVo vo) throws RemoteException{
		String id=String.valueOf(vo.getID());
		if(id.length()!=4)return false;
		
		return userdao.addUser(new UserPo(vo));
	}

	@Override
	public boolean AddMarketer(UserVo vo) throws RemoteException{
		String id=String.valueOf(vo.getID());
		if(id.length()!=3)return false;
		
		return userdao.addUser(new UserPo(vo));
	}

	@Override
	public List<OrderPo> GetOrderHistory(int id) throws RemoteException{
		List<OrderPo> list=orderdao.getOrderByUserID(id);
		return list;
	}

	@Override
	public List<CreditPo> getHistoryCredit(int id) throws RemoteException{
		return creditdao.getCredit(id);
	}



}
