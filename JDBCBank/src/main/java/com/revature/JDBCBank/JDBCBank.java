package com.revature.JDBCBank;

import java.io.*;
import java.util.*;

import com.revature.JDBCBank.CheckLogin;
import com.revature.beans.*;
import com.revature.dao.*;

public class JDBCBank 
{
	private static Scanner sc = new Scanner(System.in);
	private static boolean creation_flag = true;
	private static boolean interact_flag = true;
	private static BankuserDao bd = new BankuserDaoSQL();
	private static CheckLogin checkLogin = new CheckLogin(sc,bd);
	private static CreateUser createUser = new CreateUser(sc,bd);

	
    public static void main( String[] args )
    {
    	Userinfo cur_user = null;
    	while(creation_flag) {
	    	System.out.println("What would you like to do?");
			System.out.println("(1) Login");
			System.out.println("(2) Create a new user");
			System.out.println("(3) Exit");
			System.out.print("Enter selection: ");
			
			String in_ans = sc.next();
			
			switch(in_ans) {
			case "1":
				cur_user = checkLogin.userLogin();
				break;
			case "2":
				cur_user = createUser.newUser();
				break;
			case "3":
				creation_flag = false;
				break;
			default:
				System.out.println("Invalid input please try again");
					
			}
			interactUser(cur_user);
    	}
    	System.out.println("Goodbye");
    	
    }
    
    public static void interactUser(Userinfo userinfo) {

    	while(interact_flag) {
	    	if (userinfo != null) {
		    	System.out.println("Welcome!");
		    	System.out.println("What would you like to do?");
		    	
		    	if (userinfo.getSuperuser()) {
					System.out.println("(0) Super user stuff ;)");
				}
		    	
				System.out.println("(1) Create Account");
				System.out.println("(2) Delete Account (if empty)");
				System.out.println("(3) View account transactions");
				System.out.println("(4) Withdraw");
				System.out.println("(5) Deposit");
				System.out.println("(6) Logout");
				System.out.print("Enter selection: ");
				int i = 0;
				Account acc = null;
				String in_ans = sc.next();
				
				BalanceDao balDao = new BalanceDaoSQL();
				AccountDao ad = new AccountDaoSQL();
				List<Account> allAccounts = ad.getAccount();
				
				switch(in_ans) {
				case "0":
					if (userinfo.getSuperuser()) {
						
					}
					break;
				case "1":
					makeAccount(userinfo,ad);
					break;
				case "2":
					deleteAccount(userinfo,ad);
					break;
				case "3":
					viewAccount(userinfo,ad);
					break;
				case "4":
					withdrawAccount(userinfo,ad);
					break;
				case "5":
					depositAccount(userinfo,ad);
					break;
				case "6":
					interact_flag = false;
					break;
				default:
					System.out.println("Invalid choice");
					break;
					
					
				}
	    	}
	    	else {
	    		interact_flag = false;
	    		creation_flag = false;
	    	}
    	}
    	
    }
    
    public static void makeAccount(Userinfo userinfo, AccountDao ad) {
    	
    	System.out.println("Choose type of account: ");
		System.out.println("(0) Checking Account");
		System.out.println("(1) Savings Account");
		System.out.print("Enter choice: ");
		String type = sc.next();
		System.out.print("Enter initial amount: ");
		String init = sc.next();
		ad.addAccount(userinfo.getBankuserID(), Integer.parseInt(type), Double.parseDouble(init));
		System.out.println("Account Created!");
    }
    
    public static void deleteAccount(Userinfo userinfo, AccountDao ad) {
    	System.out.println("Which account would you like to delete?");
    	BalanceDao balDao = new BalanceDaoSQL();
		int i = 0;
		int deletable = 0;
		List<Account> allAccounts = ad.getAccount();
		for(Account a : allAccounts) {
			if (a.getBankuserID() == userinfo.getBankuserID()) {
				if (balDao.getBalanceByID(a.getBalanceID()).getInitialBalance() == 0) { 
					String str = "";
					if (a.getType() == 0) {
						str += "Checking ";
					}
					else {
						str += "Savings ";
					}
					System.out.println("("+i+") " + str + "Account of balance: " + balDao.getBalanceByID(a.getBalanceID()).getInitialBalance());
					deletable += 1;
				}
			}
			i++;
		}
		if(deletable == 0) {
			System.out.println("Accounts must have balance of zero to be deleted");
		}
		else {
			System.out.print("Enter choice: ");
			String strDel = sc.next();
			System.out.println("LUL Cant delete");
		}
		
  
    }
    
