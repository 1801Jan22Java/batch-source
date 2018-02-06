package com.revature.butil;

import java.util.List;

import com.revature.bbeans.BankAccount;
import com.revature.bbeans.BankUser;
import com.revature.bbeans.BankUserAccount;
import com.revature.bbeans.Transaction;

public class PlainConsoleFormatter implements IConsoleFormatter {
	public static void printAccountInfo(BankAccount bAccount) {
		
		String formattedTitle = String.format("%-15s| %-33s| %-18s", "Account ID", "Balance", "Account Type");
		String formattedRow   = String.format("%-15d| %-30.2f| %-18s", 
				bAccount.getAccountID(), bAccount.getBalance(), bAccount.getAccountType().toString());
		
		System.out.println(formattedTitle);
		System.out.println(formattedRow);
	}
	
	public static void printAccountInfo(List<BankUserAccount> account) {
		
		String formattedTitle = String.format("%-63s| %-15s| %-30s| %-18s",
				"Name", "Account ID", "Balance", "Account Type");
		System.out.println(formattedTitle);
		
			
		for(BankUserAccount bUserAccount: account) {
			BankUser bUser = bUserAccount.getOwner();
			BankAccount bAccount = bUserAccount.getAccount();
			
			String formattedRow   = String.format("%-63s| %-15d| %-30.2f| %-18s", 
					(bUser.getFirstName() + " " + bUser.getLastName()), bAccount.getAccountID(), 
					bAccount.getBalance(), bAccount.getAccountType().toString());
			
			System.out.println(formattedRow);		
		}
			
	}

	public static void printUserInfo(BankUser bUser) {
		String formattedTitle = String.format("%-63s| %-15s",
				"Name", "User ID");
		System.out.println(formattedTitle);
		
		String formattedRow   = String.format("%-63s| %-15d",
				(bUser.getFirstName() + " " + bUser.getLastName()), bUser.getUserID());
		System.out.println(formattedRow);
	}
	
	public static void printUserInfo(List<BankUser> bUsers) {
		String formattedTitle = String.format("%-63s| %-15s",
				"Name", "User ID", "Birth Date");
		System.out.println(formattedTitle);
		
		for(BankUser bUser: bUsers) {
			String formattedRow   = String.format("%-63s| %-15d",
					(bUser.getFirstName() + " " + bUser.getLastName()), bUser.getUserID());
			System.out.println(formattedRow);
		}
	}

	public static void printTransactionInfo(Transaction t) {
		String formattedTitle = String.format("%-20s| %-30s| %-20s| %-25s",
				"Transaction ID", "Amount", "Transaction Type", "Transaction Date");
		System.out.println(formattedTitle);
		
		String formattedRow = String.format("%-20d| %-28.2d| %-20s| %-25t",
				t.getTransactionID(), t.getAmount(), t.getTransactionType().toString(), t.getTransactionDate());
		System.out.println(formattedRow);
	}
	
	public static void printTransactionHistory(List<Transaction> transactions) {
		String formattedTitle = String.format("%-20s| %-30s| %-25s",
				"Transaction ID", "Amount", "Transaction Date");
		System.out.println(formattedTitle);
		
		for(Transaction t: transactions) {
			String formattedRow = String.format("%-20d| %-28.2d| %-20s| %-25t",
					t.getTransactionID(), t.getAmount(), t.getTransactionType().toString(), t.getTransactionDate());
			System.out.println(formattedRow);
		}
		
	}
	
	public static void printMessage(String str) {
		System.out.println(str);
	}

	public static void printError(String str) {
		System.out.println(str);
	}
}
