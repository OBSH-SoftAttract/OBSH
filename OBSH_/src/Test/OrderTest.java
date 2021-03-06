package Test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import Mock.MockHotelroom;
import Mock.MockUser;
import blserviceImpl.OrderList;


/**
 * 
 * @author hyf
 *
 */
public class OrderTest {
	@Test
	public void testAdd(){
		MockUser user=new MockUser(0,151250001);
		MockHotelroom hotelroom1=new MockHotelroom(001,201);
		MockHotelroom hotelroom2=new MockHotelroom(001,302);

		OrderList orderlist=new OrderList(user.getId());
		
		orderlist.addroom(hotelroom1.getId(),hotelroom1.getRoom());
		orderlist.addroom(hotelroom2.getId(),hotelroom2.getRoom());
		assertEquals(true,orderlist.addorder(orderlist));
	}
	
	@Test
	public void testCalPrice(){
		MockUser user=new MockUser(0,151250001);
		MockHotelroom hotelroom1=new MockHotelroom(001,201);
		MockHotelroom hotelroom2=new MockHotelroom(001,302);

		OrderList orderlist=new OrderList(user.getId());
		
		orderlist.addroom(hotelroom1.getId(),hotelroom1.getRoom());
		orderlist.addroom(hotelroom2.getId(),hotelroom2.getRoom());
		
		assertEquals(200,orderlist.total());
	}
	

}
