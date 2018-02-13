package com.revature.dao;

import java.util.List;

import com.revature.beans.Manager;


public interface ManagerDao {
	
public String filename = "connection.properties";
	
	public List<Manager> getManagers();
	public Manager getManagerByID(int requestedManagerId);
	public Manager getManagerByCredentials(String username, String password);
	public int addManager(String username, String password, String email, String firstname, String lastname, String address);	

}
