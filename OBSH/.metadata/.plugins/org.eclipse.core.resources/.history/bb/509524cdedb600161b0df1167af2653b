package vo;
import java.sql.Timestamp;

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
	
	private String creditInfo;
	
	private String userInfo;
	
	public CreditVo(){
		super();
	}
	
	public CreditVo(CreditPo creditPo,UserPo userPo){
		super();
		this.userInfo = userPo.getUsername();
		this.credit = creditPo.getCredit();
		this.creditInfo = creditPo.getCreditInfo();
	}

	
	public double getCredit() {
		return credit;
	}
	
	public void setCredit(double credit) {
		this.credit = credit;
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