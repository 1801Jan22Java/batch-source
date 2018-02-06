package com.revature.butil;

import java.util.List;

import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi;
import com.revature.bbeans.*;

/***
 * ConsoleFormatter prints a formatted string to console from any entity in the bbeans package.
 * This class uses JCDP for formatting console output under the provided MIT open license.
 * @author batem
 *
 */
public class ConsoleFormatter implements IConsoleFormatter{
	
	public static void printAccountInfo(BankAccount bAccount) {
		ColoredPrinter titlePrinter = new ColoredPrinter.Builder(1, false)
				.foreground(Ansi.FColor.WHITE)
				.build();
		
		ColoredPrinter colorPrinter = new ColoredPrinter.Builder(1, false)
				.foreground(Ansi.FColor.GREEN)
				.background(Ansi.BColor.BLACK)
				.build();
		
		String formattedTitle = String.format("%-15s| %-33s| %-18s", "Account ID", "Balance", "Account Type");
		String formattedRow   = String.format("%-15d| %-30.2f| %-18s", 
				bAccount.getAccountID(), bAccount.getBalance(), bAccount.getAccountType().toString());
		
		titlePrinter.println(formattedTitle);
		colorPrinter.println(formattedRow);
	}
	
	public static void printAccountInfo(List<BankUserAccount> account) {
		ColoredPrinter titlePrinter = new ColoredPrinter.Builder(1, false)
				.foreground(Ansi.FColor.WHITE)
				.build();
		
		ColoredPrinter colorPrinter = new ColoredPrinter.Builder(1, false)
				.foreground(Ansi.FColor.GREEN)
				.background(Ansi.BColor.BLACK)
				.build();
		
		String formattedTitle = String.format("%-63s| %-15s| %-33s| %-18s",
				"Name", "Account ID", "Balance", "Account Type");
		titlePrinter.println(formattedTitle);
		
			
		for(BankUserAccount bUserAccount: account) {
			BankUser bUser = bUserAccount.getOwner();
			BankAccount bAccount = bUserAccount.getAccount();
			
			String formattedRow   = String.format("%-63s| %-15d| %-30.2f| %-18s", 
					(bUser.getFirstName() + " " + bUser.getLastName()), bAccount.getAccountID(), 
					bAccount.getBalance(), bAccount.getAccountType().toString());
			
			colorPrinter.println(formattedRow);		
		}
			
	}

	public static void printUserInfo(BankUser bUser) {
		ColoredPrinter titlePrinter = new ColoredPrinter.Builder(1, false)
				.foreground(Ansi.FColor.WHITE)
				.build();
		
		ColoredPrinter colorPrinter = new ColoredPrinter.Builder(1, false)
				.foreground(Ansi.FColor.BLUE)
				.background(Ansi.BColor.BLACK)
				.build();
		
		String formattedTitle = String.format("%-63s| %-15s",
				"Name", "User ID");
		titlePrinter.println(formattedTitle);
		
		String formattedRow   = String.format("%-63s| %-15d",
				(bUser.getFirstName() + " " + bUser.getLastName()), bUser.getUserID());
		colorPrinter.println(formattedRow);
	}
	
	public static void printUserInfo(List<BankUser> bUsers) {
		ColoredPrinter titlePrinter = new ColoredPrinter.Builder(1, false)
				.foreground(Ansi.FColor.WHITE)
				.build();
		
		ColoredPrinter colorPrinter = new ColoredPrinter.Builder(1, false)
				.foreground(Ansi.FColor.BLUE)
				.background(Ansi.BColor.BLACK)
				.build();
		
		String formattedTitle = String.format("%-63s| %-15s",
				"Name", "User ID", "Birth Date");
		titlePrinter.println(formattedTitle);
		
		for(BankUser bUser: bUsers) {
			String formattedRow   = String.format("%-63s| %-15d",
					(bUser.getFirstName() + " " + bUser.getLastName()), bUser.getUserID());
			colorPrinter.println(formattedRow);
		}
	}

	public static void printTransactionInfo(Transaction t) {
		ColoredPrinter titlePrinter = new ColoredPrinter.Builder(1, false)
				.foreground(Ansi.FColor.WHITE)
				.build();
		
		ColoredPrinter colorPrinter = new ColoredPrinter.Builder(1, false)
				.foreground(Ansi.FColor.YELLOW)
				.background(Ansi.BColor.BLACK)
				.build();
		
		String formattedTitle = String.format("%-20s| %-30s| %-20s| %-25s",
				"Transaction ID", "Amount", "Transaction Type", "Transaction Date");
		titlePrinter.println(formattedTitle);
		
		String formattedRow = String.format("%-20d| %-28.2d| %-20s| %-25t",
				t.getTransactionID(), t.getAmount(), t.getTransactionType().toString(), t.getTransactionDate());
		colorPrinter.println(formattedRow);
	}
	
	public static void printTransactionHistory(List<Transaction> transactions) {
		ColoredPrinter titlePrinter = new ColoredPrinter.Builder(1, false)
				.foreground(Ansi.FColor.WHITE)
				.build();
		
		ColoredPrinter colorPrinter = new ColoredPrinter.Builder(1, false)
				.foreground(Ansi.FColor.YELLOW)
				.background(Ansi.BColor.BLACK)
				.build();
		
		String formattedTitle = String.format("%-20s| %-30s| %-25s",
				"Transaction ID", "Amount", "Transaction Date");
		titlePrinter.println(formattedTitle);
		
		for(Transaction t: transactions) {
			String formattedRow = String.format("%-20d| %-28.2d| %-20s| %-25t",
					t.getTransactionID(), t.getAmount(), t.getTransactionType().toString(), t.getTransactionDate());
			colorPrinter.println(formattedRow);
		}
		
	}
	
	public static void printMessage(String str) {
		System.out.println(str);
	}

	public static void printError(String str) {
		ColoredPrinter colorPrinter = new ColoredPrinter.Builder(1, false)
				.foreground(Ansi.FColor.RED)
				.background(Ansi.BColor.BLACK)
				.build();
		
		colorPrinter.println(str);
	}
}
