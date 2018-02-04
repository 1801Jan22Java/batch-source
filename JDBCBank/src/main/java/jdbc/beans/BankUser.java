package jdbc.beans;

public class BankUser {

	public BankUser(int userId, int accountId, String username, String password, boolean isSuper) {
		super();
		this.userId = userId;
		this.accountId = accountId;
		this.username = username;
		this.password = password;
		this.isSuper = isSuper;
	}
	public BankUser() {
		super();
	}
	private int userId;
	private int accountId;
	private String username;
	private String password;
	private boolean isSuper;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isSuper() {
		return isSuper;
	}
	public void setSuper(boolean isSuper) {
		this.isSuper = isSuper;
	}
	@Override
	public String toString() {
		return "BankUser [userId=" + userId + ", accountId=" + accountId + ", username=" + username + ", password="
				+ password + ", isSuper=" + isSuper + "]";
	}
}
