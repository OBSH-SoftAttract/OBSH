package blservice;

import vo.HotelroomVo;

public interface HotelroomBLService {
	
	/**
	 * 
	 * @param room
	 * @return 添加客房
	 */
	public int Addroom (double room);
	
	/**
	 * 更新客房信息
	 */
	public void Updateroom ();
	
	/**
	 * 
	 * @param vo
	 * @return 录入客户入住
	 */
	public boolean Checkin (HotelroomVo vo);
	
	/**
	 * 
	 * @param datein
	 * @return 更新入住的时间
	 */
	public String Timein (String datein);
	
	/**
	 * 
	 * @param id
	 * @return 记录房间号
	 */
	public int IDin (int id);
	
	/**
	 * 
	 * @param dateoutpro
	 * @return 计算预计离开时间
	 */
	public String TimeOutpro (String dateoutpro);
	
	/**
	 * 
	 * @param timeout
	 * @return 计算退房时间
	 */
	public String Timeout (String timeout);
	
	/**
	 * 
	 * @param id
	 * @return 记录退房号
	 */
	public int IDout (int id);
}
