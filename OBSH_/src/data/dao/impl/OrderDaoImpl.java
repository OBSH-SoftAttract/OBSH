package data.dao.impl;

import java.util.List;

import data.dao.OrderDao;
import po.OrderPo;

public class OrderDaoImpl implements OrderDao {
	private static OrderDaoImpl Orderdao = new OrderDaoImpl();
	public static OrderDaoImpl getInstance(){
		return Orderdao;
	}
	@Override
	public OrderPo getOrder(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<OrderPo> getOrders(int hotelId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean updateOrder(OrderPo orderPo) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean addOrderPo(OrderPo orderPo) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean deleteOrderPo(int orderId) {
		// TODO Auto-generated method stub
		return false;
	}
}
