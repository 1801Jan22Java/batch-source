package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.BankAccount;
import com.revature.beans.UserLogin;
import com.revature.util.ConnectionUtil;
import com.revature.util.IncorrectPasswordException;
import com.revature.util.InvalidUsernameException;

public class UserLoginDaoImpl implements UserLoginDao{

	private static String filename = "connection.properties";
	/* (non-Javadoc)
	 * @see com.revature.dao.UserLoginDao#getUserLogins()
	 */
	@Override
	public List<UserLogin> getUserLogins() {
		List<UserLogin> logins = new ArrayList<>();
		PreparedStatement pstmt = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename))
		{
			String sql = "SELECT * FROM USER_LOGIN";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				int id = rs.getInt("USER_ID");
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				logins.add(new UserLogin(id,username, password));
			}//end while
			con.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		return logins;
	}

	/* (non-Javadoc)
	 * @see com.revature.dao.UserLoginDao#getUserLoginById(int)
	 */
	@Override
	public UserLogin getUserLoginById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.revature.dao.UserLoginDao#addLogin(com.revature.beans.UserLogin)
	 */
	@Override
	public int addLogin(UserLogin login) {
		// TODO Auto-generated method stub
		
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.revature.dao.UserLoginDao#contains(java.lang.String)
	 */
	@Override
	public boolean contains(String username) throws InvalidUsernameException {
		PreparedStatement pstmt = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename))
		{
			String sql = "SELECT * FROM USER_LOGIN WHERE USERNAME = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,username);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())	//check if there is a match
			{
			//if true return user id
				return true;
			}
			else//the password was incorrect
			{
				throw new InvalidUsernameException();
				
			}
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see com.revature.dao.UserLoginDao#login(java.lang.String, java.lang.String)
	 */
	@Override
	public int login(UserLogin login) throws IncorrectPasswordException{
		PreparedStatement pstmt = null;
		String username = login.getUsername();
		String password = login.getPassword();
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename))
		{
			String sql = "SELECT USER_ID FROM USER_LOGIN WHERE USERNAME = ? AND PASSWORD = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())	//check if there is a match
			{
				int userid = rs.getInt("USER_ID");		//if true return user id
				return userid;
			}
			else//the password was incorrect
			{
				throw new IncorrectPasswordException();
				
			}
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		return -1;
	}
	
	
	

}
