package data.dao;

import po.HotelroomPo;

public interface HotelroomDao {
	/**
	 * @param hotelId
	 * @return	获取酒店房间信息
	 */
	public HotelroomPo getHotelroom(int hotelroomId);
	
	/**
	 * @param hotelroomPo
	 * @return	更新酒店房间信息
	 */
	public boolean updateHotelroom(HotelroomPo hotelroomPo);
	
	/**
	 * @param hotelroomPo
	 * @return	添加酒店房间
	 */
	public boolean addHotelroomPo(HotelroomPo hotelroomPo);
	
	/**
	 * @param hotelroomPo
	 * @return	删除酒店房间
	 */
	public boolean deleteHotelroom(int hotelroomId);

}
