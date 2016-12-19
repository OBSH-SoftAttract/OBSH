package vo;

import java.io.Serializable;
import java.util.List;

public class HotelVo implements Serializable{
	private int hotelID;
	private String name;
	private int star;
	private String briefInfo;  //简介
	private String location;  //地址+商圈
	private List<String> summary;
	private String services;
	private String roomInfo;//房间类型+个数+价格  中间用分号区分
	private double score=0;
    private int scoreCount;
    private double minPrice;
	
	public HotelVo(int hotelID, String name, int star, String location, List<String> summary, String services,
			String roominfo,double s,String br,int sc) {
		this.hotelID = hotelID;
		this.name = name;
		this.star = star;
		this.location = location;
		this.summary = summary;
		this.services = services;
		this.roomInfo = roominfo;
		this.score=s;
		this.briefInfo=br;
		this.scoreCount = sc;
		
		this.minPrice=10000000;
		String rooms[]=roomInfo.split(";");
		for(int i=0;i<rooms.length;i++){
			String room[]=rooms[i].split("+");
			if( Double.parseDouble(room[2])<this.minPrice){
				this.minPrice=Double.parseDouble(room[2]);
			}
		}
	}

	public double getMinPrice() {
		return minPrice;
	}

	public int getHotelID() {
		return hotelID;
	}

	public void setHotelID(int hotelID) {
		this.hotelID = hotelID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public String getBriefInfo() {
		return briefInfo;
	}

	public void setBriefInfo(String briefInfo) {
		this.briefInfo = briefInfo;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<String> getSummary() {
		return summary;
	}

	public void setSummary(List<String> summary) {
		this.summary = summary;
	}

	public String getServices() {
		return services;
	}

	public void setServices(String services) {
		this.services = services;
	}

	public String getRoomInfo() {
		return roomInfo;
	}

	public void setRoomInfo(String roomInfo) {
		this.roomInfo = roomInfo;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public int getScoreCount() {
		return scoreCount;
	}

	public void setScoreCount(int scoreCount) {
		this.scoreCount = scoreCount;
	}



}