package blserviceImpl;

import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.util.Date;

import blservice.HotelroomBLService;
import data.dao.HotelroomDao;
import data.dao.impl.HotelroomDaoImpl;
import po.HotelroomPo;
import vo.HotelroomVo;

public class HotelroomBLServiceImpl implements HotelroomBLService{

	HotelroomDao hotelroomdao;
	
	public HotelroomBLServiceImpl(){
		hotelroomdao=HotelroomDaoImpl.getInstance();
	}
	
	@Override
	public boolean Addroom(HotelroomVo vo) throws RemoteException{
		HotelroomPo po=new HotelroomPo(vo);
		po.setIfOccupied(false);		
		return hotelroomdao.addHotelroomPo(po);
	}
	
	@Override
	public void CheckIn(HotelroomVo vo){
		Date date=new Date();
		Timestamp now=new Timestamp(date.getTime());
		HotelroomPo po=new HotelroomPo(vo);
		po.setTimeCheckIn(now);
		hotelroomdao.updateHotelroom(po);
	}

	@Override
	public void CheckOut(HotelroomVo vo) {
		Date date=new Date();
		Timestamp now=new Timestamp(date.getTime());
		HotelroomPo po=new HotelroomPo(vo);
		po.setTimeCheckOut(now);
		po.setIfOccupied(false);
		hotelroomdao.updateHotelroom(po);
	}

	@Override
	public void ModifyPrice(HotelroomVo vo) {
		HotelroomPo po=new HotelroomPo(vo);
		po.setPrice(vo.getPrice());
		hotelroomdao.updateHotelroom(po);
	}

}
