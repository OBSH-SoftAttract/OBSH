package blservice;

import java.util.ArrayList;

import vo.HotelroomVo;
import vo.UserVo;

public interface UserBLService {
	
	/**
	 * 
	 * @param id
	 * @param password
	 * @return 登录
	 */
	public boolean login(long id, String password);
	
	/**
	 * 
	 * @param address
	 * @param commercialDistrict
	 * @return 获得酒店信息
	 */
	public ArrayList<HotelroomVo> Views(String address,String commercialDistrict);
	
	/**
	 * 
	 * @param vo
	 * @return 获得信用值
	 */
	public boolean GetCredit(UserVo vo);
	
	/**
	 * 
	 * @param vo
	 */
	public void ModifyMessage(UserVo vo);
	
	/**
	 * 
	 * @param vo
	 * @return 修改酒店信息
	 */
	public boolean ModifyHotelMessage(HotelroomVo vo);
	
	/**
	 * 
	 * @param id
	 */
	public void Administration(long id);
	
	/**
	 * 
	 * @param vo
	 * @return 修改密码
	 */
	public boolean ModifyPassword(UserVo vo);
	
	/**
	 * 
	 * @param vo
	 */
	public void Cancel(UserVo vo);
	
	/**
	 * 
	 * @param state
	 * @return 获得对应状态
	 */
	public ArrayList<HotelroomVo> filterbystate(int state);
	
	/**
	 * 
	 * @param list
	 * @return 获得按时间排序的酒店信息
	 */
	public ArrayList<HotelroomVo> SortByTime (ArrayList<HotelroomVo> list);
	
	/**
	 * 
	 * @param hotel
	 * @return 获得详细信息
	 */
	public boolean ViewDetail(HotelroomVo hotel);
	
	/**
	 * 
	 */
	public void EndSearch();
	
	/**
	 * 
	 * @param vo
	 * @return 添加用户
	 */
	public boolean AddClient(UserVo vo);
	
	/**
	 * 
	 * @param id
	 * @return 获得历史订单记录
	 */
	public boolean GetOrderHistory (int id);
}