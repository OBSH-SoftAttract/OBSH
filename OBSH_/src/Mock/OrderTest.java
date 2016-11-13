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
		MockUser user1=new MockUser(0,151250001);
		MockUser user2=new MockUser(0,151250002);
		MockHotel hotelroom1=new MockHotel("大酒店",001);
		
		OrderlineItem orderLineItem1=new OrderlineItem(user1);
		OrderlineItem orderLineItem2=new OrderlineItem(user2);
		
		OrderList orderlist=new OrderList();
		orderlist.addOrderLineItem(orderLineItem1);
		orderlist.addOrderLineItem(orderLineItem2);
		
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
