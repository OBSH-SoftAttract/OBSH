package Mock;

import bl.blservice.impl.PromotionBLServiceImpl;

import java.util.List;
public class MockPromotion extends PromotionBLServiceImpl{
	List<String> PromotionLineItem;
	
	public MockPromotion (String itemName) {
		PromotionLineItem.add(itemName);
	}
	public List<String> getLineItem (String itemName) {
		return PromotionLineItem;
	}
}