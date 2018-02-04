package com.revature.main;

import java.util.List;

import com.revature.beans.*;

public interface BankDTO {
	
	public User getUser(int userId);
	public Account getAccount(int acctId);
	public List<User> getUsers();
	public User signIn(String userName, String password);
	public void deleteUser(int userId);
	public void deleteAccount(int acctId);
	public User createUser(User user);
	public void craeteAccount(Account acct, int userId);
	public void withdrawAmount(int acctId, int amt);
	public void depositAmount(int acctId, int amt);
	public void updateAccount(Account acct);
	public void updateUser(User user);
	public boolean checkUsername(String username);
	
	
}
