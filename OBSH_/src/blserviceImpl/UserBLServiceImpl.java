package blserviceImpl;

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
import po.HotelroomPo;
import po.OrderPo;
import po.UserPo;
import vo.HotelVo;
import vo.HotelroomVo;
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
	public boolean login(int id, String password) {
		return userdao.getUser(id).getPassword().equals(password);
	}
	
	@Override
	public List<HotelPo> Views(String address, String commercialDistrict) {
		return hoteldao.searchHotelByLocation(address+"+"+commercialDistrict);
	}

	@Override
	public boolean ModifyMessage(UserVo vo) {
		UserPo po=new UserPo(vo);
		return userdao.updateUser(po);
	}

	@Override
	public boolean ModifyHotelMessage(HotelVo vo) {
		return hoteldao.updateHotel(new HotelPo(vo));
	}

	@Override
	public void Administration(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean ModifyPassword(UserVo vo) {
		UserPo po=userdao.getUser(vo.getID());
		po.setPassword(vo.getPassword());
		return userdao.updateUser(po);
	}

	@Override
	public void Cancel(UserVo vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<HotelroomVo> filterbystate(int state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HotelroomVo> SortByTime(List<HotelroomVo> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean ViewDetail(int hotelid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean AddClient(UserVo vo) {
		String id=String.valueOf(vo.getID());
		if(id.length()!=9)return false;
		
		UserPo po=new UserPo(vo);
		
		Date date=new Date();
		Timestamp now =new Timestamp(date.getTime());
		
		CreditPo creditpo=new CreditPo(vo.getID(), now, DefaultCredit);
		return userdao.addUser(po)&&creditdao.setCredit(creditpo);
	}
	
	@Override
	public boolean AddHotelMember(UserVo vo) {
		String id=String.valueOf(vo.getID());
		if(id.length()!=4)return false;
		
		UserPo po=new UserPo(vo);
		return userdao.addUser(po);
	}

	@Override
	public boolean AddMarketer(UserVo vo) {
		String id=String.valueOf(vo.getID());
		if(id.length()!=3)return false;
		
		UserPo po=new UserPo(vo);
		return userdao.addUser(po);
	}

	@Override
	public List<OrderPo> GetOrderHistory(int id) {
		List<OrderPo> list=orderdao.getOrderByUserID(id);
		return list;
	}

	@Override
	public List<CreditPo> getHistoryCredit(int id) {
		return creditdao.getCredit(id);
	}

}
