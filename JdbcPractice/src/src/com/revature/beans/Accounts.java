package src.com.revature.beans;

public class Accounts {
	private int accountid;
	private float savings;
	private int userid;
	
	public Accounts() {
		super();
	}
	
	public Accounts(int accountid, float savings, int userid) {
		super();
		this.accountid = accountid;
		this.savings = savings;
		this.userid = userid;
	}

	public int getAccountid() {
		return accountid;
	}

	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}

	public float getSavings() {
		return savings;
	}

	public void setSavings(float savings) {
		this.savings = savings;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "Accounts [accountid=" + accountid + ", savings=" + savings + ", userid=" + userid + "]";
	}
	
	
	
}
