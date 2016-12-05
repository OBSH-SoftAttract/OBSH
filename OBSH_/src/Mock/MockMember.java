package Mock;

import blserviceImpl.MemberBLServiceImpl;

public class MockMember extends MemberBLServiceImpl{
	int rank;
	public  MockMember (int r) {
		rank = r;
	}
	public double getRank () {
		return rank;
	}
}
