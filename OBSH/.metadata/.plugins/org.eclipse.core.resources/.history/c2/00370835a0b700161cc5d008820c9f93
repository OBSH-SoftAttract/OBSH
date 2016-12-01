package vo;

import java.util.Vector;
import po.HotelPo;

public class HotelVo extends Vector<String> {
	public HotelVo(int hotelNo, String name, int price, int star, String location, String summary, String services,
			String roominfo,double scor) {
		this.add(String.valueOf(hotelNo));
		this.add(name);
		this.add(String.valueOf(price));
		this.add(String.valueOf(star));
		this.add(location);
		this.add(summary);
		this.add(services);
		this.add(roominfo);
		this.add(String.valueOf(scor));
	}

	public int gethotelNo() {
		return Integer.valueOf(this.get(0));
	}

	public String getname() {
		return this.get(1);
	}

	public int getprice() {
		return Integer.valueOf(this.get(2));
	}

	public int getstar() {
		return Integer.valueOf(this.get(3));
	}

	public String getlocation() {
		return this.get(4);
	}

	public String getsummary() {
		return this.get(5);
	}

	public String getservices() {
		return this.get(6);
	}

	public String getroomInfo() {
		return this.get(7);
	}
	public double getscore() {
		return Double.valueOf(this.get(8));
	}	
}
