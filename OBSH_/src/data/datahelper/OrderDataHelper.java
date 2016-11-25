package data.datahelper;
//想了一下感觉这个类的接口方法定义有问题
import java.util.Map;

import po.OrderPo;

public interface OrderDataHelper {
	
	/**
	 * @return	从数据库中读取订单数据
	 */
	public Map<Integer,OrderPo> getOrderData();
	
	/**
	 * 向数据库中写入订单数据
	 * @param list	
	 */
	public void updateOrderData(Map<Integer,OrderPo> map);

	/**
	 * 添加订单
	 * @param orderPo
	 */
	public void addOrderData(OrderPo orderPo);

	/**
	 * 删除订单
	 * @param orderId
	 */
	public void deleteOrderData(int orderId);

}

