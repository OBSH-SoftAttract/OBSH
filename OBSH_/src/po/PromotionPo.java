package po;

/**
 * id                 自动判断id是属于酒店还是网站营销人员
 * itemName           策略名称
 * startTime          策略适用开始时间
 * endTime            策略适用结束时间
 * promotionInfo      策略详细信息
 * @author bxh
 */
public class PromotionPo {

	private int id;
	
	private String itemName;
	
	private String startTime;
	
	private String endTime;
	
	private String promotionInfo;
	
	public PromotionPo(){
		super();
	}
	
	public PromotionPo(int id, String itemName, String startTime, String endTime, String promotionInfo) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.promotionInfo = promotionInfo;
	}
	
	public int getid() {
		return id;
	}
	
	public void setid(int id) {
		this.id = id;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public String getStartTime() {
		return startTime;
	}
	
	public void setStartTime(String startTime) {
		this.itemName = startTime;
	}
	
	public String getEndTime() {
		return endTime;
	}
	
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	public String getPromotionInfo() {
		return promotionInfo;
	}
	
	public void setPromotionInfo(String promotionInfo) {
		this.promotionInfo = promotionInfo;
	}
}
