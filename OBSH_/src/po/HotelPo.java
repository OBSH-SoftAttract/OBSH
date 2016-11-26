package po;

import java.util.List;

public class HotelPo {
	private int hotelNo;
	private String name;
	private int star;
	private String location;
	private List<String> summary;
	private String services;
	private String roomInfo;//房间类型+个数
	private double score=0;
	
	public HotelPo() {
		super();
	}

	public HotelPo(int hotelNo, String name, int star, String location, List<String> summary, String services,
			String roominfo,double s) {
		super();
		this.hotelNo = hotelNo;
		this.name = name;
		this.star = star;
		this.location = location;
		this.summary = summary;
		this.services = services;
		this.roomInfo = roominfo;
		this.score=s;
	}

	public int getHotelNo() {
		return hotelNo;
	}

	public void setHotelNo(int hotelNo) {
		this.hotelNo = hotelNo;
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
	
	public void addSummary(String summary){
		this.summary.add(summary);
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


}
