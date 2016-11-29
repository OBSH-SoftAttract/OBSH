package po;

/**
 * credit       信用值
 * userId		用户编号
 * creditInfo   信用记录详情 第一位符号表示增加或减少多少之后为时间 如+500+2016-11-29 05：00：00
 * @author bxh
 */

public class CreditPo {
	
	private int userId;
	
	private double credit;
	
	private String creditInfo;
	
	public CreditPo(){
		super();
	}

	public CreditPo(int userId,double credit){
		this.userId = userId;
		this.credit = credit;		
	}
	public CreditPo(int userId, double credit, String creditInfo) {
		this.userId = userId;
		this.credit = credit;
		this.creditInfo = creditInfo;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public double getCredit() {
		return credit;
	}
	
	public void setCredit(double credit) {
		this.credit = credit;
	}
	
	public String getCreditInfo() {
		return creditInfo;
	}
	
	public void setCreditInfo(String creditInfo) {
		this.creditInfo = creditInfo;
	}

}

