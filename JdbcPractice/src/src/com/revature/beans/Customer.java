package src.com.revature.beans;

public class Customer {
	private int userid;
	private int accountid;
	private String f_name;
	private String l_name;
	public Customer() {
		super();
	}
	
	public Customer(int userid, int accountid,String f_name, String l_name) {
		super();
		this.userid = userid;
		this.accountid = accountid;
		this.f_name = f_name;
		this.l_name = l_name;		
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getAccountid() {
		return accountid;
	}

	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	@Override
	public String toString() {
		return "Customer [userid=" + userid + ", accountid=" + accountid + ", f_name=" + f_name + ", l_name=" + l_name
				+ "]";
	}
	
	

}
