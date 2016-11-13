package vo;

import po.UserPo;

public class UserVo {
	private int id;
	private String username;
	private String password; 
	private int credit;
	private String phone; 
	private boolean ifVIP;
	
	public UserVo(){
		super();
	}
	
	public UserVo(UserPo userPo){
		super();
		this.id = userPo.getID();
		this.username = userPo.getUsername();
		this.credit = userPo.getCredit();
		this.password=userPo.getPassword();
		this.phone=userPo.getPhone();
		this.ifVIP=userPo.getifVIP();
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}
	public String getPhone(){ 
		return phone;
	}
	public void setPhone(String ph){
		this.phone=ph;
	}
	public boolean getifVIP(){ 
		return ifVIP;
	}
	public void setifVIP(boolean b){ 
		this.ifVIP=b;
	}
	public String getPassword(){ 
		return password;
	}
	public void setPassword(String pa){
		this.password=pa; 
	}
}