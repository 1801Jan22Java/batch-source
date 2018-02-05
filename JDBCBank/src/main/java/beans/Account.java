package beans;

public class Account 
{
	public Account(int accountid, int userId, String accountType, float balance) {
		super();
		this.accountid = accountid;
		this.userId = userId;
		this.accountType = accountType;
		this.balance = balance;
	}
	private int accountid;
	private int userId;
	private String accountType;
	private float balance;
	public int getAccountid() {
		return accountid;
	}
	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public String toString()
	{
		return this.accountid+" "+this.accountType+" "+this.userId;
	}
	
}
