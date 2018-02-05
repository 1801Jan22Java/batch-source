package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.User;
import com.revature.util.ConnectionUtil;

public class UserDaoImpl implements UserDao{

	private static String filename = "connection.properties";
	/* 
	 * 
	 */
	@Override
	public List<User> getUsers() {
		List<User> ulist = new ArrayList<>();
		PreparedStatement pstmt = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename))
		{
			String sql = "SELECT * FROM REG_USER";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				int id = rs.getInt("USER_ID");
				String fname = rs.getString("FIRSTNAME");
				String mname = rs.getString("MIDDLENAME");
				String lname = rs.getString("LASTNAME");
				String address = rs.getString("ADDRESS");
				String city = rs.getString("CITY");
				String state = rs.getString("STATE");
				String email = rs.getString("EMAIL");
				String phone = rs.getString("PHONE");
				String ssn = rs.getString("SSN");
				ulist.add(new User(id,fname, mname, lname, address, city, state, email, phone, ssn));
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
		
		return ulist;
	}

	/* (non-Javadoc)
	 * @see com.revature.dao.UserDao#getUserById(int)
	 */
	@Override
	public User getUserById(int id)
	{
		PreparedStatement pstmt = null;
		User user = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename))
		{
			String sql = "SELECT * FROM REG_USER WHERE USER_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				String fname = rs.getString("FIRSTNAME");
				String mname = rs.getString("MIDDLENAME");
				String lname = rs.getString("LASTNAME");
				String address = rs.getString("ADDRESS");
				String city = rs.getString("CITY");
				String state = rs.getString("STATE");
				String email = rs.getString("EMAIL");
				String phone = rs.getString("PHONE");
				String ssn = rs.getString("SSN");
				user =  new User(id,fname, mname, lname, address, city, state, email, phone, ssn);
			}//end of while
			con.close();
		}//end of try block
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		return user;
	}

	/* (non-Javadoc)
	 * @see com.revature.dao.UserDao#addUser(int)
	 */
	@Override
	public int addUser(User user) 
	{
		int usersCreated = 0;
		Connection con = null;
		try
		{
			con = ConnectionUtil.getConnectionFromFile(filename);
			con.setAutoCommit(false);
			String sql = "INSERT INTO REG_USER (USER_ID, FIRSTNAME, MIDDLENAME, LASTNAME, ADDRESS, CITY, STATE, EMAIL, PHONE, SSN)" + 
					"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, user.getUserID());
			pstmt.setString(2, user.getFirstname());
			pstmt.setString(3, user.getMiddlename());
			pstmt.setString(4, user.getLastname());
			pstmt.setString(5, user.getAddress());
			pstmt.setString(6, user.getCity());
			pstmt.setString(7, user.getState());
			pstmt.setString(8, user.getEmail());
			pstmt.setString(9, user.getPhone());
			pstmt.setString(10, user.getSsn());
			usersCreated = pstmt.executeUpdate();
			con.commit();
		}// end of first try block
		catch (SQLException e) 
		{
			e.printStackTrace();
			try
			{
				con.rollback();
			} 
			catch (Exception e1)
			{
				e.printStackTrace();
			}
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		if (con != null)
		{
			try 
			{
				con.close();
			} 
			catch (SQLException e)
			{
				
				e.printStackTrace();
			}
		}
		return usersCreated;
	}

	/* (non-Javadoc)
	 * @see com.revature.dao.UserDao#deleteUser(int)
	 */
	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.revature.dao.UserDao#editUser(int)
	 */
	@Override
	public void editUser(int id) {
		// TODO Auto-generated method stub
		
	}

	
}
