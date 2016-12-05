package po;

import java.sql.Timestamp;
/**
 * 
 * roomID                房间编号：301
 * TimeCheckIn           入住时间
 * hotelID               酒店的ID
 * AttemptedLeaveTime    预计退房时间
 * TimeCheckOut          退房时间
 * roomType              房间类型
 * price                 房间价格
 */
public class HotelroomPo {
	private int roomID;
	private Timestamp TimeCheckIn;
	private int hotelID;
	private Timestamp AttemptedLeaveTime;
	private Timestamp TimeCheckOut;
	private String roomType;
	private double price;

    public HotelroomPo(int roomID,Timestamp datein,int hotelID,Timestamp attemptedLeaveTime,
    		Timestamp timecheckout,String roomtype,double price){
    	this.roomID=roomID;
    	this.TimeCheckIn=datein;
    	this.hotelID=hotelID;
    	this.AttemptedLeaveTime=attemptedLeaveTime;
    	this.TimeCheckOut=timecheckout;
    	this.roomType = roomtype;
    	this.price = price;
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

	public Timestamp getAttemptedLeaveTime() {
		return AttemptedLeaveTime;
	}

	public void setAttemptedLeaveTime(Timestamp attemptedLeaveTime) {
		this.AttemptedLeaveTime = attemptedLeaveTime;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
                                                       
}