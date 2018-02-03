package Beans;

public abstract class Account {
	public float initialBalance;
	public Account(float initialBalance)
	{
		this.initialBalance=initialBalance;
	}
	
	 public abstract void deposit(float funds);
	 public abstract void withdraw(float withdrawal);
	 public abstract void displayBalance();
	 public abstract void closeAccount();

}
