package blservice;
import vo.PromotionVo;

public interface MemberBLService {
	
	/**
	 * 
	 * @param id
	 * @param birthday
	 * @return 添加个人会员
	 */
	public void createByPersonal (int id, String birthday);
	
	/**
	 * 
	 * @param id
	 * @param name
	 * @return 添加企业会员
	 */
	public void createByBusiness (int id, String name);
	
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
	public boolean isMember (int id);
}
