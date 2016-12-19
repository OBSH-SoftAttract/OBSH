package vo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * orderID		订单编号
 * orderState   订单状态（0：未执行订单；1：已执行订单；2：异常订单；3：已撤销订单）
 * StartTime    订单开始时间
 * EndTime      订单生效时间
 * lastTime     订单最晚时间
 * userID       用户的账号
 * price        订单价格
 * hotelID      酒店编号
 * roomInfo     房间信息(类型+个数)
 * evaluate     是否评价过
 */
public class OrderVo implements Serializable{

    private String orderID;
	
	private int orderState=-1;
	
	private Timestamp StartTime;
	
	private Timestamp EndTime;
	
	private Timestamp lastTime;
	
	private int userID;
	
	private double price;
	
	private int hotelID;
	
	private String roomInfo;
	
	private boolean evaluate;
	
	
	public OrderVo(String orderid,int orderstate,Timestamp starttime,Timestamp endtime,
			Timestamp lasttime,int userid,double pri,int hotelid,String roominfo,boolean evaluate){
		this.orderID=orderid;
		this.orderState=orderstate;
		this.StartTime=starttime;
		this.EndTime=endtime;
		this.lastTime=lasttime;
		this.userID=userid;
		this.price=pri;
		this.hotelID=hotelid;
		this.roomInfo=roominfo;
		this.evaluate=evaluate;
	}

	public boolean isEvaluate() {
		return evaluate;
	}

	public void setEvaluate(boolean evaluate) {
		this.evaluate = evaluate;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public int getOrderState() {
		return orderState;
	}

	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}

	public Timestamp getStartTime() {
		return StartTime;
	}

	public void setStartTime(Timestamp startTime) {
		StartTime = startTime;
	}

	public Timestamp getEndTime() {
		return EndTime;
	}

	public void setEndTime(Timestamp endTime) {
		EndTime = endTime;
	}

	public Timestamp getLastTime() {
		return lastTime;
	}

	public void setLastTime(Timestamp lastTime) {
		this.lastTime = lastTime;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getHotelID() {
		return hotelID;
	}

	public void setHotelID(int hotelID) {
		this.hotelID = hotelID;
	}

	public String getRoomInfo() {
		return roomInfo;
	}

	public void setRoomInfo(String roomInfo) {
		this.roomInfo = roomInfo;
	}


}
