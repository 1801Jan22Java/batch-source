package Beans;


public class CheckingAccount extends Account {

	CheckingAccount(float initialBalance)
	{
		super(initialBalance);
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
