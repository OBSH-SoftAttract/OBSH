package data.dao;
/**
 * @author bxh
 */
import java.util.List;

import po.PromotionPo;

public interface PromotionDao {
	
	/**
	 * @param itemName
	 * @return	获取促销策略信息
	 */
	public PromotionPo getPromotion(String itemName);
	
	/** 
	 * @return  获取促销策略列表
	 */
	public List<String> getLineItem();
	
	/**
	 * @param PromotionPo
	 * @return	更新促销策略信息
	 */
	public boolean updatePromotion(PromotionPo promotionPo);
	
	/**
	 * @param MemberPo
	 * @return	添加促销策略
	 */
	public boolean addPromotionPo(PromotionPo promotionPo);
	
	/**
	 * @param itemName
	 * @return	删除促销策略
	 */
	public boolean deletePromotionPo(String itemName);

}

