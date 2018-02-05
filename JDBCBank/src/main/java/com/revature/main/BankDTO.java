package com.revature.main;

import java.util.List;

import com.revature.beans.*;
import com.revature.exceptions.NegativeAmountException;
import com.revature.exceptions.OverdraftException;
import com.revature.exceptions.WrongUsernameOrPasswordException;

public interface BankDTO {

	public User getUser(int userId);

	public Account getAccount(int acctId);

	public List<User> getUsers();

	public User signIn(String userName, String password) throws WrongUsernameOrPasswordException;

	public void deleteUser(int userId);

	public void deleteAccount(int acctId);

	public User createUser(User user);

	public void createAccount(Account acct, int userId);

	public void withdrawAmount(int acctId, int amt) throws NegativeAmountException, OverdraftException;

	public void depositAmount(int acctId, int amt) throws NegativeAmountException;

	public void updateAccount(Account acct);

	public void updateUser(User user);

	public boolean checkUsername(String username);

}
