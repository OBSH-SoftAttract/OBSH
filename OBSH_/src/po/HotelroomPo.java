package po;

import java.sql.Timestamp;
/**
 * 
 * roomID  房间编号：301
 * TimeCheckIn  入住时间
 * hotelID 酒店的ID
 * AttemptedLeaveTime 预计退房时间
 * TimeCheckOut 退房时间
 * roomType  房间类型
 * ifOccupied 房间使用状态
 */
public class HotelroomPo {
	private int roomID;
	private Timestamp TimeCheckIn;
	private int hotelID;
	private Timestamp dateoutpro;
	private Timestamp TimeCheckOut;
	private String roomType;
	private boolean ifOccupied=false;

    public HotelroomPo(int roomID,Timestamp datein,int hotelID,Timestamp dateoutpro,
    		Timestamp timecheckout,String roomtype){
    	this.roomID=roomID;
    	this.TimeCheckIn=datein;
    	this.hotelID=hotelID;
    	this.dateoutpro=dateoutpro;
    	this.TimeCheckOut=timecheckout;
    	this.roomType = roomtype;
    }

	public int getRoomID() {
		return roomID;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	public Timestamp getTimeCheckIn() {
		return TimeCheckIn;
	}

	public void setTimeCheckIn(Timestamp timeCheckIn) {
		TimeCheckIn = timeCheckIn;
	}

	public int getHotelID() {
		return hotelID;
	}

	public void setHotelID(int hotelID) {
		this.hotelID = hotelID;
	}

	public Timestamp getDateoutpro() {
		return dateoutpro;
	}

	public void setDateoutpro(Timestamp dateoutpro) {
		this.dateoutpro = dateoutpro;
	}

	public Timestamp getTimeCheckOut() {
		return TimeCheckOut;
	}

	public void setTimeCheckOut(Timestamp timeCheckOut) {
		TimeCheckOut = timeCheckOut;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public boolean isIfOccupied() {
		return ifOccupied;
	}

	public void setIfOccupied(boolean ifOccupied) {
		this.ifOccupied = ifOccupied;
	}
                                                       
}