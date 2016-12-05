package blservice;

import java.rmi.RemoteException;
import java.util.List;

import po.CreditPo;
import po.HotelPo;
import po.HotelroomPo;
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
	public boolean login(int id, String password)throws RemoteException;
	
	/**
	 * 
	 * @param id
	 * @return 获得信用记录
	 */
	public List<CreditPo> getHistoryCredit(int id)throws RemoteException;
	
	
	/**
	 * 
	 * @param vo
	 * @return 修改客户信息
	 */
	public boolean ModifyMessage(UserVo vo)throws RemoteException;
	
	/**
	 * 
	 * @param vo
	 * @return 修改酒店信息
	 */
	public boolean ModifyHotelMessage(HotelVo vo)throws RemoteException;
	
	/**
	 * 
	 * @param id
	 */
	public void Administration(int id)throws RemoteException;
	
	/**
	 * 
	 * @param vo
	 * @return 修改密码
	 */
	public boolean ModifyPassword(UserVo vo)throws RemoteException;
	
	
	/**
	 * 
	 * @param vo
	 * @return 添加用户
	 */
	public boolean AddClient(UserVo vo)throws RemoteException;
	
	/**
	 * 
	 * @param vo
	 * @return 添加酒店工作人员(需要先添加酒店)
	 */
	public boolean AddHotelMember(UserVo vo)throws RemoteException;
	
	/**
	 * 
	 * @param vo
	 * @return 添加营销人员
	 */
	public boolean AddMarketer(UserVo vo)throws RemoteException;
	
	/**
	 * 
	 * @param id
	 * @return 获得历史订单记录
	 */
	public List<OrderPo> GetOrderHistory (int id)throws RemoteException	;
	
}