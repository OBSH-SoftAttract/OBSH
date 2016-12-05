package vo;

import po.UserPo;

public class UserVo {
	private int id;
	private String username;
	private String password;
	private String phone;

	public UserVo() {
		super();
	}

	public UserVo(UserPo userPo) {
		super();
		this.id = userPo.getID();
		this.username = userPo.getUsername();
		this.password = userPo.getPassword();
		this.phone = userPo.getPhone();
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String ph) {
		this.phone = ph;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String pa) {
		this.password = pa;
	}
}
