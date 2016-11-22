package data.datahelper.impl;

import java.sql.ResultSet;  
import java.sql.SQLException;  

public class jdbcdemo {  

  static String sql = null;  
  static JDBCHelper db1 = null;  
  static ResultSet ret = null;  

  public static void main(String[] args) {  
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
              System.out.println(uid + "\t" + ufname + "\t" + upassword + "\t" + contactinfo+ "\t" +credit );  
          }//显示数据  
          ret.close();  
          db1.close();//关闭连接  
      } catch (SQLException e) {  
          e.printStackTrace();  
      }  
  }  

}  
