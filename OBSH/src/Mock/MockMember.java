package Mock;

import blservice.MemberBLService;

public class MockMember extends MemberBLService{
	int rank;
	public  MockMember (int r) {
		rank = r;
	}
	public double getRank () {
		return rank;
	}
}
