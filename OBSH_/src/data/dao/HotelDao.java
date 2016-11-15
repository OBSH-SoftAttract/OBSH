package data.dao;
/**
 * @author bxh
 */
import po.HotelPo;

public interface HotelDao {
	/**
	 * @param hotelId
	 * @return	获取酒店信息
	 */
	public HotelPo getHotel(int hotelId);
	
	/**
	 * @param hotelPo
	 * @return	更新酒店信息
	 */
	public boolean updateHotel(HotelPo hotelPo);
	
	/**
	 * @param hotelPo
	 * @return	添加酒店
	 */
	public boolean addHotelPo(HotelPo hotelPo);
	
	/**
	 * @param hotelPo
	 * @return	删除酒店
	 */
	public boolean deleteOrderPo(int hotelId);

}
