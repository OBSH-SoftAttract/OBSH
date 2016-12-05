package blserviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import blservice.HotelBLService;
import blservice.HotelroomBLService;
import data.dao.HotelDao;
import data.dao.HotelroomDao;
import data.dao.impl.HotelDaoImpl;
import data.dao.impl.HotelroomDaoImpl;
import po.HotelPo;
import po.HotelroomPo;
import vo.HotelVo;
import vo.HotelroomVo;

public class HotelBLServiceImpl implements HotelBLService {

	HotelDao hoteldao;
	HotelroomDao hotelroomdao;
	HotelroomBLService hotelbl;

	public HotelBLServiceImpl() {
		hoteldao = HotelDaoImpl.getInstance();
		hotelroomdao=HotelroomDaoImpl.getInstance();
		hotelbl = new HotelroomBLServiceImpl();
	}

	@Override
	public boolean Addhotel(HotelVo hotelvo) {
		String id = String.valueOf(hotelvo.getHotelID());
		if (id.length() != 4)
			return false;
		return hoteldao.addHotelPo(new HotelPo(hotelvo));
	}

	@Override
	public List<HotelPo> FilterByStar(int star, List<HotelPo> list) {
		try{
			for (int i = 0; i < list.size();i++) {
			    if (list.get(i).getStar() != star)
				    list.remove(i--);
			}
		}catch(NullPointerException e){
			e.getStackTrace();
		}
       return list;
	}

	@Override
	public List<HotelPo> Views(String address, String commercialDistrict) {
		return hoteldao.searchHotelByLocation(address + "+" + commercialDistrict);
	}

	@Override
	public String ViewHotelDetail(int hotelid) {
		HotelPo hotelpo = hoteldao.getHotel(hotelid);
		String detail = hotelpo.getLocation() + "+"+hotelpo.getBriefInfo() + "+" +hotelpo.getServices();
		
		List<HotelroomPo> list=hotelroomdao.getHotelroomByHotelID(hotelid);
		Map<String,Object> map=new HashMap<String, Object>();
		
		for(int i=0;i<list.size();i++){
			if(!map.containsKey(list.get(i).getRoomType())){
				map.put(list.get(i).getRoomType(), null);
				detail=detail+"+"+list.get(i).getRoomType()+String.valueOf(list.get(i).getPrice());
			}
		}
		
		return detail;
	}

	/**
	 * 
	 * @param hotelid
	 * @return 获得该酒店最低价
	 */
	private double getHotelMinPrice(int hotelid) {
		List<HotelroomPo> list=hotelroomdao.getHotelroomByHotelID(hotelid);
		double price=0;
		try{
			price=list.get(0).getPrice();
			for(int i=1;i<list.size();i++){
				if(list.get(i).getPrice()<price)
					price=list.get(i).getPrice();
			}
		}catch(NullPointerException e){
			e.getStackTrace();
		}
		return price;
	}


	@Override
	public List<HotelPo> FilterByPrice(double min, double max, List<HotelPo> list) {
		try{
		      for(int i=0;i<list.size();i++){
			     List<HotelroomPo> roomlist= hotelroomdao.getHotelroomByHotelID(list.get(i).getHotelID());
			     double temp=max+1;
			     for(int j=0;j<roomlist.size();j++){
			    	 double p=roomlist.get(j).getPrice();
			    	 if(p<=max&&p>=min&&p<temp)
			    		 temp=p;
			     }
			     if(!(temp<max))
			    	 list.remove(i--);
		      }			
		}catch(NullPointerException e){
			e.getStackTrace();
}
		
		return list;

	}

	@Override
	public List<HotelPo> FilterByScore(double min, double max, List<HotelPo> list) {
		try{
		      for(int i=0;i<list.size();i++){
		    	  double score=list.get(i).getScore();
			    if(!(score<=max&&score>=min))
			    	list.remove(i--);
		      }			
		}catch(NullPointerException e){
			e.getStackTrace();
}
		
		return list;
	}

	@Override
	public List<HotelPo> FilterByRoomType(String type, List<HotelPo> list) {
		
        return null;
	}

	@Override
	public HotelPo SearchByName(String hotel) {
		return hoteldao.searchHotelByName(hotel);
	}

	@Override
	public List<HotelPo> SortByStar(List<HotelPo> list) {
		for(int i=0;i<list.size();i++){
			for(int j=1;j<list.size();j++){
				if(list.get(i).getStar()<list.get(j).getStar()){
					HotelPo temp=list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				}
			}
		}
		return list;
	}

	@Override
	public List<HotelPo> SortByPrice(List<HotelPo> list) {
		for(int i=0;i<list.size();i++){
			for(int j=1;j<list.size();j++){
				if(getHotelMinPrice(list.get(i).getHotelID())>
						getHotelMinPrice(list.get(j).getHotelID())){
					HotelPo temp=list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				}
			}
		}
		return list;
	}

	@Override
	public List<HotelPo> SortByScore(List<HotelPo> list) {
		for(int i=0;i<list.size();i++){
			for(int j=1;j<list.size();j++){
				if(list.get(i).getScore()<list.get(j).getScore()){
					HotelPo temp=list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				}
			}
		}
		return list;
	}


	@Override
	public List<HotelroomPo> SortByTime(List<HotelroomPo> list) {
		// TODO Auto-generated method stub
		return null;
	}


}