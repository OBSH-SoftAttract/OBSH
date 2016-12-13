package application;

  
public final class OrderUndone {  
       private String orderid;  
       private String orderState;  
       private String StartTime;  
       private String EndTime;  
       private String lastTime;        
       private String userid;      
       private double price;
       private String hotelID;
       private String roomInfo;
         


    public String getorderid() {  
        return orderid;  
    }  
  

    public void setorderid(String orderid) {  
        this.orderid = orderid;  
    }  
      

    public String getorderState() {  
        return orderState;  
    }  
  

    public void setorderState(String orderState) {  
        this.orderState = orderState;  
    }  
      

 
    public String getStartTime() {  
        return StartTime;  
    }  

    public void setStartTime(String StartTime) {  
        this.StartTime = StartTime;  
    }  
  
    public String getEndTime() {  
        return EndTime;  
    }  
  
    /** 
     * @param progress the progress to set 
     */  
    public void setEndTime(String EndTime) {  
        this.EndTime = EndTime;  
    }   
      
    public String getlastTime() {  
        return lastTime;  
    }  
  
    public void setlastTime(String lastTime) {  
        this.lastTime = lastTime;  
    }  

    public String getuesrid() {  
        return userid;  
    }  
  
    public void setuserid(String userid) {  
        this.userid = userid;  
    }  
   
    public double getprice(){
    	return price;
    }
    
    public void setprice(double price){
    	this.price = price;
    }
    
    public String gethotelID() {  
        return hotelID;  
    }  
  
    public void sethotelID(String hotelID) {  
        this.hotelID = hotelID;  
    }  
    
    public String getroomInfo() {  
        return roomInfo;  
    }  
  
    public void setroomInfo(String roomInfo) {  
        this.roomInfo = roomInfo;  
    }       
    
}  