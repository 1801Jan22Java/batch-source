package com.revature.butil;

import com.revature.bbeans.*;

public interface IConsoleFormatter {
	public static void printAccountInfo(BankAccount bAccount)  {};
	public static void printUserInfo(BankUser bUser) {};
	public static void printTransactionInfo(Transaction t) {};
	public static void printError(String s) {};
}
