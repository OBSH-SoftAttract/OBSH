package po;

public class UserPo {
	private int id;
	private String username;
	private String password; 
	private int credit;
	private String phone; 
	private boolean ifVIP;
	
	public UserPo (int i, String pa,String ph,String un,int cre,boolean iv){ 
		this.id=i;
		this.password=pa; 
		this.phone=ph;
		this.username=un;
		this.credit=cre;
		this.ifVIP=iv;
	}
	public int getID(){
		return id;
	}
	public void setID(int i){
		this.id=i; 
	}
	public String getPassword(){ 
		return password;
	}
	public void setPassword(String pa){
		this.password=pa; 
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
}