package blserviceImpl;

import java.rmi.RemoteException;
import java.util.List;

import blservice.OrderBLService;
import blservice.UserBLService;
import data.dao.CreditDao;
import data.dao.HotelDao;
import data.dao.UserDao;
import data.dao.impl.CreditDaoImpl;
import data.dao.impl.HotelDaoImpl;
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
	private final double DefaultCredit=0;
	private PresentTimeGet nowtime;
/*	private final static int ID=151250001;*/
	
	public UserBLServiceImpl(){
		userdao=UserDaoImpl.getInstance();
		hoteldao=HotelDaoImpl.getInstance();
		orderbl=new OrderBLServiceImpl();
		creditdao=CreditDaoImpl.getInstance();
		nowtime=new PresentTimeGet();
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
		
		CreditPo creditpo=new CreditPo(vo.getID(), nowtime.NowTime(), DefaultCredit);
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
		List<OrderPo> list=orderbl.ViewByCustom(id);
		return list;
	}

	@Override
	public List<CreditPo> getHistoryCredit(int id) throws RemoteException{
		return creditdao.getCredit(id);
	}



}
