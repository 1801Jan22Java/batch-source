package com.revature.dao;

import java.util.Scanner;

import org.junit.Test;

import com.revature.beans.User;

public class AccountDaoImplTest {
	
	
	//Create Account
	@Test public void createAccountValid() {
		AccountDaoImpl adi = new AccountDaoImpl();
		
		//Create a user 
		User u = new User("Bugsy", "Bugs", "Bunny", 1, false);
		String testInput = 	500+"\n";
		Scanner sc = new Scanner(testInput);
		assert(adi.createAccount(u, sc));
		
	}
	
	
	@Test public void createAccountInvalid() {
		AccountDaoImpl adi = new AccountDaoImpl();
		
		//Create a user 
		User u = new User("Bugsy", "Bugs", "Bunny", 1, false);
		String testInput = 	(-500)+"\n";
		Scanner sc = new Scanner(testInput);
		assert(!adi.createAccount(u, sc));
		
	}
	
	
	//View Accounts
	
	@Test public void viewAccountValid() {
		AccountDaoImpl adi = new AccountDaoImpl();
		
		//Create a user 
		User u = new User("Bugsy", "Bugs", "Bunny", 1, false);
		String testInput = 	(-1)+"\n";
		Scanner sc = new Scanner(testInput);
		assert(adi.viewAccount(u, sc));
		
	}
	
	
	@Test public void viewAccountInvalid() {
		AccountDaoImpl adi = new AccountDaoImpl();
		
		//Create a user 
		User u = new User("Bugsy", "Bugs", "Bunny", 1, false);
		String testInput = 	(2000000)+"\n";
		Scanner sc = new Scanner(testInput);
		assert(!adi.viewAccount(u, sc));
		
	}
	
	
	@Test public void deleteAccountValid() {
		AccountDaoImpl adi = new AccountDaoImpl();
		
		//Create a user 
		User u = new User("Bugsy", "Bugs", "Bunny", 1, false);
		String testInput = 	0+"\n";
		Scanner sc = new Scanner(testInput);
		adi.createAccount(u, sc);
		
		assert(adi.deleteAccount(22, sc));
	}
	
	@Test public void deleteAccountInvalid() {
		AccountDaoImpl adi = new AccountDaoImpl();
		
		//Create a user 
		User u = new User("Bugsy", "Bugs", "Bunny", 1, false);
		String testInput = 	2000000+"\n";
		Scanner sc = new Scanner(testInput);
		assert(!adi.deleteAccount(-5000, sc));
	}
	
	
	@Test public void withdrawValid() {
		AccountDaoImpl adi = new AccountDaoImpl();
		
		//Create a user 
		User u = new User("Bugsy", "Bugs", "Bunny", 1, false);
		String testInput = 	0+"\n";
		Scanner sc = new Scanner(testInput);
		assert(adi.withdraw(3, sc) > 0);
	}
}
