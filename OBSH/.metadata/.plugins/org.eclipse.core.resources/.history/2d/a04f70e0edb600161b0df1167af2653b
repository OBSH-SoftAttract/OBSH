package blserviceImpl;

import java.util.ArrayList;

import blservice.UserBLService;
import data.dao.UserDao;
import data.dao.impl.UserDaoImpl;
import po.HotelroomPo;
import po.UserPo;
import vo.HotelroomVo;
import vo.UserVo;

public class UserBLServiceImpl implements UserBLService{

	private UserDao userdao;
	
	public UserBLServiceImpl(){
		userdao=UserDaoImpl.getInstance();
	}
	
	@Override
	public boolean login(int id, String password) {
		return userdao.getUser(id).getPassword().equals(password);
	}
	
	@Override
	public ArrayList<HotelroomPo> Views(String address, String commercialDistrict) {
		return null;
	}

	@Override
	public boolean GetCredit(UserVo vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void ModifyMessage(UserVo vo) {
		userdao.getUser(vo.getID()).setPassword(vo.getPassword());
	}

	@Override
	public boolean ModifyHotelMessage(HotelroomVo vo) {
		return false;
	}

	@Override
	public void Administration(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean ModifyPassword(UserVo vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void Cancel(UserVo vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<HotelroomVo> filterbystate(int state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<HotelroomVo> SortByTime(ArrayList<HotelroomVo> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean ViewDetail(HotelroomVo hotel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean AddClient(UserVo vo) {
		UserPo po=new UserPo(vo);		
		return userdao.addUser(po);
	}

	@Override
	public boolean GetOrderHistory(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
