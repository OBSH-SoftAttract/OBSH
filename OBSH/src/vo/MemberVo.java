package vo;
/**
 * userId          用户编号
 * rank	                      会员等级
 * memberInfo      会员信息详情
 * userInfo		用户信息（用户名+信用值信息）
 * @author bxh
 */
import po.MemberPo;
import po.UserPo;

public class MemberVo {
	
	private int userId;
	
	private int rank;
	
	private String userInfo;
	
	private String memberInfo;
	
	public MemberVo(){
		super();
	}
	
	public MemberVo(MemberPo memberPo,UserPo userPo){
		super();
		this.userInfo = userPo.getUsername()+"("+userPo.getCredit()+")";
		this.userId = memberPo.getUserId();
		this.rank = memberPo.getRank();
		this.memberInfo = memberPo.getMemberInfo();
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getRank() {
		return rank;
	}
	
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public String getMemberInfo() {
		return memberInfo;
	}
	
	public void setCreditInfo(String memberInfo) {
		this.memberInfo = memberInfo;
	}
	
	public String getUserInfo(){
		return userInfo;
	}

}