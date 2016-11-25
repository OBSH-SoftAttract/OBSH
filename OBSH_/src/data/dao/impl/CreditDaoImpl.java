package data.dao.impl;
/**
 * 由于setcredit更改形参 所以项目中有报错
 */
import java.util.Map;

import data.dao.CreditDao;
import data.datahelper.CreditDataHelper;
import data.datahelper.DataFactory;
import data.datahelper.impl.DataFactoryImpl;
import po.CreditPo;

public class CreditDaoImpl implements CreditDao {
	
	private Map<Integer,CreditPo> map;
	
	private CreditDataHelper creditDataHelper;
	
	private DataFactory dataFactory;
	
	private static CreditDaoImpl creditDataServiceImpl;
	
	public static CreditDaoImpl getInstance(){
		if(creditDataServiceImpl == null){
			creditDataServiceImpl = new CreditDaoImpl();
		}
		return creditDataServiceImpl;
	}
	
	public CreditDaoImpl(){
		if(map == null){
			dataFactory = new DataFactoryImpl();
			creditDataHelper = dataFactory.getCreditDataHelper();
			map = creditDataHelper.getCreditData();
		}
	}
	
	@Override
	public CreditPo getCredit(int userId) {
		// TODO Auto-generated method stub
		return map.get(userId);
	}
	
	@Override
	public boolean updateCredit(CreditPo creditPo) {
		// TODO Auto-generated method stub
		
		int userId = creditPo.getUserId();
		if(map.get(userId) != null){
			map.put(userId, creditPo);
			creditDataHelper.updateCreditData(map);;
			return true;
		}
		return false;
	}
	
	@Override
	public boolean setCredit(CreditPo creditPo) {
		// TODO Auto-generated method stub
		
		int userId = creditPo.getUserId();
		if(map.get(userId)==null) {
			creditDataHelper.addCreditData(creditPo);
			return true;
		}
		return false;
	}
}
