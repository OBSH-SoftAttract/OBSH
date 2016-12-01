package blservice;
import vo.PromotionVo;

public interface MemberBLService {

	/**
	 * 
	 * @param id
	 * @return 添加用户的信息
	 */
	public boolean addUser(long id);
	
	/**
	 * 
	 * @param id
	 * @param birthday
	 */
	public void createByPersonal (long id, String birthday);
	
	/**
	 * 
	 * @param id
	 * @param name
	 */
	public void createByBusiness (long id, String name);
	
	/**
	 * 
	 * @param rank
	 * @return 获得会员等级
	 */
	public int getRank(double credit);
	
	/**
	 * 
	 * @param id
	 * @return 判断会员
	 */
	public boolean isMember (long id);
}
