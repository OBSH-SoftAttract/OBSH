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
	public MockHotelroom(int i, int j) {
		// TODO Auto-generated constructor stub
	}
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDatein() {
		return datein;
	}
	public void setDatein(String datein) {
		this.datein = datein;
	}
	public String getDateoutpro() {
		return dateoutpro;
	}
	public void setDateoutpro(String dateoutpro) {
		this.dateoutpro = dateoutpro;
	}
	public String getTimeout() {
		return timeout;
	}
	public void setTimeout(String timeout) {
		this.timeout = timeout;
	}

}
