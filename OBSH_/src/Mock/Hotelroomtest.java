package Mock;

import static org.junit.Assert.*;

import org.junit.Test;

import bl.HotelRoombl.HotelroomBLService;
import bl.HotelRoombl.HotelroomBLServiceImpl;

public class Hotelroomtest {
	@Test
public void testAddroom(){
	MockHotelroom hotel = new MockHotelroom (10,00001,"2016-09-09","2016-09-11","2016-09-12");
	HotelroomBLService hotel1 = new HotelroomBLServiceImpl();
	int room1=hotel1.Addroom(20);	
	assertEquals(room1,30);
}
	@Test
	public void testTimein(){
	MockHotelroom hotel = new MockHotelroom (10,00001,"2016-09-09","2016-09-11","2016-09-12");
	HotelroomBLService hotel1 = new HotelroomBLServiceImpl();
	String datein=hotel1.Timein("2016-09-09");
	assertEquals(datein,"2016-09-09");
	}
	@Test
	public void testIDin(){
	MockHotelroom hotel = new MockHotelroom (10,00001,"2016-09-09","2016-09-11","2016-09-12");
	HotelroomBLService hotel1 = new HotelroomBLServiceImpl();
    int ID1=hotel1.IDin(00001);
    assertEquals(ID1,00001);
	}
	@Test
	public void testTimeoutpro(){
	MockHotelroom hotel = new MockHotelroom (10,00001,"2016-09-09","2016-09-11","2016-09-12");
	HotelroomBLService hotel1 = new HotelroomBLServiceImpl();
	String dateoutpro = hotel1.TimeOutpro("2016-09-11");
	assertEquals(dateoutpro,"2016-09-11");
	}
	@Test
	public void testTimeout(){
	MockHotelroom hotel = new MockHotelroom (10,00001,"2016-09-09","2016-09-11","2016-09-12");
	HotelroomBLService hotel1 = new HotelroomBLServiceImpl();
	String timeout = hotel1.Timeout("2016-09-12");
	assertEquals(timeout,"2016-09-12");
	}
	@Test
	public void testIDout(){
	MockHotelroom hotel = new MockHotelroom (10,00001,"2016-09-09","2016-09-11","2016-09-12");
	HotelroomBLService hotel1 = new HotelroomBLServiceImpl();
	int ID2=hotel1.IDout(00001);
	assertEquals(ID2,00001);
	}
}
