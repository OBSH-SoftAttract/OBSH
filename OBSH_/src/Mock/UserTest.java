package Mock;

import static org.junit.Assert.*;
import org.junit.Test;
import bl.Userbl.UserBLService;
import bl.Userbl.UserBLServiceImpl;
import vo.UserVo;

public class UserTest {
	@Test
	public void testAddClient(UserVo vo){
		MockUser User1=new MockUser(0,151250001);
		UserBLService user1 = new UserBLServiceImpl();
		assertEquals(User1.AddClient(),user1.AddClient(vo));
	}
}