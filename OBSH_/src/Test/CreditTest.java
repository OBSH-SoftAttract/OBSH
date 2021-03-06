package Test;


/**
 * order和credit间的协作 共同完成申诉恢复信用 
 * 执行对用户的信用充值 测试addUser 和addCredit
 * @author bxh
 */


import static org.junit.Assert.*;
import org.junit.Test;
import Mock.MockOrder;
import Mock.MockUser;
import blservice.CreditBLService;
import blserviceImpl.CreditBLServiceImpl;


public class CreditTest {
	@Test
	public void testaddcredit () {
		MockUser User1 = new MockUser(0, 151250001);
		
		CreditBLService credit1 = new CreditBLServiceImpl(); //初始为0
		/*credit1.addUser(User1.getId());
	
		assertEquals(700, credit1.addCredit(200), 700);*/
	}

	@Test
	public void testRecovercredit () {
		MockOrder Order1 = new MockOrder (100,0);
		MockOrder Order2 = new MockOrder (100,1);
		
		/*CreditBLService credit1 = new CreditBLServiceImpl();
		double c1 = credit1.recoverCredit(Order1.getPrice(),Order1.getTag());
		CreditBLService credit2 = new CreditBLServiceImpl();
		double c2 = credit2.recoverCredit(Order2.getPrice(),Order2.getTag());
		
		assertEquals(50, c1, 50);
		assertEquals(100, c2, 100);*/
		
	}
}
