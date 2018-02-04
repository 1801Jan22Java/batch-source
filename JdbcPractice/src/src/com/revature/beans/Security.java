package src.com.revature.beans;

public class Security {
	private int userid;
	private String username;
	private String password_key;
	
	public Security() {
		super();
	}
	
	public Security(int userid, String username, String password_key ) {
		super();
		this.userid = userid;
		this.username = username;
		this.password_key = password_key;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword_key() {
		return password_key;
	}

	public void setPassword_key(String password_key) {
		this.password_key = password_key;
	}

	@Override
	public String toString() {
		return "Security [userid=" + userid + ", username=" + username + ", password_key=" + password_key + "]";
	}
	
	

}
