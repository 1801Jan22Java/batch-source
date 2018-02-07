package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.dao.AccountDao;
import com.revature.dao.AccountDaoImpl;
import com.revature.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {
		
	
		String useruser = null;
		AccountDao cd = new AccountDaoImpl();
		System.out.println("Create New Account?[Y/N]");
		Scanner keyboard = new Scanner(System.in);
		String userChoice = keyboard.nextLine().toString().toUpperCase();
		if(userChoice.equals("Y")) {
			System.out.println("username:");
			String username1 = keyboard.nextLine().toString();
			useruser= username1;
			System.out.println("firstname:");
			String firstName1 = keyboard.nextLine().toString();
			System.out.println("lastname:");
			String lastName1 = keyboard.nextLine().toString();
			System.out.println("password:");
			String password1 = keyboard.nextLine().toString();
			cd.createAccount(username1, firstName1, lastName1, password1,0);
		}
		
		else
		System.out.println("Deposit or Withdraw? [Y/N]");
    		if(userChoice.equals("Y")) {
    			System.out.println("1. Deposit");
    			System.out.println("2. Withdraw");
    			System.out.println("3. Exit");
    			int choiceSearch =  keyboard.nextInt();
    			if(choiceSearch == 1) {
    				System.out.println("Deposit Amount:");
    				long depositSearch =  keyboard.nextLong();
    				cd.deposit(depositSearch, useruser );
      			System.out.println("Deposit Successful!");
    				//cd.deposit(user, amount);
    					
    			}
    			if(choiceSearch == 2) {
    				System.out.println("Withdrawl Amount:");
    				long withdrawSearch =  keyboard.nextLong();
    				cd.withdraw(withdrawSearch, useruser );
    				System.out.println("Withdrawl Successful!");
    					
    			}
   
    			
    			
    			
    		}
		
		
		//cd.create("username", "firstName", "lastName", "password");
		//if 
		//cd.deposit(username amount);
	}

}
