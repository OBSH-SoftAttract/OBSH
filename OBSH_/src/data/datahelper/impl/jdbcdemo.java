package data.datahelper.impl;

import java.sql.ResultSet;  
import java.sql.SQLException;

import po.UserPo;  

public class jdbcdemo {  

  static String sql = null;  
  static JDBCHelper db1 = null;  
  static ResultSet ret = null; 
  static int sta;
  static UserPo userPo = new UserPo(151250002, "151250002","15050526200", "LittlePainter", 4000, true);
  
  public static void main(String[] args) {  
	  /*int isVIP ;
		if(userPo.getifVIP())
			isVIP = 1;
		else 
			isVIP = 0;
		sql = "insert into user (id, name, password, contactinfo, credit, isVIP) values("+userPo.getID()+", '"+userPo.getUsername()+"' ,"+userPo.getPassword()+","+userPo.getPhone()+","+userPo.getCredit()+","+isVIP+")";
		db1 = new JDBCHelper(sql);//创建DBHelper对象  
		try {
			sta = db1.pst.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db1.close();//关闭连接
	  */
	  
	  
      sql = "select *from user";//SQL语句  
      db1 = new JDBCHelper(sql);//创建DBHelper对象  

      try {  
          ret = db1.pst.executeQuery();//执行语句，得到结果集  
          while (ret.next()) {  
              int uid = ret.getInt(1);  
              String ufname = ret.getString(2);  
              String upassword = ret.getString(3);  
              String contactinfo = ret.getString(4); 
              int credit = ret.getInt(5);
              int isVIP = ret.getInt(6);
              System.out.println(uid + "\t" + ufname + "\t"+ upassword + "\t" + contactinfo+ "\t" +credit+ "\t"+isVIP );  
          }//显示数据  
          ret.close();  
          db1.close();//关闭连接  
      } catch (SQLException e) {  
          e.printStackTrace();  
      } 
  }  

}  
