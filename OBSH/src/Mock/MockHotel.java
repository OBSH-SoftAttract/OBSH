package Mock;

public class MockHotel {
	String hotelName;
	int id;
	double price;
	int star;
	String location;
	String summary;
	String services;
	String kind;


	public double getPrice(){
		return price;
	}
	public int getstar(){
		return star;
	}
	public String location(){
		return location;
	}
	public String summary(){
		return summary;
	}
	public String services(){
		return services;
	}
	public String kind(){
		return kind;
	}
	public MockHotel(String hotelName,int id) {
		// TODO Auto-generated constructor stub
	}

	public MockHotel(int i, String string) {
		// TODO Auto-generated constructor stub
	}

	public int getHotelId() {
		// TODO Auto-generated method stub
		return id;
	}

	public String getHotelName() {
		// TODO Auto-generated method stub
		return hotelName;
	}

}

