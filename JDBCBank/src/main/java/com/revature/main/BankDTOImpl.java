package com.revature.main;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.dao.AccountDAO;
import com.revature.dao.UserDAO;
import com.revature.exceptions.NegativeAmountException;
import com.revature.exceptions.WrongUsernameOrPasswordException;

public class BankDTOImpl implements BankDTO {

	
	private UserDAO userDao;
	private AccountDAO acctDao;
	private PrintWriter wtr;
	
	public BankDTOImpl(UserDAO userDao, AccountDAO acctDao, Writer ptr) {
		this.userDao = userDao;
		this.acctDao = acctDao;
		this.wtr = new PrintWriter(ptr);
	}
	
	@Override
	public User getUser(int userId) {
		
		return userDao.getUserById(userId);
	}

	@Override
	public Account getAccount(int acctId) {
		return acctDao.getAccountById(acctId);
	}

	@Override
	public List<User> getUsers() {
		return userDao.getUsers();
	}

	@Override
	public User signIn(String userName, String password) {
		User user = null;
		try {
			user = userDao.signIn(userName, password);
		}catch (WrongUsernameOrPasswordException e) {
			wtr.println(e.getMessage());
			wtr.flush();
		}
		
		
		return user;
	}

	@Override
	public void deleteUser(int userId) {
		User user = userDao.getUserById(userId);
		userDao.deleteUser(user);

	}

	@Override
	public void deleteAccount(int acctId) {
		acctDao.deleteAccount(acctId);

	}

	@Override
	public User createUser(User user) {
		
		
		
		return userDao.createUser(user);
	}

	@Override
	public void craeteAccount(Account acct, int userId) {
		acctDao.createAcount(acct, userId);
	}

	@Override
	public void withdrawAmount(int acctId, int amt) {
		try {
			acctDao.withdrawAmount(acctId, amt);
		} catch (NegativeAmountException e) {
			wtr.println(e.getMessage());
		}
	}

	@Override
	public void depositAmount(int acctId, int amt) {
		try {
			acctDao.depositAmount(acctId, amt);
		} catch (NegativeAmountException e) {
			wtr.println(e.getMessage());
		}
	}

	@Override
	public void updateAccount(Account acct) {
		acctDao.updateAccount(acct);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	@Override
	public boolean checkUsername(String username) {
		User user = userDao.getUserByUsername(username);
		
		if (user == null) {
			return true;
		}
		
		return false;
	}

}
