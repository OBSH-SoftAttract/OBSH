package Mock;

import blservice.OrderBLService;

public class MockOrder extends OrderBLService{
	double price;     //订单价格
	int tag;      //标记 选择恢复一半信用0还是全部信用1
	public MockOrder (double p, int t) {
		price = p;
		tag = t;
	}
	public double getPrice () {
		return price;
	}
	public int getTag (){
		return tag;
	}
}

