package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Mock.MockHotel;
import blservice.HotelBLService;
import blserviceImpl.HotelBLServiceImpl;

public class HotelTest {
	@Test
	public void testAddhotel() {
		MockHotel Hotel1 = new MockHotel("overwahch", 01);
		HotelBLService hotel1 = new HotelBLServiceImpl();
		assertEquals(Hotel1.getId(), hotel1.Addhotel(Hotel1.getHotelId()));
	}

	@Test
	public void testAddprice() {
		MockHotel Hotel1 = new MockHotel("overwahch", 01);
		HotelBLService hotel1 = new HotelBLServiceImpl();
		assertEquals(Hotel1.getPrice(), hotel1.Addprice(Hotel1.getPrice()));
	}

	@Test
	public void testAddstar() {
		MockHotel Hotel1 = new MockHotel("overwahch", 01);
		HotelBLService hotel1 = new HotelBLServiceImpl();
		assertEquals(Hotel1.getstar(), hotel1.Addstar(Hotel1.getstar()));
	}

	@Test
	public void testAddlocation() {
		MockHotel Hotel1 = new MockHotel("overwahch", 01);
		HotelBLService hotel1 = new HotelBLServiceImpl();
		assertEquals(Hotel1.location(), hotel1.Addlocation("九乡河职业技术学院"));
	}

	@Test
	public void testAddsummary() {
		MockHotel Hotel1 = new MockHotel("overwahch", 01);
		HotelBLService hotel1 = new HotelBLServiceImpl();
		assertEquals(Hotel1.summary(), hotel1.Addsummary("good"));
	}

	@Test
	public void testAddservice() {
		MockHotel Hotel1 = new MockHotel("overwahch", 01);
		HotelBLService hotel1 = new HotelBLServiceImpl();
		assertEquals(Hotel1.services(), hotel1.Addservices("TV"));
	}

	@Test
	public void testAddkind() {
		MockHotel Hotel1 = new MockHotel("overwahch", 01);
		HotelBLService hotel1 = new HotelBLServiceImpl();
		assertEquals(Hotel1.kind(), hotel1.Addkind("sro,double"));
	}
}