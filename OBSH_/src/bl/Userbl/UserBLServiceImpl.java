package bl.Userbl;

import java.util.ArrayList;

import bl.Userbl.UserBLService;
import vo.HotelroomVo;
import vo.UserVo;

public class UserBLServiceImpl implements UserBLService{

	@Override
	public boolean login(long id, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<HotelroomVo> Views(String address, String commercialDistrict) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean GetCredit(UserVo vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void ModifyMessage(UserVo vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean ModifyHotelMessage(HotelroomVo vo) {
		// TODO Auto-generated method stub
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
	public void EndSearch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean AddClient(UserVo vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean GetOrderHistory(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
