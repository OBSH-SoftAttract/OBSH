package blservice;

import java.rmi.RemoteException;

import vo.HotelroomVo;

public interface HotelroomBLService {
	
	/**
	 * 
	 * @param room
	 * @return 添加客房
	 */
	public boolean Addroom(HotelroomVo vo)throws RemoteException;
	
}
