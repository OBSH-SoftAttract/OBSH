package data.datahelper.impl;

import java.sql.Date;
import java.sql.ResultSet;  
import java.sql.SQLException;

import data.dao.MemberDao;
import data.dao.UserDao;
import data.dao.impl.MemberDaoImpl;
import data.dao.impl.UserDaoImpl;
import po.MemberPo;
import po.UserPo;  

public class jdbcdemo {  

  static String sql = null;  
  static JDBCHelper db1 = null;  
  static ResultSet ret = null; 
  static int sta;
  static UserPo userPo = new UserPo(151250008, "233333","144", "比尔盖茨", 5000, true);
  static MemberPo memberPo = new MemberPo(151250004,Date.valueOf("1996-06-01"),null,2,"蔡赵辰+2600");
  
  public static void main(String[] args) { 
	  MemberDao memberDao = MemberDaoImpl.getInstance();
	  //MemberPo m = memberDao.getMember(memberPo.getUserId());
	  boolean b = memberDao.updateMember(memberPo);
	  MemberPo m = memberDao.getMember(memberPo.getUserId());
	  System.out.println(m.getMemberInfo());
	  	/*int isVIP ;
		if(userPo.getifVIP())
			isVIP = 1;
		else 
			isVIP = 0;
		sql = "update user set name = '"+userPo.getUsername()+"', password = '"+userPo.getPassword()+"',contactinfo = '"+userPo.getPhone()+"',credit = "+userPo.getCredit()+", isVIP = "+isVIP+" where id = "+userPo.getID();//SQL语句 
		db1 = new JDBCHelper(sql);//创建DBHelper对象  
		try {
			sta = db1.pst.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		db1.close();//关闭连接*/
      /*sql = "select *from member";//SQL语句  
      db1 = new JDBCHelper(sql);//创建DBHelper对象  

      try {  
          ret = db1.pst.executeQuery();//执行语句，得到结果集  
          while (ret.next()) {  
        	  int id = ret.getInt(1);  
	            String birthday = ret.getString(2);  
	            String corpoateName = ret.getString(3);  
	            int rank = ret.getInt(4); 
	            String memberInfo = ret.getString(5);
              System.out.println(id + "\t" + birthday + "\t"+ corpoateName + "\t" +rank+ "\t" +memberInfo );  
          }//显示数据  
          ret.close();  
          db1.close();//关闭连接  
      } catch (SQLException e) {  
          e.printStackTrace();  
      } */
  }  

}  
