package po;

import java.sql.Timestamp;

public class HotelroomPo {
	private int room;
	private Timestamp datein;
	private int id;
	private Timestamp dateoutpro;
	private Timestamp timeout;
	private String roomName;
    public HotelroomPo(){
    	super();
    }
    public HotelroomPo(int room,Timestamp datein,int id,Timestamp dateoutpro,Timestamp timeout,String roomName){
    	super();
    	this.room=room;
    	this.datein=datein;
    	this.id=id;
    	this.dateoutpro=dateoutpro;
    	this.timeout=timeout;
    	this.roomName = roomName;
    }
    public int getroom(){
    	return room;
    }
    public void setroom(int room){
    	this.room=room;
    }
    public Timestamp getdatein(){
    	return datein;
    }
    public void setdatein(Timestamp datein){
    	this.datein=datein;
    }
    public int getid(){
    	return id;
    }
    public void setid(int id){
    	this.id=id;
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