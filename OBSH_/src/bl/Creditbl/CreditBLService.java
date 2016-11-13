package bl.Creditbl;

public interface CreditBLService {
	
	/**
	 * 
	 * @param id
	 * @return 添加用户信息
	 */
	public boolean addUser (long id);
	
	/**
	 * 
	 * @param value
	 * @return 添加用户的信用值
	 */
	public double addCredit (double value);
	
	
	/**
	 * 
	 * @param b
	 * @param price
	 * @return 处理申诉恢复信用值
	 */
	public double recoverCredit (double price, int tage);
}