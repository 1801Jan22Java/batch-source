package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

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

	@Override
	public boolean validateCredentials(String username, String password) {
		boolean validated=false;
		String userPass=null;
		String userName= null;
		//	String sql = "SELECT USER_ID,USER_NAME,USER_PASS FROM USERS WHERE USER_NAME=?";
		try(Connection conn = ConnectionUtil.getConnectionFromFile(filename))
		{
			PreparedStatement ps = conn.prepareStatement("SELECT USER_ID,USER_NAME,USER_PASS FROM USERS WHERE USER_NAME=?");
			ps.setString(1, username);
			ps.execute();
			ResultSet rs =ps.getResultSet();
			if(rs.next())
			{
				userName=rs.getString("USER_NAME");
				userPass=rs.getString("USER_PASS");	
				if(username.equals(userName)&&password.equals(userPass))
				{
					validated=true;
					System.out.println("validated");
				}
			}
		}
		catch(SQLException | IOException e){ e.printStackTrace();
		}
		finally{
			return validated;
		}
	}

	@Override
	public User createUser() {
		User user = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your firstname");
		String name = sc.nextLine();
		System.out.println("Please enter your lastname");
		String lname = sc.nextLine();
		System.out.println("Please enter your SSN");
		String ssn = sc.nextLine();
		System.out.println("Please enter your username");
		String username=sc.nextLine();
		System.out.println("Please enter your password");
		String pw = sc.nextLine();
		user =new User(username,pw,name,lname,ssn);
		addUser(user);
		System.out.println("User creation successful!");
		return user;

	}

	@Override
	public int getUserID(User user) {
		int userId=0;
		String username=user.getUserName();
		String sql = "SELECT USER_ID FROM USERS WHERE USER_NAME=?";
		try(Connection conn = ConnectionUtil.getConnectionFromFile(filename))
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.execute();
			ResultSet rs =ps.getResultSet();
			if(rs.next())
			{
				userId=rs.getInt("USER_ID");
			}
		}
		catch(SQLException | IOException e){ e.printStackTrace();}
		return userId;
	}

	@Override
	public User getUserByCredentials(String username, String password) {
		User user = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename))
		{

			PreparedStatement prepStmt = con.prepareStatement("SELECT * FROM USERS WHERE USER_NAME=? AND USER_PASS=?");
			prepStmt.setString(1, username);
			prepStmt.setString(2,password);
			prepStmt.execute();
			ResultSet rs= prepStmt.getResultSet();
			if(rs.next())
			{
				String usenam=rs.getString("USER_NAME");
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
	public void logout() {
		try(Connection conn = new ConnectionUtil().getConnectionFromFile(filename))
		{
			try{
			conn.close();
			System.out.println("You have been logged out.  Thank you for using JDBC Banking");
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			
		}
		catch(SQLException | IOException e){e.printStackTrace();}
	}

	@Override
	public boolean validateSuperUser(User user) {
		boolean isSuperUser=  false;
		try(Connection conn = new ConnectionUtil().getConnectionFromFile(filename))
		{
			String username = user.getUserName();
			String password = user.getPassword();
			PreparedStatement prepStmt = conn.prepareStatement("SELECT * FROM USERS WHERE USER_NAME=? AND USER_PASS=?");
			prepStmt.setString(1, username);
			prepStmt.setString(2,password);
			prepStmt.execute();
			ResultSet rs= prepStmt.getResultSet();
			while(rs.next())
			{
				int superUser = rs.getInt("SUPER_USER");
				if(superUser==1)
				{
					isSuperUser=true;
				}
			}
		}
		catch(IOException | SQLException e)
		{e.printStackTrace();
		}
		return false;
	}

	@Override
	public void deleteUser(User user2) {
		

	}

}


