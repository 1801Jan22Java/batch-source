package Beans;

public abstract class Account {
	public float initialBalance;
	public AccountType accountType;
	public int userId;
	public Account(){}
	public Account(float initialBalance,AccountType accountType,int userID)
	{
		
		this.initialBalance=initialBalance;
		this.accountType=accountType;
		this.userId=userID;
	}
	
	 public abstract void deposit(float funds);
	 public abstract void withdraw(float withdrawal);
	 public abstract void displayBalance();
	 public abstract void closeAccount();

}
