package vo;

/**
 * status             营销策略的所属（网站0 or酒店 1）
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
	
	private int status;
	
	private String itemName;
	
	private String startTime;
	
	private String endTime;
	
	private String promotionInfo;
	
	private String hotelMarketerInfo;
	
	public PromotionVo(PromotionPo promotionPo, UserPo userPo) {
		super();
		this.status = promotionPo.getStatus();
		if(status == 1) {          //用来区分是酒店工作人员还是网站营销人员的状态位
			hotelMarketerInfo = userPo.getUsername();
		} else {
			hotelMarketerInfo = userPo.getUsername();  //可能用不到这个
		}
		this.itemName = promotionPo.getItemName();
		this.startTime = promotionPo.getStartTime();
		this.endTime = promotionPo.getEndTime();
		this.promotionInfo = promotionPo.getPromotionInfo();
	}
	
	public PromotionVo(int status, String hotelMarketerInfo, String itemName, String startTime, String endTime, String promotionInfo){
		this.status = status;
		if(status == 1)
			this.hotelMarketerInfo = hotelMarketerInfo;
		else
			this.hotelMarketerInfo = hotelMarketerInfo;
		this.itemName = itemName;
		this.promotionInfo = promotionInfo;
		this.startTime = startTime;
		this.endTime  = endTime;
	}
	
	public int getStatus() {
		return status;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public String getStartTime() {
		return startTime;
	}
	
	public String getEndTime() {
		return endTime;
	}
	
	public String getPromotionInfo() {
		return promotionInfo;
	}
	
	public String getHotelMarketerInfo() {
		return hotelMarketerInfo;
	}
	
	

}