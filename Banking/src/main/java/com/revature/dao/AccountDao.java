package com.revature.dao;

import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.User;

public interface AccountDao {
	public boolean createAccount(User u, Scanner sc);
	public boolean viewAccount(User u, Scanner sc);
	public boolean deleteAccount(int accID, Scanner sc);
	
	public double withdraw(int accID, Scanner sc);
	public double deposit(int accID, Scanner sc);
	
}
