package data.datahelper.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import data.datahelper.HotelroomDataHelper;
import po.HotelroomPo;

public class HotelroomDataMysqlHelper implements HotelroomDataHelper {

	static String sql = null;  
	
	static JDBCHelper db1 = null;  
	
	static ResultSet ret = null; 
	
	static int sta;  
	
	@Override
	public Map<Integer, HotelroomPo> getHotelroomData() {
		// TODO Auto-generated method stub
		
		 sql = "select *from hotelroom";//SQL语句  
		 db1 = new JDBCHelper(sql);//创建DBHelper对象  
		 Map<Integer, HotelroomPo> map = new HashMap<Integer, HotelroomPo>();
		    
		 try {  
			 ret = db1.pst.executeQuery();//执行语句，得到结果集  
		     while (ret.next()) {  
		     int hotelId = ret.getInt(1); 
		     int roomId = ret.getInt(2);  
		     String roomName = ret.getString(3); 
		     Timestamp dateIn = ret.getTimestamp(4);
		     Timestamp dateOut = ret.getTimestamp(5);
		     Timestamp actualDateOut = ret.getTimestamp(6);
		            
		     HotelroomPo hotelroomPo=new HotelroomPo(roomId, dateIn, hotelId, dateOut, actualDateOut, roomName); 
		     map.put(roomId, hotelroomPo);
		 }//显示数据  
		     ret.close();  
		     db1.close();//关闭连接  
		 } catch (SQLException e) {  
		     e.printStackTrace();  
		     }  
		 return map;
	}

	@Override
	public void updateHotelroomData(Map<Integer, HotelroomPo> map) {
		// TODO Auto-generated method stub
		
		Iterator<Map.Entry<Integer, HotelroomPo>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry<Integer, HotelroomPo> entry = iterator.next();
			HotelroomPo hotelroomPo = entry.getValue();

			sql = "update hotelroom set hotelid = "+hotelroomPo.gethotelID()+
					",roomName = '"+hotelroomPo.getroomName()+
					"',datein = '"+hotelroomPo.getdatein()+
					"',dateout = '"+hotelroomPo.getdateoutpro()+
					"',actualdateout = '"+hotelroomPo.gettimeout()+
					"' where roomid = "+hotelroomPo.getroomID();//SQL语句 
			db1 = new JDBCHelper(sql);//创建DBHelper对象  
			try {
				sta = db1.pst.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		db1.close();//关闭连接
	}

	@Override
	public void addHotelroom(HotelroomPo hotelroomPo) {
		// TODO Auto-generated method stub

		sql = "insert into hotelroom value("+hotelroomPo.gethotelID()+
				","+hotelroomPo.getroomID()+
				",'"+hotelroomPo.getroomName()+
				"','"+hotelroomPo.getdatein()+
				"','"+hotelroomPo.getdateoutpro()+
				"','"+hotelroomPo.gettimeout()+"')";
		db1 = new JDBCHelper(sql);//创建DBHelper对象  
		try {
			sta = db1.pst.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db1.close();//关闭连接
	}
	
	@Override
	public void deleteHotelroom(int hotelroomId) {
		// TODO Auto-generated method stub
		
		sql = "delete from hotelroom where roomid = "+hotelroomId;
		db1 = new JDBCHelper(sql);//创建DBHelper对象  
		try {
			sta = db1.pst.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db1.close();//关闭连接
	}
}
