package com.revature.bdao;

import java.util.List;

import com.revature.bbeans.BankAccount;

public interface IBankAccountDAO {
	public List<BankAccount> viewAllBankAccounts();
	public List<BankAccount> viewAllBankAccounts(int userID);
	public List<BankAccount> viewBankAccountType(BankAccount.AccountType at);
	public List<BankAccount> viewBankAccountType(int userID, BankAccount.AccountType at);
	public void deleteBankAccount(int userID, BankAccount.AccountType at);
	public void deleteBankAccount(int accountID);
	public void createBankAccount(int userID, double initialDeposit, BankAccount.AccountType at);
	public int depositFunds(int userID, BankAccount.AccountType at, double deposit);
	public int withdrawFunds(int userID, BankAccount.AccountType at, double withdrawal);
	public void transferFunds(int userID, BankAccount.AccountType at1, BankAccount.AccountType at2, double transferAmount);
}
