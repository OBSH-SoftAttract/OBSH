package bl.blservice;
import java.util.List;

import vo.PromotionVo;
public interface PromotionBLService {
	/**
	 * 
	 * @param id
	 * @return 确定营销策略表所属为酒店还是网站
	 */
	public int judge (long id);
	
	
	/**
	 * 
	 * @param vo
	 * @return 增加营销策略
	 */
	public PromotionVo createNewItem(PromotionVo vo);
	
	/**
	 * 
	 * @param vo
	 * @return 系统更新营销策略列表
	 */
	public PromotionVo Del(PromotionVo vo);
	
	/**
	 * 
	 * @param vo
	 * @return 系统更新营销策略列表
	 */
	public PromotionVo update (PromotionVo vo);
	
	/**
	 * 
	 * @param itemName
	 * @return 返回营销策略信息
	 */
	public List getLineItem(String itemName);
}
