package com.revature.dao;

import java.util.ArrayList;

import com.revature.beans.Users;

public interface UsersDao {

	public Users getUserByID(int userID);
	public Users getUserByAccount(String uA);
	public int getNextBankNum();
	public int createUser(String userAccount, String userFName, String userLName, String userPassword, int userType);
	public String checkPassword(String userPassword);
	public ArrayList<Users> getAllUsers();
	public void delAllUsers();
	public Users modifyUserField(String field, String newVal, Users editUser);
	public void delSingleUser();
}


