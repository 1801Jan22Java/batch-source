package Beans;


public class CheckingAccount extends Account {

	AccountType accountType = new AccountType(2,"Checking");
	
	CheckingAccount(float initialBalance,AccountType accountType, int userId)
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
