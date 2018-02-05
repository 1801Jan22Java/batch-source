package com.revature.main;

import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.dao.AccountDAO;
import com.revature.dao.UserDAO;
import com.revature.exceptions.NegativeAmountException;
import com.revature.exceptions.OverdraftException;
import com.revature.exceptions.WrongUsernameOrPasswordException;

public class BankDTOImpl implements BankDTO {

	private UserDAO userDao;
	private AccountDAO acctDao;

	public BankDTOImpl(UserDAO userDao, AccountDAO acctDao) {
		this.userDao = userDao;
		this.acctDao = acctDao;
	}

	/*
	 * Calls the UserDAO in order to get the specified user
	 */
	@Override
	public User getUser(int userId) {

		return userDao.getUserById(userId);
	}

	/*
	 * Calls the AccountDAO to get the specified account
	 */
	@Override
	public Account getAccount(int acctId) {
		return acctDao.getAccountById(acctId);
	}

	/*
	 * Gets a list of all the users from the UserDAO and returns it
	 */
	@Override
	public List<User> getUsers() {
		return userDao.getUsers();
	}

	/*
	 * Calls the signIn method in the UserDAO and checks to see if a user was
	 * returned. If no user was returned this will throw a
	 * WrongUsernameOrPasswordException
	 */
	@Override
	public User signIn(String userName, String password) throws WrongUsernameOrPasswordException {
		User user = null;

		user = userDao.signIn(userName, password);

		if (user == null) {
			throw new WrongUsernameOrPasswordException();
		}

		return user;
	}

	/*
	 * First gets all the information associated with the given userId and then
	 * calls the deleteUser method in the UserDAO
	 */
	@Override
	public void deleteUser(int userId) {
		User user = userDao.getUserById(userId);
		userDao.deleteUser(user);

	}

	/*
	 * Calls the AccountDAO to delete the given account
	 */
	@Override
	public void deleteAccount(int acctId) {
		acctDao.deleteAccount(acctId);

	}

	/*
	 * Sends the user information to the UserDAO and then returns the user it gets
	 * back
	 */
	@Override
	public User createUser(User user) {

		return userDao.createUser(user);
	}

	/*
	 * Sends the account info to the AccountDAO to create a new account
	 */
	@Override
	public void createAccount(Account acct, int userId) {
		if (acct.getBalance() < 0) {
			acct.setBalance(0);
		}
		acctDao.createAcount(acct, userId);
	}

	/*
	 * If the amount given is 0 or negative, throws a NegativeAmountException. Else
	 * it will call the AccountDAO to withdraw the given amount from the specified
	 * account. If an overdraft exception is thrown it will throw it to he caller.
	 */
	@Override
	public void withdrawAmount(int acctId, int amt) throws NegativeAmountException, OverdraftException {
		if (amt <= 0) {
			throw new NegativeAmountException();
		}

		acctDao.withdrawAmount(acctId, amt);

	}

	/*
	 * If the amount given is 0 or negative, throws a NegativeAmountException. Else
	 * it will call the AccountDAO to deposit the given amount into the specified
	 * account.
	 */
	@Override
	public void depositAmount(int acctId, int amt) throws NegativeAmountException {

		if (amt <= 0) {
			throw new NegativeAmountException();
		}
		acctDao.depositAmount(acctId, amt);

	}

	/*
	 * Takes the account and gives it to the AccountDAO to update
	 */
	@Override
	public void updateAccount(Account acct) {
		acctDao.updateAccount(acct);
	}

	/*
	 * Takes the user and gives it to the UserDAO to update
	 */
	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	/*
	 * Takes the given username and attempts to fin the associated user from the
	 * AccountDAO. If one is found it returns true otherwise false.
	 */
	@Override
	public boolean checkUsername(String username) {
		User user = userDao.getUserByUsername(username);

		if (user == null) {
			return true;
		}

		return false;
	}

}
