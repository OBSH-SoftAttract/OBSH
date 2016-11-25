package data.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import data.dao.OrderDao;
import data.datahelper.DataFactory;
import data.datahelper.OrderDataHelper;
import data.datahelper.impl.DataFactoryImpl;
import po.OrderPo;

public class OrderDaoImpl implements OrderDao {
	
	private Map<Integer,OrderPo> map;
	
	private OrderDataHelper orderDataHelper;
	
	private DataFactory dataFactory;
	
	private static OrderDaoImpl orderDataServiceImpl;
	
	public static OrderDaoImpl getInstance(){
		if(orderDataServiceImpl == null){
			orderDataServiceImpl = new OrderDaoImpl();
		}
		return orderDataServiceImpl;
	}
	
	public OrderDaoImpl(){
		if(map == null){
			dataFactory = new DataFactoryImpl();
			orderDataHelper = dataFactory.getOrderDataHelper();
			map = orderDataHelper.getOrderData();
		}
	}

	@Override
	public OrderPo getOrder(int orderId) {
		// TODO Auto-generated method stub
		return map.get(orderId);
	}
	
	@Override
	public List<OrderPo> getOrders(int hotelId) { 
		// TODO Auto-generated method stub
		
		List<OrderPo> orders = new ArrayList<OrderPo>();
		Iterator<Map.Entry<Integer, OrderPo>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry<Integer, OrderPo> entry = iterator.next();
			OrderPo orderPo = entry.getValue();
			
			if(orderPo.getHotelID()==hotelId)
				orders.add(orderPo);
		}
		return orders;
	}
	
	@Override
	public boolean updateOrder(OrderPo orderPo) {
		// TODO Auto-generated method stub
		
		int orderId = orderPo.getOrderID();
		if(map.get(orderId) != null){
			map.put(orderId, orderPo);
			orderDataHelper.updateOrderData(map);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean addOrderPo(OrderPo orderPo) {
		// TODO Auto-generated method stub
		
		int orderId = orderPo.getOrderID();
		if(map.get(orderId)==null){
			orderDataHelper.addOrderData(orderPo);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean deleteOrderPo(int orderId) {
		// TODO Auto-generated method stub
		
		if(map.get(orderId)!=null) {
			orderDataHelper.deleteOrderData(orderId);
			return true;
		}
		return false;
	}
}
