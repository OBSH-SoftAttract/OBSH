package data.datahelper;

import java.util.Map;

import po.PromotionPo;

public interface PromotionDataHelper {
	
	/**
	 * @return	从数据库中读取促�?策略信息
	 */
	public Map<Integer,PromotionPo> getPromotionData();
	
	/**
	 * 向数据库中写入促�?策略信息
	 * @param list	
	 */
	public void updatePromotionData(Map<Integer,PromotionPo> map);

}