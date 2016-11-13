package Mock;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import bl.Orderbl.*;
import vo.OrderVo;


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
		
		assertEquals(true,orderlist.addorder(orderlist));
	}
	
	@Test
	public void testCalPrice(){
		MockHotel hotel1=new MockHotel(001,"101 双人间 200");
		OrderlineItem orderlineItem1=new OrderlineItem(hotel1,1);
		
		OrderList orderlist=new OrderList();
		orderlist.addorder(orderlineItem1);
		assertEquals(200,orderlist.total());
	}
	

}
