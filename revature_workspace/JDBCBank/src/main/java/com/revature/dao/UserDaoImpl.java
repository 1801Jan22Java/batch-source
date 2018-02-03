package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.util.ConnectionUtil;

import Beans.Account;
import Beans.SuperUser;
import Beans.User;

public class UserDaoImpl implements UserDao {
	private static String filename = "connection.properties";

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(int id) {
		User user = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename))
		{

			PreparedStatement prepStmt = con.prepareStatement("SELECT * FROM USERS WHERE USER_ID="+id);
			prepStmt.execute();
			ResultSet rs= prepStmt.getResultSet();
			if(rs.next())
			{
				String username=rs.getString("USER_NAME");
				String pass = rs.getString("USER_PASS");
				String fname = rs.getString("FIRST_NAME");
				String lname= rs.getString("LAST_NAME");
				String ssn = rs.getString("SSN");

				user=new User(username,pass,fname,lname,ssn);
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			return user;
		}
	}

	@Override
	public void addUser(User user) {

		try(Connection conn = ConnectionUtil.getConnectionFromFile(filename))
		{

			conn.setAutoCommit(false);
			System.out.println("In try statement");
			String sqlStmt="{CALL NEW_USER_PROC(?,?,?,?,?,?)}";
			CallableStatement cs = conn.prepareCall(sqlStmt);
			cs.setString(1,user.getUserName());
			cs.setString(2,user.getPassword());
			cs.setString(3, user.getFirstName());
			cs.setString(4,user.getLastName());
			cs.setInt(5, user.getSuperUser());
			cs.setString(6, user.getSSN());
			cs.execute();
			conn.commit();

		} catch (SQLException | IOException e) {
			//con.rollback();
			e.printStackTrace();
		}

	}

	public void addSuperUser(SuperUser user) {

		try(Connection conn = ConnectionUtil.getConnectionFromFile(filename))
		{

			conn.setAutoCommit(false);
			System.out.println("In try statement");
			String sqlStmt="{CALL NEW_USER_PROC(?,?,?,?,?,?)}";
			CallableStatement cs = conn.prepareCall(sqlStmt);
			cs.setString(1,user.getUserName());
			cs.setString(2,user.getPassword());
			cs.setString(3, user.getFirstName());
			cs.setString(4,user.getLastName());
			cs.setInt(5, user.getSuperUser());
			cs.setString(6, user.getSSN());
			cs.execute();
			conn.commit();

		} catch (SQLException | IOException e) {
			//con.rollback();
			e.printStackTrace();
		}

	}

}


