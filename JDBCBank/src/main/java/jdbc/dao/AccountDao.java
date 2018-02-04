package jdbc.dao;

import java.util.List;

import jdbc.beans.Account;

public interface AccountDao {

	public List<Account> getAccountsByUserId(int user);
	public Account getAccountById(int acctId);
	public void withdraw(int amount, int acctId);
	public void deposit(int amount, int acctId);
	public void createAccount(int userId);
	public void deleteAccount(int acctId);
	public int getUserIdByAccountId(int acctId);
}
