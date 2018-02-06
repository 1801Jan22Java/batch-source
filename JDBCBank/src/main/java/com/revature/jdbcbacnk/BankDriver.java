package com.revature.jdbcbacnk;


public class BankDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Bank b1 = new Bank("MJohn56", "theguy", 1234.5, 123456.78, 200);
		System.out.println("Welcome to JDBC Bank!!!");
		
		System.out.println("Please login to your account");
		b1.setUsername("Matthew");
		b1.setPassword("partyOverHere");
		if(b1.getUsername().equals(b1.getUsername())) {
			System.out.println("Username is accepted.");
		}
		else if(b1.getPassword().equals(b1.getPassword())){
			System.out.println("Password is accepted.");
		}
		else {
			System.out.println("Access Denied!");
		}
		System.out.println("What will you do today? Withdraw or deposit?");
		b1.setBalance(1234.89);
		b1.setAccount(12367.9);
		System.out.println("Withdrawing?");
		b1.withdraw(130.1);
		System.out.println(b1.getBalance());
		
		System.out.println("How much are you depositing?");
		b1.deposit(140.9);
		System.out.println(b1.getBalance());
		
		System.out.println("Logging out");
	}
	
	
	
}
		
		
		
		
		
		
		
		
		
	


