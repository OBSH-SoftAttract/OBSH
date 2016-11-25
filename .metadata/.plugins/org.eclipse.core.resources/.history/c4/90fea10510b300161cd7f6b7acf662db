package vo;

/**
 * id                 酒店或者网站营销人员id
 * itemName           策略名称
 * startTime          策略适用开始时间
 * endTime            策略适用结束时间
 * promotionInfo      策略详细信息
 * hotelMarketerInfo          酒店名称    
 * @author bxh
 */
import po.PromotionPo;
import po.UserPo;
import po.HotelPo;

public class PromotionVo {
	
	private int id;
	
	private String itemName;
	
	private String startTime;
	
	private String endTime;
	
	private String promotionInfo;
	
	private String hotelMarketerInfo;
	
	public PromotionVo(PromotionPo promotionPo, UserPo userPo) {
		super();
		this.id = promotionPo.getid();
		if(String.valueOf(id).length()==3) {          //用来区分是酒店工作人员还是网站营销人员的
			hotelMarketerInfo = userPo.getUsername();  
		}
		this.itemName = promotionPo.getItemName();
		this.startTime = promotionPo.getStartTime();
		this.endTime = promotionPo.getEndTime();
		this.promotionInfo = promotionPo.getPromotionInfo();
	}
	
	public PromotionVo(PromotionPo promotionPo, HotelPo hotelPo) {
		super();
		this.id = promotionPo.getid();
		if(String.valueOf(id).length()==4) {          //用来区分是酒店工作人员还是网站营销人员的
			hotelMarketerInfo = hotelPo.getName();
		} 
		this.itemName = promotionPo.getItemName();
		this.startTime = promotionPo.getStartTime();
		this.endTime = promotionPo.getEndTime();
		this.promotionInfo = promotionPo.getPromotionInfo();
	}
	
	public PromotionVo(int id, String hotelMarketerInfo, String itemName, String startTime, String endTime, String promotionInfo){
		this.id = id;
		this.hotelMarketerInfo = hotelMarketerInfo;
		this.itemName = itemName;
		this.promotionInfo = promotionInfo;
		this.startTime = startTime;
		this.endTime  = endTime;
	}
	
	public int getId() {
		return id;
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
		this.startTime = startTime;
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
	
	public String getHotelMarketerInfo() {
		return hotelMarketerInfo;
	}
	
	public void setHotelMarketerInfo(String hotelMarketerInfo) {
		this.hotelMarketerInfo = hotelMarketerInfo;
	}

}