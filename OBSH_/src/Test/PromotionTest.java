package Test;


import static org.junit.Assert.*;

import java.sql.Timestamp;

import org.junit.Test;

import Mock.MockHotel;
import Mock.MockUser;
import blservice.PromotionBLService;
import blserviceImpl.PromotionBLServiceImpl;
import vo.PromotionVo;
/**
 * 测试的是promotion的类间协作功能 
 * judge与UserBLService、HotelBLService之间有协作 确定策略属于酒店还是网站
 * getLineItem 与 create一起进行测试 新创建一个策略 得到该策略信息
 * @author bxh
 */
public class PromotionTest {
	
	@Test
	public void testJudge () {
		MockUser user = new MockUser (1,00001);
		MockHotel hotel = new MockHotel ("中央酒店", 00025);
		
		PromotionBLService promotion1 = new PromotionBLServiceImpl();
		PromotionBLService promotion2 = new PromotionBLServiceImpl();
		
		/*assertEquals(0, promotion1.judge(user.getId()));*/
		assertEquals(1, promotion2.judge(hotel.getHotelId()));
	}
	
	@Test
	public void testgetLineItem() {
		MockHotel hotel = new MockHotel ("中央酒店", 00025);
		
		PromotionVo vo1 = new PromotionVo(1,hotel.getHotelName(), "酒店百年优惠", Timestamp.valueOf("20161106000000"), Timestamp.valueOf("20161113000000"), "房间八折提供早餐");
		
		PromotionBLService promotion1 = new PromotionBLServiceImpl();
		promotion1.createNewItem(vo1);
	
		assertEquals("中央酒店+2016/11/6+2016/11/13+房间八折提供早餐", promotion1.getLineItem("酒店百年优惠"));
	}

}
