package Mock;

import bl.blservice.CreditBLService;

public class MockCredit extends CreditBLService{
	double credit;
	public MockCredit (double c) {
		credit = c;
	}
	public double getCredit () {
		return credit;
	}
}

