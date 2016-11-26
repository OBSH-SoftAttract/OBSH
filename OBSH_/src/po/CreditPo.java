package po;

import java.sql.Timestamp;

/**
 * credit       信用值
 * userId		用户编号
 * time         信用充值时当前时间
 * creditInfo   信用记录详情
 * @author bxh
 */

public class CreditPo {
	
	private int userId;
	
	private double credit;
	
	private Timestamp time;
	
	private String creditInfo;
	
	public CreditPo(){
		super();
	}

	public CreditPo(int userId,double credit){
		this.userId = userId;
		this.credit = credit;		
	}
	public CreditPo(int userId, double credit, Timestamp time, String creditInfo) {
		this.userId = userId;
		this.credit = credit;
		this.time = time;
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
	
	public Timestamp getTime() {
		return time;
	}
	
	public void setTime(Timestamp time) {
		this.time = time;
	}
	
	public String getCreditInfo() {
		return creditInfo;
	}
	
	public void setCreditInfo(String creditInfo) {
		this.creditInfo = creditInfo;
	}

}
