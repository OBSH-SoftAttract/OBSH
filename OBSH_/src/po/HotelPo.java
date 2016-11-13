package po;

public class HotelPo {
	private int hotelNo;
	private String name;
	private int price;
	private int star;
	private String location;
	private String summary;
	private String services;
	private String kind;

	public HotelPo() {
		super();
	}

	public HotelPo(int hotelNo, String name, int price, int star, String location, String summary, String services,
			String kind) {
		super();
		this.hotelNo = hotelNo;
		this.name = name;
		this.price = price;
		this.star = star;
		this.location = location;
		this.summary = summary;
		this.services = services;
		this.kind = kind;
	}

	public int gethotelNo() {
		return hotelNo;
	}

	public void sethotelNo(int hotelNo) {
		this.hotelNo = hotelNo;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public int getprice() {
		return price;
	}

	public void setprice(int price) {
		this.price = price;
	}

	public int getstar() {
		return star;
	}

	public void setstar(int star) {
		this.star = star;
	}

	public String getlocation() {
		return location;
	}

	public void setlocation(String location) {
		this.location = location;
	}

	public String getsummary() {
		return summary;
	}

	public void setsummary(String summary) {
		this.summary = summary;
	}

	public String getservices() {
		return services;
	}

	public void setservices(String services) {
		this.services = services;
	}

	public String getkind() {
		return kind;
	}

	public void setkind(String kind) {
		this.kind = kind;
	}
}