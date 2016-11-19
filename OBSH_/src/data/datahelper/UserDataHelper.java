package data.datahelper;

import java.util.Map;

import po.UserPo;

public interface UserDataHelper {
	
	/**
	 * @return	从数据库中读取用户数�?
	 */
	public Map<Integer, UserPo> getUserData();
	
	/**
	 * 向数据库中写入用户数�?
	 * @param list
	 */
	public void updateUserData(Map<Integer, UserPo> map);

}

