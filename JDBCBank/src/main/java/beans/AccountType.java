package beans;

public class AccountType 
{
	public AccountType(String accountName, int typeId) {
		super();
		this.accountName = accountName;
		this.typeId = typeId;
	}
	private String accountName;
	private int typeId;
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
}
