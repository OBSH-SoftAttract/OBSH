package data.dao.impl;
/**
 * 关于gethotelroom方法 由于唯一键值是roomid所以传入map的暂时是roomid 不知道能否有hotelid确定 之前确定roomid格式是hotelid+房间号
 *@author bxh
 */
import java.util.Map;

import data.dao.HotelroomDao;
import data.datahelper.DataFactory;
import data.datahelper.HotelroomDataHelper;
import data.datahelper.impl.DataFactoryImpl;
import po.HotelroomPo;

public class HotelroomDaoImpl implements HotelroomDao {
	
	private Map<Integer,HotelroomPo> map;
	
	private HotelroomDataHelper hotelroomDataHelper;
	
	private DataFactory dataFactory;
	
	private static HotelroomDaoImpl hotelroomDataServiceImpl;
	
	public static HotelroomDaoImpl getInstance(){
		if(hotelroomDataServiceImpl == null){
			hotelroomDataServiceImpl = new HotelroomDaoImpl();
		}
		return hotelroomDataServiceImpl;
	}
	
	public HotelroomDaoImpl(){
		if(map == null){
			dataFactory = new DataFactoryImpl();
			hotelroomDataHelper = dataFactory.getHotelroomDataHelper();
			map = hotelroomDataHelper.getHotelroomData();
		}
	}
	
	@Override
	public HotelroomPo getHotelroom(int hotelroomId) {
		// TODO Auto-generated method stub
		return map.get(hotelroomId);
	}

	@Override
	public boolean updateHotelroom(HotelroomPo hotelroomPo) {
		// TODO Auto-generated method stub
		int hotelroomId = hotelroomPo.getroomID();
		if(map.get(hotelroomId) != null){
			map.put(hotelroomId, hotelroomPo);
			hotelroomDataHelper.updateHotelroomData(map);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean addHotelroomPo(HotelroomPo hotelroomPo) {
		// TODO Auto-generated method stub
		int hotelroomId = hotelroomPo.getroomID();
		if(map.get(hotelroomId)==null){
			hotelroomDataHelper.addHotelroom(hotelroomPo);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteHotelroom(int hotelroomId) {
		// TODO Auto-generated method stub
		if(map.get(hotelroomId)!=null) {
			hotelroomDataHelper.deleteHotelroom(hotelroomId);;
			return true;
		}
		return false;
	}

}

