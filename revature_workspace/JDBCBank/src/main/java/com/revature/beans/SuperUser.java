package com.revature.beans;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.util.ConnectionUtil;


public class SuperUser extends User {
	private static String filename = "connection.properties";
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String ssn;	
	private int isSuperUser=1;
	
	public SuperUser(String username, String pass, String firstname,String lastname,String ssn)
	{
		super(username,pass,firstname,lastname,ssn);

	}
	
	@Override
	public int getSuperUser(){
		return isSuperUser;
	}
	
	public void deleteUser(int id)
	{
	
		try(Connection conn = ConnectionUtil.getConnectionFromFile(filename))
		{
			conn.setAutoCommit(false);
			String sqlStmt="{CALL SP_DELETE_USER(?)}";
			CallableStatement cs = conn.prepareCall(sqlStmt);
			cs.setInt(1, id);
			cs.execute();
			conn.commit();
		}
		catch (SQLException | IOException e) {
			//con.rollback();
			e.printStackTrace();
		}


	}
	
	



	
}
