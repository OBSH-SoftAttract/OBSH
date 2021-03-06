package data.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import data.dao.HotelDao;
import data.datahelper.DataFactory;
import data.datahelper.HotelDataHelper;
import data.datahelper.impl.DataFactoryImpl;
import po.HotelPo;

public class HotelDaoImpl implements HotelDao {
	
	private Map<Integer,HotelPo> map;
	
	private HotelDataHelper hotelDataHelper;
	
	private DataFactory dataFactory;
	
	private static HotelDaoImpl hotelDataServiceImpl;
	
	public static HotelDaoImpl getInstance(){
		if(hotelDataServiceImpl == null){
			hotelDataServiceImpl = new HotelDaoImpl();
		}
		return hotelDataServiceImpl;
	}
	
	public HotelDaoImpl(){
		if(map == null){
			dataFactory = new DataFactoryImpl();
			hotelDataHelper = dataFactory.getHotelDataHelper();
			map = hotelDataHelper.getHotel();
		}
	}
	
	@Override
	public HotelPo getHotel(int hotelId) {
		// TODO Auto-generated method stub
		return map.get(hotelId);
	}
	
	@Override
	public List<HotelPo> getAllHotel() {
		// TODO Auto-generated method stub
		
		List<HotelPo> hotel = new ArrayList<HotelPo>();
		Iterator<Entry<Integer, HotelPo>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<Integer, HotelPo> entry = iterator.next();
			HotelPo hotelPo = entry.getValue();
			hotel.add(hotelPo);
		}
		return hotel;
	}
	
	@Override
	public List<HotelPo> searchHotelByLocation(String location) { 
		// TODO Auto-generated method stub
		
		List<HotelPo> hotel = new ArrayList<HotelPo>();
		Iterator<Entry<Integer, HotelPo>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<Integer, HotelPo> entry = iterator.next();
			HotelPo hotelPo = entry.getValue();
			
			if(hotelPo.getLocation().equals(location))
				hotel.add(hotelPo);
		}
		return hotel;
	}
	
	@Override
	public List<HotelPo> searchHotelByName(String hotelName) { 
		// TODO Auto-generated method stub
		
		List<HotelPo> hotel = new ArrayList<HotelPo>();
		Iterator<Entry<Integer, HotelPo>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<Integer, HotelPo> entry = iterator.next();
			HotelPo hotelPo = entry.getValue();
			
			if(hotelPo.getName().equals(hotelName))
				hotel.add(hotelPo);
		}
		return hotel;
	}
	
	@Override
	public boolean updateHotel(HotelPo hotelPo) {
		// TODO Auto-generated method stub
		int hotelId = hotelPo.getHotelID();
		if(map.get(hotelId) != null){
			map.put(hotelId, hotelPo);
			hotelDataHelper.updateHotel(map);
			return true;
		}
		return false;
	}

	@Override
	public boolean addHotelPo(HotelPo hotelPo) {
		// TODO Auto-generated method stub
		int hotelId = hotelPo.getHotelID();
		if(map.get(hotelId)==null){
			hotelDataHelper.addHotelPo(hotelPo);
			return true;
		}
		return false;
		
		/*int hotelId = hotelPo.getHotelNo();  这里提供了第二种方法 不直接访问数据库 但可能数据层复杂
		if(map.get(hotelId)==null) {           将增加信息的map传入数据层中 遍历某一条数据库中没有 则加入
			map.put(hotelId, hotelPo);
			hotelDataHelper.addHotelPo(map);
			return true;
		}*/
	}

	@Override
	public boolean deleteOrderPo(int hotelId) {
		// TODO Auto-generated method stub
		
		if(map.get(hotelId)!=null) {
			hotelDataHelper.deleteHotelPo(hotelId);
			return true;
		}
		return false;
	}

}
