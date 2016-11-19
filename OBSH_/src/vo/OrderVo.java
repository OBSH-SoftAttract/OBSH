package vo;

import po.OrderPo;
import po.UserPo;
/**
 * orderID		订单编号
 * orderState   订单状态
 * StartTime    订单开始时间
 * EndTime      订单生效时间
 * lastTime     订单最晚时间
 * userInfo     用户信息（用户名+信用值信息）
 * orderInfo 	订单详情
 * userInfo     用户信息（姓名+联系+信用值）
 */
public class OrderVo {

    private int orderID;
	
	private int orderState=-1;
	
	private String StartTime;
	
	private String EndTime;
	
	private String lastTime;
	
	private int userID;
	
	private double price;
	
	private int hotelID;
	
	private String roomInfo;
	
	private String userInfo;
	
	public OrderVo(OrderPo orderpo,UserPo userpo){
		super();
		
	}
	
	public OrderVo(int orderid,int orderstate,String starttime,String endtime,String lasttime,
			int userid,double pri,int hotelid,String roominfo,String userinfo){
		super();
		this.orderID=orderid;
		this.orderState=orderstate;
		this.StartTime=starttime;
		this.EndTime=endtime;
		this.lastTime=lasttime;
		this.userID=userid;
		this.price=pri;
		this.hotelID=hotelid;
		this.roomInfo=roominfo;
		this.userInfo=userinfo;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getOrderState() {
		return orderState;
	}

	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}

	public String getStartTime() {
		return StartTime;
	}

	public void setStartTime(String startTime) {
		StartTime = startTime;
	}

	public String getEndTime() {
		return EndTime;
	}

	public void setEndTime(String endTime) {
		EndTime = endTime;
	}

	public String getLastTime() {
		return lastTime;
	}

	public void setLastTime(String lastTime) {
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

	public String getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}
	

}
