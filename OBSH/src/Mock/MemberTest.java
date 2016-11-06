package Mock;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import bl.blservice.MemberBLService;
import bl.blservice.impl.MemberBLServiceImpl;

/**
 * 测试的是member的功能 
 * member与user的交互 isMember createByPerson createByBusiness 不单独测试isMember 对比测试
 * member与credit的交互  getRank
 * @author bxh
 */
public class MemberTest {
	@Test
	public void testgetRank () {
		MockCredit credit1 = new MockCredit(5000);
		MockCredit credit2 = new MockCredit(20000);
		
		MemberBLService member1 = new MemberBLServiceImpl();
		MemberBLService member2 = new MemberBLServiceImpl();
		
		assertEquals(1, member1.getRank(credit1.getCredit()));
		assertEquals(3, member2.getRank(credit2.getCredit()));
		
	}
	
	@Test
	public void testcreateByBusiness () {
		MockUser user1 = new MockUser(0, 151250002);
		MockUser user2 = new MockUser(0, 151250055);
		
		MemberBLService member1 = new MemberBLServiceImpl();
		MemberBLService member2 = new MemberBLServiceImpl();
		
		member1.addUser(user1.getId());
		member1.createByBusiness(user1.getId(),user1.getCorpoateName("蒙牛"));
		
		assertEquals(true,member1.isMember(user1.getId()));
		assertEquals(false,member2.isMember(user2.getId()));
	}
	
	@Test
	public void testcreateByPersonal () {
		MockUser user1 = new MockUser(0, 151250002);
		MockUser user2 = new MockUser(0, 151250053);
		
		MemberBLService member1 = new MemberBLServiceImpl();
		MemberBLService member2 = new MemberBLServiceImpl();
		
		member1.addUser(user1.getId());
		member1.createByPersonal(user1.getId(),user1.getBirthday(1997/11/23));
		
		assertEquals(true,member1.isMember(user1.getId()));
		assertEquals(false,member2.isMember(user2.getId()));
	}

}