    public static void viewAccount(Userinfo userinfo, AccountDao ad) {
    	
    	System.out.println("Which account would you like to view transactions from?");
    	BalanceDao balDao = new BalanceDaoSQL();
    	TransactionDao td = new TransactionDaoSQL();
		int i = 0;
		int viewable = 0;
		List<Account> allAccounts = ad.getAccount();
		for(Account a : allAccounts) {
			if (a.getBankuserID() == userinfo.getBankuserID()) {
				String str = "";
				if (a.getType() == 0) {
					str += "Checking ";
				}
				else {
					str += "Savings ";
				}
				System.out.println("("+i+") " + str + "Account of balance: " + balDao.getBalanceByID(a.getBalanceID()).getInitialBalance());
				viewable += 1;
			}
			i++;
		}
		if (viewable == 0) {
			System.out.println("No accounts under your username. Please create an account to view");
		}
		else {
			System.out.print("Enter choice: ");
			String strView = sc.next();
			Account acc = allAccounts.get(Integer.parseInt(strView));
			List<Transaction> allTransaction = td.getTransactions();
			String str = "";
			if (acc.getType() == 0) {
				str += "Checking ";
			}
			else {
				str += "Savings ";
			}
			System.out.println(str + "Account of balance: " + balDao.getBalanceByID(acc.getBalanceID()).getInitialBalance());
			for(Transaction t : allTransaction) {
				if (t.getAccountID() == acc.getAccID()) {
					str = "";
					if(t.getType() == 0) {
						str += "Withdrew ";
					}
					else {
						str += "Deposited ";
					}
					str += String.valueOf(t.getTransactionAmount());
					System.out.println(str);
				}
			}
		}
    }
    
    public static void withdrawAccount(Userinfo userinfo, AccountDao ad) {
    	
    	System.out.println("Which account would you like to withdraw from?");
    	int i = 0;
		int withdrawable = 0;
		List<Account> allAccounts = ad.getAccount();
		TransactionDao td = new TransactionDaoSQL();
		BalanceDao balDao = new BalanceDaoSQL();
		for(Account a : allAccounts) {
			if (a.getBankuserID() == userinfo.getBankuserID()) {
				String str = "";
				if (a.getType() == 0) {
					str += "Checking ";
				}
				else {
					str += "Savings ";
				}
				System.out.println("("+i+") " + str + "Account of balance: " + balDao.getBalanceByID(a.getBalanceID()).getInitialBalance());
				withdrawable++;
			}
			i += 1;
		}
		if (withdrawable == 0) {
			System.out.println("No accounts to withdraw from");
		}
		else {
			System.out.print("Enter choice: ");
			String strWith = sc.next();
			Account acc = allAccounts.get(Integer.parseInt(strWith));
			String str = "";
			if (acc.getType() == 0) {
				str += "Checking ";
			}
			else {
				str += "Savings ";
			}
			System.out.println(str + "Account of balance: " + balDao.getBalanceByID(acc.getBalanceID()).getInitialBalance());
			System.out.print("Enter amount to withdraw: ");
			String amountWith = sc.next();
			td.addTransaction(acc.getBalanceID(), acc.getAccID(), 0, Double.parseDouble(amountWith));
			balDao.updateBalance(acc.getBalanceID(), balDao.getBalanceByID(acc.getBalanceID()).getInitialBalance() - Double.parseDouble(amountWith));
		}
    }
    
    public static void depositAccount(Userinfo userinfo, AccountDao ad) {
    	
    	System.out.println("Which account would you like to deposit in?");
		int i = 0;
		int depositable = 0;
		List<Account> allAccounts = ad.getAccount();
		TransactionDao td = new TransactionDaoSQL();
		BalanceDao balDao = new BalanceDaoSQL();
		for(Account a : allAccounts) {
			if (a.getBankuserID() == userinfo.getBankuserID()) {
				String str = "";
				if (a.getType() == 0) {
					str += "Checking ";
				}
				else {
					str += "Savings ";
				}
				System.out.println("("+i+") " + str + "Account of balance: " + balDao.getBalanceByID(a.getBalanceID()).getInitialBalance());
				depositable++;
			}
			i += 1;
		}
		if (depositable == 0) {
			System.out.println("No accounts to withdraw from");
		}
		else {
			System.out.print("Enter choice: ");
			String strDep = sc.next();
			Account acc = allAccounts.get(Integer.parseInt(strDep));
			String str = "";
			if (acc.getType() == 0) {
				str += "Checking ";
			}
			else {
				str += "Savings ";
			}
			System.out.println(str + "Account of balance: " + balDao.getBalanceByID(acc.getBalanceID()).getInitialBalance());
			System.out.print("Enter amount to deposit: ");
			String amountDep = sc.next();
			td.addTransaction(acc.getBalanceID(), acc.getAccID(), 1, Double.parseDouble(amountDep));
			balDao.updateBalance(acc.getBalanceID(), balDao.getBalanceByID(acc.getBalanceID()).getInitialBalance() + Double.parseDouble(amountDep));
		}
    }

}
