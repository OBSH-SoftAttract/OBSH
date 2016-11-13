package Mock;

import static org.junit.Assert.*;

import org.junit.Test;

import bl.HotelRoombl.HotelBLService;
import bl.HotelRoombl.HotelBLServiceImpl;
public class HotelTest {
	@Test
	public void testAddhotel(){
		MockHotel Hotel1 = new MockHotel ("overwahch",01); 
		HotelBLService hotel1 = new HotelBLServiceImpl();
		int ID=hotel1.Addhotel(01);
		assertEquals (ID,01);
	}
	@Test
	public void testAddprice(){
		MockHotel Hotel1 = new MockHotel ("overwahch",01); 
		HotelBLService hotel1 = new HotelBLServiceImpl();
		int price=hotel1.Addprice(300);
		assertEquals(price,300);
	}
	@Test
	public void testAddstar(){
		MockHotel Hotel1 = new MockHotel ("overwahch",01); 
		HotelBLService hotel1 = new HotelBLServiceImpl();
		int star = hotel1.Addstar(4);
		assertEquals(star,4);
	}
	@Test
	public void testAddlocation(){
		MockHotel Hotel1 = new MockHotel ("overwahch",01); 
		HotelBLService hotel1 = new HotelBLServiceImpl();
		String location = hotel1.Addlocation("九乡河职业技术学院");
		assertEquals(location,"九乡河职业技术学院");
	}
	@Test
	public void testAddsummary(){
		MockHotel Hotel1 = new MockHotel ("overwahch",01); 
		HotelBLService hotel1 = new HotelBLServiceImpl();
		String summary = hotel1.Addsummary("good");
		assertEquals(summary,"good");
	}
	@Test
	public void testAddservice(){
		MockHotel Hotel1 = new MockHotel ("overwahch",01); 
		HotelBLService hotel1 = new HotelBLServiceImpl();
		String service = hotel1.Addservices("TV");
		assertEquals(service,"TV");
	}
	@Test
	public void testAddkind(){
		MockHotel Hotel1 = new MockHotel ("overwahch",01); 
		HotelBLService hotel1 = new HotelBLServiceImpl();
		String kind = hotel1.Addkind("sro,double");
		assertEquals(kind,"sro,double");
	}
}