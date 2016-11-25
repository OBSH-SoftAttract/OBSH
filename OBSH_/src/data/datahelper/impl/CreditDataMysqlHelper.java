package data.datahelper.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import data.datahelper.CreditDataHelper;
import po.CreditPo;

public class CreditDataMysqlHelper implements CreditDataHelper {
	
	static String sql = null;  
	
	static JDBCHelper db1 = null;  
	
	static ResultSet ret = null; 
	
	static int sta; 
	
	@Override
	public Map<Integer, CreditPo> getCreditData() {
		// TODO Auto-generated method stub
		
		sql = "select *from credit";//SQL语句  
		db1 = new JDBCHelper(sql);//创建DBHelper对象  
		Map<Integer, CreditPo> map = new HashMap<Integer, CreditPo>();
		    
		try {  
			ret = db1.pst.executeQuery();//执行语句，得到结果集  
		    while (ret.next()) {  
		    	double credit= ret.getDouble(1); 
		        int userId = ret.getInt(2);  
		        Timestamp time = ret.getTimestamp(3) ;
		        String creditinfo = ret.getString(4); 
		           
		        CreditPo creditPo=new CreditPo(userId, credit, time, creditinfo); 
		        map.put(userId, creditPo);
		     }//显示数据  
		     ret.close();  
		     db1.close();//关闭连接  
		     } catch (SQLException e) {  
		    	 e.printStackTrace();  
			 }  
		return map;		
	}

	public void updateCreditData(Map<Integer, CreditPo> map) {
		// TODO Auto-generated method stub
		
		Iterator<Entry<Integer, CreditPo>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<Integer, CreditPo> entry = iterator.next();
			CreditPo creditPo = entry.getValue();

			sql = "update credit set credit = "+creditPo.getCredit()+",time = '"+creditPo.getTime()+"',creditinfo = '"+creditPo.getCreditInfo()+"where userid = "+creditPo.getUserId();//SQL语句 
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
	public void addCreditData(CreditPo creditPo) {
		// TODO Auto-generated method stub

		sql = "insert into credit value("+creditPo.getCredit()+","+creditPo.getUserId()+",'"+creditPo.getTime()+"','"+creditPo.getCreditInfo()+"')";
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
