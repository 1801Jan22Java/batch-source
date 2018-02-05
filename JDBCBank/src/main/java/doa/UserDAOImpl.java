package doa;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import beans.*;
import util.ConnectionUtil;

public class UserDAOImpl implements UserDAO{
	private static String filename = "Properties";
	public ArrayList<User> getUsers() 
	{	
		ArrayList<User> users = new ArrayList<User>();
		AccountDAOImpl adi = new AccountDAOImpl();
		TransactionDAOImpl tdi = new TransactionDAOImpl();
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			String sql = "SELECT * FROM USERS";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next())
			{
				int userId = rs.getInt("USER_ID");
				int superUser = rs.getInt("SUPER_USER");
				String userName = rs.getString("USER_NAME");
				String password = rs.getString("PASS_WORD");
				User u = new User(userId, superUser, userName, password);
				if(u.getSuperUser()==0)
				{
					users.add(u);
				}
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return users;
	}
	public User getUsersByUserName(String userName)
	{
		ArrayList<User> users = this.getUsers();
		User found = null;
		for(User u: users)
		{
			if(u.getUserName().equals(userName))
			{
				found = u;
			}
		}
		return found;
	}
	public void registerNewUser(String userName, String password, String firstName, String lastName, String state, String zipCode, Date bDay, String address, String ssn) throws ParseException 
	{
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			String sql1 = "INSERT INTO USERS(USER_ID, SUPER_USER, USER_NAME, PASS_WORD) VALUES(0,0,?,?)";
			pstmt1=con.prepareStatement(sql1);
			pstmt1.setString(1, userName);
			pstmt1.setString(2, password);
			//pstmt.execute();
			pstmt1.executeUpdate();
			int userId = this.getUsersByUserName(userName).getUserId();
			String sql2 = "INSERT INTO USER_INFO(USER_FIRST_NAME, USER_LAST_NAME, STATE, ZIP, BIRTHDATE, ADDRESS, SSN, USER_ID) VALUES(?,?,?,?,?,?,?,?)";
			pstmt2=con.prepareStatement(sql2);
			pstmt2.setString(1, firstName);
			pstmt2.setString(2, lastName);
			pstmt2.setString(3, state);
			pstmt2.setString(4, zipCode);
			pstmt2.setDate(5, bDay);
			pstmt2.setString(6, address);
			pstmt2.setString(7, ssn);
			pstmt2.setInt(8, userId);
			pstmt2.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void login() 
	{
		Scanner input = new Scanner(System.in);
		System.out.print("User Name: ");
		String userName = input.next();
		System.out.print("Password: ");
		String password = input.next();
		ArrayList<User> users = getUsers();
		boolean validUsernamePassword = false;
		for(User u: users)
		{
			if(u.getUserName().equals(userName)&&u.getPassword().equals(password))
			{
				validUsernamePassword = true;
			}
		}
		if(!validUsernamePassword)
		{
			System.out.println("No such username and password");
			return;
		}
		
	}

}
