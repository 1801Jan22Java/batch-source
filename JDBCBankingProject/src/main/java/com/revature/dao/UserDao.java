package com.revature.dao;

import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.util.IllegalPasswordException;
import com.revature.util.IllegalUsernameException;
import com.revature.util.IncorrectCredentialsException;

public interface UserDao {
	
	public User createUser(User user) throws IllegalUsernameException, IllegalPasswordException;
	public User login(String username, String password) throws IncorrectCredentialsException;
	public List<Account> getAccountsById(int id);
	public List<User> superGetUsers();
	public User getUserById(int id);
	public void superChangeUser(User user) throws IllegalUsernameException, IllegalPasswordException;
	public void superDeleteUser(User user);

}
