package jdbc.beans;

public class Account {

	public Account() {
		super();
	}
	public Account(int accountId, int userId, int balance) {
		super();
		this.accountId = accountId;
		this.userId = userId;
		this.balance = balance;
	}
	private int accountId;
	private int userId;
	private int balance;
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", userId=" + userId + ", balance=" + balance + "]";
	}
}
