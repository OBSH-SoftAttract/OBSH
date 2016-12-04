package vo;

import java.sql.Timestamp;
import java.util.Vector;


public class HotelroomVo extends Vector<String> {
	private int roomID;
	private Timestamp datein;
	private int hotelID;
	private Timestamp dateoutpro;
	private Timestamp timeout;
	private String roomName;

    public HotelroomVo(int roomID,Timestamp datein,int hotelID,Timestamp dateoutpro,Timestamp timeout,String roomName){
    	this.roomID=roomID;
    	this.datein=datein;
    	this.hotelID=hotelID;
    	this.dateoutpro=dateoutpro;
    	this.timeout=timeout;
    	this.roomName = roomName;
    }
    public int getroomID(){
    	return roomID;
    }
    public void setroomID(int roomID){
    	this.roomID = roomID;
    }
    public Timestamp getdatein(){
    	return datein;
    }
    public void setdatein(Timestamp datein){
    	this.datein = datein;
    }
    public int gethotelID(){
    	return hotelID;
    }
    public void setid(int hotelID){
    	this.hotelID=hotelID;
    }
    public Timestamp getdateoutpro(){
    	return dateoutpro;
    }
    public void setdateoutpro(Timestamp dateoutpro){
    	this.dateoutpro=dateoutpro;
    }
    public Timestamp gettimeout(){
    	return timeout;
    }
    public void settimeout(Timestamp timeout){
    	this.timeout=timeout;
    }
    public String getroomName(){
    	return roomName;
    }
    public void setroom(String roomName){
    	this.roomName = roomName;
    }
}
