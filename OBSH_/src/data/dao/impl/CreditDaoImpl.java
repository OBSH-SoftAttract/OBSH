package data.dao.impl;

import data.dao.CreditDao;
import po.CreditPo;

public class CreditDaoImpl implements CreditDao {
	private static CreditDaoImpl creditdao = new CreditDaoImpl();
	public static CreditDaoImpl getInstance(){
		return creditdao;
	}
	@Override
	public CreditPo getCredit(int userId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public CreditPo setCredit(int userID, double credit) {
		// TODO Auto-generated method stub
		return null;
	}
}
