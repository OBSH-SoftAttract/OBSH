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
	
	private int orderState;
	
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
	
	public OrderVo(int orderid,int orderstate,String starttime,String endtime,String lasttime,int userid,double pri,int hotelid,String roominfo,String userinfo){
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
	
	public int getOrderID(){
		return this.orderID;
	}
	
	public void setOrderID(int id){
		this.orderID=id;
	}
	
	public int getOrderState(){
		return this.orderState;
	}
	
	public void setOrderState(int orderstate){
		this.orderState=orderstate;
	}
	
	public String getStartTime(){
		return this.StartTime;
	}
	
	public void setStartTime(String starttime){
		this.StartTime=starttime;
	}
	
	public String getEndTime(){
		return this.EndTime;
	}
	
	public void setEndTime(String endtime){
		this.EndTime=endtime;
	}
	
	public String getlastTime(){
		return this.lastTime;
	}
	
	public void setlastTime(String lastime){
		this.lastTime=lastime;
	}
	
	public int getUserID(){
		return this.userID;
	}
	
	public void setUserID(int id){
		this.userID=id;
	}
	
	public double getPrice(){
		return this.price;
	}
	
	public void setPrice(double pri){
		this.price=pri;
	}
	
	public int getHotelID(){
		return this.hotelID;
	}
	
	public void setHotelID(int id){
		this.hotelID=id;
	}
	
	public String getroomInfo(){
		return this.roomInfo;
	}
	
	public void setroomInfo(String roominfo){
		this.roomInfo=roominfo;
	}
}
