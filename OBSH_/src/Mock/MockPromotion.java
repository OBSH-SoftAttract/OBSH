package Mock;

import java.util.List;

import bl.Promotionbl.PromotionBLServiceImpl;
public class MockPromotion extends PromotionBLServiceImpl{
	List<String> PromotionLineItem;
	
	public MockPromotion (String itemName) {
		PromotionLineItem.add(itemName);
	}
	public List<String> getLineItem (String itemName) {
		return PromotionLineItem;
	}
}