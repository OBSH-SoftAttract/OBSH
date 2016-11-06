package Mock;

public class MockUser {
	int i;
	int userId;
	int marketerId;
	public MockUser(int i,int id) { //确定user是谁 返回一个id
		// TODO Auto-generated constructor stub
	}


	public Object getBirthday(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getCorpoateName(String string) {
		// TODO Auto-generated method stub
		return null;
	}


	public int getId() {
		if(i==0)
			return userId;
		else
			return marketerId;
		// TODO Auto-generated method stub
	}

}
