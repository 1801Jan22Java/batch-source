package com.revature.dao;

import java.util.*;
import com.revature.beans.Bankuser;


public interface BankuserDao {
	
	public String filename = "connection.properties";
	
	public List<Bankuser> getBankusers();
	public Bankuser getBankuserByID(int id);
	public int addBankuser(String username, String password);

}
