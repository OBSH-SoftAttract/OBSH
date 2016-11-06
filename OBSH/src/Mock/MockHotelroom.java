package Mock;

import bl.HotelRoombl.HotelroomBLServiceImpl;

public class MockHotelroom extends HotelroomBLServiceImpl{
	int room;
	int id;
	String datein;
	String dateoutpro;
	String timeout;
	public MockHotelroom(int r,int id,String D1,String D2,String D3){
		room=r;
		datein=D1;
		dateoutpro=D2;
		timeout=D3;
	}
	public int getroom(){
		return room;
	}
	public String getdatein(){
		return datein;
	}
	public String getdateoutpro(){
		return dateoutpro;
	}
	public String gettimeout(){
		return timeout;
	}
}
