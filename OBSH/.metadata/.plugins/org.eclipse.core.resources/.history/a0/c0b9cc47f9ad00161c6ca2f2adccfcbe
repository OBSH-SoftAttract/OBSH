package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Mock.MockHotelroom;
import bl.HotelRoombl.HotelroomBLService;
import bl.HotelRoombl.HotelroomBLServiceImpl;

public class Hotelroomtest {
	@Test
	public void testAddroom() {
		MockHotelroom hotel = new MockHotelroom(10, 00001, "2016-09-09", "2016-09-11", "2016-09-12");
		HotelroomBLService hotel1 = new HotelroomBLServiceImpl();
		assertEquals(hotel.getRoom(), hotel1.Addroom(hotel.getroom()));
	}

	@Test
	public void testTimein() {
		MockHotelroom hotel = new MockHotelroom(10, 00001, "2016-09-09", "2016-09-11", "2016-09-12");
		HotelroomBLService hotel1 = new HotelroomBLServiceImpl();
		assertEquals(hotel.getDatein(), hotel1.Timein(hotel.getDatein()));
	}

	@Test
	public void testIDin() {
		MockHotelroom hotel = new MockHotelroom(10, 00001, "2016-09-09", "2016-09-11", "2016-09-12");
		HotelroomBLService hotel1 = new HotelroomBLServiceImpl();
		assertEquals(hotel.getId(), hotel1.IDin(hotel.getid()));
	}

	@Test
	public void testTimeoutpro() {
		MockHotelroom hotel = new MockHotelroom(10, 00001, "2016-09-09", "2016-09-11", "2016-09-12");
		HotelroomBLService hotel1 = new HotelroomBLServiceImpl();
		assertEquals(hotel.getDateoutpro(), hotel1.TimeOutpro(hotel.getdateoutpro()));
	}

	@Test
	public void testTimeout() {
		MockHotelroom hotel = new MockHotelroom(10, 00001, "2016-09-09", "2016-09-11", "2016-09-12");
		HotelroomBLService hotel1 = new HotelroomBLServiceImpl();
		assertEquals(hotel.getTimeout(), hotel1.Timeout(hotel.gettimeout()));
	}

	@Test
	public void testIDout() {
		MockHotelroom hotel = new MockHotelroom(10, 00001, "2016-09-09", "2016-09-11", "2016-09-12");
		HotelroomBLService hotel1 = new HotelroomBLServiceImpl();
		assertEquals(hotel.getId(), hotel1.IDout(hotel.getid()));
	}
}