package po;

public class HotelroomPo {
	private int room;
	private String datein;
	private int id;
	private String dateoutpro;
	private String timeout;
    public HotelroomPo(){
    	super();
    }
    public HotelroomPo(int room,String datein,int id,String dateoutpro,String timeout){
    	super();
    	this.room=room;
    	this.datein=datein;
    	this.id=id;
    	this.dateoutpro=dateoutpro;
    	this.timeout=timeout;
    }
    public int getroom(){
    	return room;
    }
    public void setroom(int room){
    	this.room=room;
    }
    public String getdatein(){
    	return datein;
    }
    public void setdatein(String datein){
    	this.datein=datein;
    }
    public int getid(){
    	return id;
    }
    public void setid(int id){
    	this.id=id;
    }
    public String getdateoutpro(){
    	return dateoutpro;
    }
    public void setdateoutpro(String dateoutpro){
    	this.dateoutpro=dateoutpro;
    }
    public String gettimeout(){
    	return timeout;
    }
    public void settimeout(String timeout){
    	this.timeout=timeout;
    }
}