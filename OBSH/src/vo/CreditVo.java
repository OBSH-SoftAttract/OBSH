package vo;
/**
 * credit       信用值
 * userInfo		用户名称
 * time         信用充值时当前时间
 * creditInfo   信用记录详情
 * @author bxh
 */
import po.CreditPo;
import po.UserPo;

public class CreditVo {
	
	private double credit;
	
	private String time;
	
	private String creditInfo;
	
	private String userInfo;
	
	public CreditVo(){
		super();
	}
	
	public CreditVo(CreditPo creditPo,UserPo userPo){
		super();
		this.userInfo = userPo.getUserName();
		this.credit = creditPo.getCredit();
		this.time = creditPo.getTime();
		this.creditInfo = creditPo.getCreditInfo();
	}

	
	public double getCredit() {
		return credit;
	}
	
	public void setCredit(double credit) {
		this.credit = credit;
	}

	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getUserInfo() {
		return userInfo;
	}
	
	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}

	public String getCreditInfo() {
		return creditInfo;
	}
	
	public void setCreditInfo(String creditInfo) {
		this.creditInfo = creditInfo;
	}
	
	

}