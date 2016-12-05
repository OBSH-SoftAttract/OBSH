package blserviceImpl;

import java.util.List;

import blservice.HotelBLService;
import blservice.HotelroomBLService;
import data.dao.HotelDao;
import data.dao.HotelroomDao;
import data.dao.impl.HotelDaoImpl;
import data.dao.impl.HotelroomDaoImpl;
import po.HotelPo;
import po.HotelroomPo;
import vo.HotelVo;

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
	public List<HotelPo> SortByStar(int star, List<HotelPo> list) {
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
		String detail = hotelpo.getLocation() + hotelpo.getBriefInfo() + hotelpo.getServices();

		return detail;
	}

	@Override
	public List<HotelPo> SortByPrice(double min, double max, List<HotelPo> list) {
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
	public List<HotelPo> SortByScore(double min, double max, List<HotelPo> list) {
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
	public List<HotelPo> SortByRoomType(String type, List<HotelPo> list) {
return null;
	}

	@Override
	public HotelPo SearchByName(String hotel) {
		return hoteldao.searchHotelByName(hotel);
	}

	@Override
	public String[] getRelatedCommercial(int c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HotelPo> AllHotels() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HotelPo SearchByNmae(String hotel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getProvince() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getRelatedCity(int p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getRelatedDistrict(int c) {
		// TODO Auto-generated method stub
		return null;
	}

}