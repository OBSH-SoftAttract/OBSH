package blservice;
import java.util.List;

import po.HotelPo;
import po.HotelroomPo;
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
	 * @param address
	 * @param commercialDistrict
	 * @return 按地址和商圈
	 */
	public List<HotelPo> Views(String address, String commercialDistrict);
	
	/**
	 * 
	 * @param hotelid
	 * @return 详细信息：地址+简介+设施服务+客房类型+价格
	 */
	public String ViewHotelDetail(int hotelid);
		/**
	 * 
	 * @param star
	 * @return 按星级搜索
	 */
	public List<HotelPo> FilterByStar(int star,List<HotelPo> list);
	
	/**
	 * 
	 * @param list
	 * @return 按星级排序（由高到低）
	 */
	public List<HotelPo> SortByStar(List<HotelPo> list);
	
	/**
	 * 
	 * @param min
	 * @param max
	 * @return 按原始价格区间搜索
	 */
	public List<HotelPo> FilterByPrice(double min, double max,List<HotelPo> list);
	
	/**
	 * 
	 * @param list
	 * @return 按价格排序（由低到高）
	 */
	public List<HotelPo> SortByPrice(List<HotelPo> list);
	
	/**
	 * 
	 * @param min
	 * @param max
	 * @return 按评价区间搜索
	 */
	public List<HotelPo> FilterByScore(double min, double max,List<HotelPo> list);
	
	/**
	 * 
	 * @param list
	 * @return 按评分排序（由高到低）
	 */
	public List<HotelPo> SortByScore(List<HotelPo> list);
	
	/**
	 * 
	 * @param type
	 * @return 按房间类型搜索
	 */
	public List<HotelPo> FilterByRoomType(String type,List<HotelPo> list);
	
	/**
	 * 
	 * @param hotel
	 * @return 直接搜索酒店名称
	 */
	public HotelPo SearchByName(String hotel);

	/**
	 * 
	 * @param list
	 * @return 
	 */
	public List<HotelroomPo> SortByTime(List<HotelroomPo> list);
}
