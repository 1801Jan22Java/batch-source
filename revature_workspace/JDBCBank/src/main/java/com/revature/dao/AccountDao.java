package com.revature.dao;

import java.util.List;

import Beans.Account;
import Beans.User;

public interface AccountDao {
	public List<Account> getAccounts();
	public Account getAccountById();
	public void addAccount(Account account);
	public void deposit(int accountID,float amount);
	public void withdrawal(User user,int accountID,float amount);
	public void selectAction(int option);
	public void showBalances(User user, int accountID);

}
