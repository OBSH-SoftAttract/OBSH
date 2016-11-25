package data.dao;
/**
 * @author bxh
 */

import po.CreditPo;

public interface CreditDao {
	
	/**
	 * @param orderId
	 * @return	获取客户信用信息
	 */
	public CreditPo getCredit(int userId);
	
	/**
	 * @param creditPo
	 * @return  添加客户的信用信息
	 */
	public boolean setCredit(CreditPo creditPo);

	/**
	 * 
	 * @param creditPo
	 * @return  更新信用信息
	 */
	public boolean updateCredit(CreditPo creditPo);
	
	
}

