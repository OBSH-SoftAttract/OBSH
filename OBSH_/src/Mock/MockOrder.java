package Mock;

import bl.Orderbl.OrderBLServiceImpl;

public class MockOrder extends OrderBLServiceImpl{
	double price;     //订单价格
	
	int tag;      //标记 选择恢复一半信用0还是全部信用1
	
    private int orderID;
	
	private int orderState;
	
	private String StartTime;
	
	private String EndTime;
	
	private String lastTime;
	
	private long userID;
	
	private int hotelID;
	
	private String roomInfo;
	
	private String userInfo;
	
	public MockOrder(int orderid,long userid,double pri,int hotelid,String roominfo){
		this.orderID=orderid;
		this.userID=userid;
		this.price=pri;
		this.hotelID=hotelid;
		this.roomInfo=roominfo;
	}
	public MockOrder (double p, int t) {
		price = p;
		tag = t;
	}
	public MockOrder(int i) {
		this.orderID=i;
	}
	public double getPrice () {
		return price;
	}
	public int getTag (){
		return tag;
	}
	
	public int getOrderID() {
		return orderID;
	}
	public int getOrderState() {
		return orderState;
	}
	public String getStartTime() {
		return StartTime;
	}
	public String getEndTime() {
		return EndTime;
	}
	public String getLastTime() {
		return lastTime;
	}
	public long getUserID() {
		return userID;
	}
	public int getHotelID() {
		return hotelID;
	}
	public String getRoomInfo() {
		return roomInfo;
	}
	public String getUserInfo() {
		return userInfo;
	}
}

