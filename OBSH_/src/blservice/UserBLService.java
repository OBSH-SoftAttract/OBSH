package blservice;

import java.util.List;
import po.CreditPo;
import po.HotelPo;
import po.OrderPo;
import vo.HotelVo;
import vo.HotelroomVo;
import vo.UserVo;

public interface UserBLService {
	
	/**
	 * 
	 * @param id
	 * @param password
	 * @return 登录
	 */
	public boolean login(int id, String password);
	
	/**
	 * 
	 * @param id
	 * @return 获得信用记录
	 */
	public List<CreditPo> getHistoryCredit(int id);
	
	/**
	 * 
	 * @param address
	 * @param commercialDistrict
	 * @return 获得对应地址商圈的酒店信息列表
	 */
	public List<HotelPo>  Views(String address,String commercialDistrict);
	
	/**
	 * 
	 * @param vo
	 * @return 修改客户信息
	 */
	public boolean ModifyMessage(UserVo vo);
	
	/**
	 * 
	 * @param vo
	 * @return 修改酒店信息
	 */
	public boolean ModifyHotelMessage(HotelVo vo);
	
	/**
	 * 
	 * @param id
	 */
	public void Administration(int id);
	
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
	public List<HotelroomVo> filterbystate(int state);
	
	/**
	 * 
	 * @param list
	 * @return 获得按时间排序的酒店信息
	 */
	public List<HotelroomVo> SortByTime (List<HotelroomVo> list);
	
	/**
	 * 
	 * @param hotel
	 * @return 获得详细信息
	 */
	public boolean ViewDetail(int hotelid);
	
	
	/**
	 * 
	 * @param vo
	 * @return 添加用户
	 */
	public boolean AddClient(UserVo vo);
	
	/**
	 * 
	 * @param vo
	 * @return 添加酒店工作人员(需要先添加酒店)
	 */
	public boolean AddHotelMember(UserVo vo);
	
	/**
	 * 
	 * @param vo
	 * @return 添加营销人员
	 */
	public boolean AddMarketer(UserVo vo);
	
	/**
	 * 
	 * @param id
	 * @return 获得历史订单记录
	 */
	public List<OrderPo> GetOrderHistory (int id);
	
}
