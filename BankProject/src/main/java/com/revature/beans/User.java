package com.revature.beans;

import com.revature.dao.CheckingsDaoImpl;
import com.revature.dao.SavingsDaoImpl;

public class User {

	private static CheckingsDaoImpl udi = new CheckingsDaoImpl(); 
	private static SavingsDaoImpl sdi = new SavingsDaoImpl(); 

	
	private int userId;
	private String username;
	private String password;
	private Checkings checkingsAccount;
	private Savings savingsAccount;
	
	
	public double getCheckingsBalance() {
		if (checkingsAccount != null) {
			return checkingsAccount.getCheckingsBalance();	
		}
		return 0;
	}

	public void setCheckingsBalance(double checkingsBalance) {
		if (checkingsAccount == null) {
			return;	
		}
		checkingsAccount.setCheckingsBalance(checkingsBalance);
	}
	
	public double getSavingsBalance() {
		if (savingsAccount != null) {
			return savingsAccount.getSavingsBalance();	
		}
		return 0;
	}

	public void setSavingsBalance(double savingsBalance) {
		if (savingsAccount == null) {
			return;	
		}
		savingsAccount.setSavingsBalance(savingsBalance);
	}
	

	public int getUserId() {
		return userId;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Checkings getCheckingsAccount() {
		return checkingsAccount;
	}
	
	public void setCheckingsAccount(Checkings checkingsAccount) {
		this.checkingsAccount = checkingsAccount;
	}
	
	public Savings getSavingsAccount() {
		return savingsAccount;
	}
	
	public void setSavingsAccount(Savings savingsAccount) {
		this.savingsAccount = savingsAccount;
	}

	
	public User() {
		super();
	}

	public User(int userId, String username, String password) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
	}

	public User(int userId, String username, String password, 
			double checkingsBalance, double savingsBalance) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.checkingsAccount = new Checkings(checkingsBalance);
		this.savingsAccount = new Savings(savingsBalance);
	}
	
	// Deposit method to pass money into the account balance. Updates balance
	public void depositIntoCheckings(double depositAmount) {
		// Execute if passed in argument is less than 0
		if (depositAmount <= 0) {
			System.out.println("Deposit failed. Deposit amount must be greater than 0!");
			return;
		}
		
		// Execute if passed in argument value is valid. Notify user that transaction is
		// complete and add transaction to list
		this.setCheckingsBalance(this.getCheckingsBalance() + depositAmount);
		udi.updateCheckingsBalance(this.userId, this.getCheckingsBalance());
		System.out.println("Deposit completed. New balance = $" + this.getCheckingsBalance());
		return;
	}
	
	// Deposit method to pass money into the account balance. Updates balance
	public void depositIntoSavings(double savingsAmount) {
		// Execute if passed in argument is less than 0
		if (savingsAmount <= 0) {
			System.out.println("Deposit failed. Deposit amount must be greater than 0!");
			return;
		}
		
		// Execute if passed in argument value is valid. Notify user that transaction is
		// complete and add transaction to list
		this.setSavingsBalance(this.getSavingsBalance() + savingsAmount);
		sdi.updateSavingsBalance(this.userId, this.getSavingsBalance());
		System.out.println("Deposit completed. New balance = $" + this.getSavingsBalance());
		return;
	}

	// Withdraw method to take money out of the account balance. Updates balance
	// variable.
	public void withdrawFromCheckings(double withdrawAmount) {
		// Execute if passed in argument is less than 0
		if (withdrawAmount <= 0) {
			System.out.println("Withdraw failed. Withdraw amount must be greater than 0!");
			return;
		}
	
		// Execute if passed in argument is greater than available balance
		if (this.getCheckingsBalance() - withdrawAmount < 0) {
			System.out.println("Withdraw failed. Specified withdraw amount is greater than current balance!");
			return;
		}
		// Execute if above conditional statements do not apply. Update balance.
		this.setCheckingsBalance(this.getCheckingsBalance() - withdrawAmount);
		udi.updateCheckingsBalance(this.userId, this.getCheckingsBalance());
		System.out.println("Withdraw completed. New balance = $" + this.getCheckingsBalance());
		return;
	}
	
	// Withdraw method to take money out of the account balance. Updates balance
	// variable.
	public void withdrawFromSavings(double withdrawAmount) {
		// Execute if passed in argument is less than 0
		if (withdrawAmount <= 0) {
			System.out.println("Withdraw failed. Withdraw amount must be greater than 0!");
			return;
		}
	
		// Execute if passed in argument is greater than available balance
		if (this.getSavingsBalance() - withdrawAmount < 0) {
			System.out.println("Withdraw failed. Specified withdraw amount is greater than current balance!");
			return;
		}
		// Execute if above conditional statements do not apply. Update balance.
		this.setSavingsBalance(this.getSavingsBalance() - withdrawAmount);
		sdi.updateSavingsBalance(this.userId, this.getSavingsBalance());
		System.out.println("Withdraw completed. New balance = $" + this.getSavingsBalance());
		return;
	}
	
	public void transferFromCheckingsToSavings(double transferAmount) {
		// Execute if passed in argument is less than 0
		if (transferAmount <= 0) {
			System.out.println("Transfer failed. Transfer amount must be greater than 0!");
			return;
		}
	
		// Execute if passed in argument is greater than available balance
		if (this.getCheckingsBalance() - transferAmount < 0) {
			System.out.println("Withdraw failed. Specified withdraw amount is greater than current balance!");
			return;
		}

		withdrawFromCheckings(transferAmount);
		depositIntoSavings(transferAmount);
	}
	
	public void transferFromSavingsToCheckings(double transferAmount) {
		// Execute if passed in argument is less than 0
		if (transferAmount <= 0) {
			System.out.println("Transfer failed. Transfer amount must be greater than 0!");
			return;
		}
	
		// Execute if passed in argument is greater than available balance
		if (this.getSavingsBalance() - transferAmount < 0) {
			System.out.println("Withdraw failed. Specified withdraw amount is greater than current balance!");
			return;
		}

		withdrawFromSavings(transferAmount);
		depositIntoCheckings(transferAmount);
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", checkingsAccount="
				+ checkingsAccount + ", savingsAccount=" + savingsAccount + "]";
	}


	
	
}
