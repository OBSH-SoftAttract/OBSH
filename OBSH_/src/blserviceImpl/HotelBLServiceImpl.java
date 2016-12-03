package blserviceImpl;

import java.util.List;

import blservice.HotelBLService;
import data.dao.HotelDao;
import data.dao.impl.HotelDaoImpl;
import po.HotelPo;
import vo.HotelVo;

public class HotelBLServiceImpl implements HotelBLService {

	HotelDao hoteldao;

	public HotelBLServiceImpl() {
		hoteldao = HotelDaoImpl.getInstance();
	}

	@Override
	public boolean Addhotel(HotelVo hotelvo) {
		return hoteldao.addHotelPo(new HotelPo(hotelvo));
	}

	@Override
	public List<HotelPo> SortByStar(int star, List<HotelPo> list) {
		for (int i = 0; i < list.size();) {
			if (list.get(i).getStar() != star) {
				list.remove(i);
			} else
				i++;
		}
		return list;
	}

	@Override
	public List<HotelPo> AllHotels() {
		return null;
	}

	@Override
	public List<HotelPo> SortByPrice(double min, double max, List<HotelPo> list) {
		return null;
	}

	@Override
	public List<HotelPo> SortByScore(double min, double max, List<HotelPo> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HotelPo> SortByRoomType(String type, List<HotelPo> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HotelPo SearchByNmae(String hotel) {

		return null;
	}

	@Override
	public String[] getProvince() {
		return null;
	}

	@Override
	public String[] getRelatedCity(int p) {
		return null;
	}

	@Override
	public String[] getRelatedDistrict(int c) {
		return null;
	}

	@Override
	public String[] getRelatedCommercial(int c) {
		return null;
	}

}