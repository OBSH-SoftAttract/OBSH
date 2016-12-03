package blservice;
import java.util.List;

import po.HotelPo;
import vo.HotelVo;
public interface HotelBLService {
	/**
	 * 
	 * @param hotelNo
	 * @return 添加酒店
	 */
	public boolean Addhotel (HotelVo hotelvo);


	/**
	 * 
	 * @return 搜索所有酒店
	 */
	public List<HotelPo> AllHotels();
	
		/**
	 * 
	 * @param star
	 * @return 按星级搜索
	 */
	public List<HotelPo> SortByStar(int star,List<HotelPo> list);
	
	/**
	 * 
	 * @param min
	 * @param max
	 * @return 按原始价格区间搜索
	 */
	public List<HotelPo> SortByPrice(double min, double max,List<HotelPo> list);
	
	/**
	 * 
	 * @param min
	 * @param max
	 * @return 按评价区间搜索
	 */
	public List<HotelPo> SortByScore(double min, double max,List<HotelPo> list);
	
	/**
	 * 
	 * @param type
	 * @return 按房间类型搜索
	 */
	public List<HotelPo> SortByRoomType(String type,List<HotelPo> list);
	
	/**
	 * 
	 * @param hotel
	 * @return 直接搜索酒店名称
	 */
	public HotelPo SearchByNmae(String hotel);
	

	public String[] getProvince();


	public String[] getRelatedCity(int p);


	public String[] getRelatedDistrict(int c);


	public String[] getRelatedCommercial(int c);
}
