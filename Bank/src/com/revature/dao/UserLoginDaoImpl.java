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
				int id = rs.getInt("ACCOUNT_ID");
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
	public boolean contains(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.revature.dao.UserLoginDao#login(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	

}
