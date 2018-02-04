package com.revature.dao;



import java.util.ArrayList;

import com.revature.beans.Credentials;
import com.revature.beans.User;

public interface UserDao {

	public ArrayList<String> getUserNames(ArrayList<User> usrs); 
	public ArrayList<User> getUsers();
	public ArrayList<Credentials> getCredentials(ArrayList<User> usrs);
	public User getUserByID(int id);
	public void addUser(User u);
	public int getNextUserID();
	
}
