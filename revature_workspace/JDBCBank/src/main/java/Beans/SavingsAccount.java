package Beans;


public class SavingsAccount extends Account {

	AccountType accountType = new AccountType(1,"Savings");

	SavingsAccount(float initialBalance,AccountType accountType,int userId)
	{
		
		super(initialBalance,accountType,userId);
	}
	@Override
	public void deposit(float funds) {
		initialBalance+=funds;
		
	}

	@Override
	public void withdraw(float withdrawal) {
		initialBalance-=withdrawal;
	}

	@Override
	public void displayBalance() {
		System.out.println(initialBalance);
		
	}

	@Override
	public void closeAccount() {
		// TODO Auto-generated method stub
		
	}


}
