package vo;

import java.util.Vector;
import po.HotelroomPo;

public class HotelroomVo extends Vector<String> {
	public HotelroomVo(int room, String datein, int id, String dateoutpro, String timeout) {
		this.add(String.valueOf(room));
		this.add(datein);
		this.add(String.valueOf(id));
		this.add(dateoutpro);
		this.add(timeout);
	}

	public int getroom() {
		return Integer.valueOf(this.get(0));
	}

	public String getdatein() {
		return this.get(1);
	}

	public int getid() {
		return Integer.valueOf(this.get(2));
	}

	public String getdateoutpro() {
		return this.get(3);
	}

	public String gettimeout() {
		return this.get(4);
	}

}
