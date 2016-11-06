package Mock;

import bl.blservice.impl.CreditBLServiceImpl;

public class MockCredit extends CreditBLServiceImpl{
	double credit;
	public MockCredit (double c) {
		credit = c;
	}
	public double getCredit () {
		return credit;
	}
}

