package blserviceImpl;

import java.rmi.RemoteException;

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
		HotelroomPo po=new HotelroomPo();
		po.setHotelID(vo.getHotelID());
		po.setRoomID(vo.getRoomID());
		po.setPrice(vo.getPrice());
		po.setRoomType(vo.getRoomType());
		po.setIfOccupied(false);
		
		return hotelroomdao.addHotelroomPo(po);
	}


}
