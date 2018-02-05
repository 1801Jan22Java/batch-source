package com.revature.dao;

import java.util.Scanner;

import com.revature.beans.User;
import com.revature.exceptions.InvalidAccountIDException;

public interface UserDao {
	public User createUser(Scanner sc);
	public User logIn(Scanner sc);

	public void adminMenu(User u);
	
	public boolean superView(Scanner sc);
	public User superUpdate(Scanner sc);
	public int superDelete(Scanner sc);
}
