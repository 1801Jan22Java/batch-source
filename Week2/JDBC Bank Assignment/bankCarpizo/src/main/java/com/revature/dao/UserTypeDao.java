package com.revature.dao;

import java.util.List;

import com.revature.beans.UserType;

public interface UserTypeDao 
{
	List<UserType> getUserTypes();
	UserType getUserTypeById(int id);
}
