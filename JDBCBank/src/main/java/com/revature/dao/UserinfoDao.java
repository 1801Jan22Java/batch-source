package com.revature.dao;

import java.util.*;
import com.revature.beans.Userinfo;

public interface UserinfoDao {
	public String filename = "connection.properties";
	
	public List<Userinfo> getUserinfo();
	public Userinfo getUserinfoByID(int id);
	public void addUserinfo(int bankId,String ssn, String fname, String lname, String address, String email);
	

}
