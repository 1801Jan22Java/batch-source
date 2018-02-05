package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import com.revature.beans.User;
import com.revature.util.ConnectionUtil;
import com.revature.util.InvalidAccountIdException;

public class UserDaoImpl implements UserDao {

	public static final String filename = "connection.properties";
	
	public boolean contains(ArrayList<User> usrs, String username) {
		for(User u: usrs) {
			if(u.getUserName() != null && u.getUserName().equals(username))
				return true;
		}
		return false;
	}

	public User getUserByUsername(String username) {
		ArrayList<User> usrs = null;
		User u = null;
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			usrs = new ArrayList<User>();
			int uid = 0;
			int valid = 0;
			String uName = new String();
			String password = new String();
			String firstName = new String();
			String lastName = new String();
			Date birthday = null;
			String email = new String();
			Date dayRegistered = null;
			String sql = "SELECT * FROM CUSTOMER WHERE USERNAME = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				valid = rs.getInt("Active");
				if (valid > 0) {
					uid = rs.getInt("USERID");
					uName = rs.getString("USERNAME");
					password = rs.getString("PWORD");
					firstName = rs.getString("FIRSTNAME");
					lastName = rs.getString("LASTNAME");
					birthday = rs.getDate("BIRTHDATE");
					email = rs.getString("EMAIL");
					dayRegistered = rs.getDate("DAYREGISTERED");

					u = new User(uid, uName, password, firstName, lastName, 
								birthday.toLocalDate(), email, dayRegistered.toLocalDate(), 1);
					
				}
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	public ArrayList<String> getUserNames(ArrayList<User> usrs) {

		ArrayList<String> userNames = new ArrayList<String>();
		for (User u : usrs) {
			userNames.add(u.getUserName());
		}
		return userNames;
	}

	public ArrayList<User> getUsers() {
		ArrayList<User> usrs = null;
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			usrs = new ArrayList<User>();
			int uid = 0;
			int valid = 0;
			String uName = new String();
			String password = new String();
			String firstName = new String();
			String lastName = new String();
			Date birthday = null;
			String email = new String();
			Date dayRegistered = null;
			String sql = "SELECT * FROM CUSTOMER";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				valid = rs.getInt("Active");
				if (valid > 0) {
					uid = rs.getInt("USERID");
					uName = rs.getString("USERNAME");
					password = rs.getString("PWORD");
					firstName = rs.getString("FIRSTNAME");
					lastName = rs.getString("LASTNAME");
					birthday = rs.getDate("BIRTHDATE");
					email = rs.getString("EMAIL");
					dayRegistered = rs.getDate("DAYREGISTERED");

					usrs.add(new User(uid, uName, password, firstName, lastName, 
								birthday.toLocalDate(), email, dayRegistered.toLocalDate(), 1));
					
				}
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return usrs;
	}
	
	public User getUserByID(int id) {
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			int valid = 0;
			int uid = id;
			String username = null;
			String password = null;
			String firstName = null;
			String lastName = null;
			String email = null;

			String sql = "SELECT * FROM CUSTOMER WHERE USERID = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				valid = rs.getInt("ACTIVE");
				if (valid > 0) {
					uid = rs.getInt("USERID");
					username = rs.getString("USERNAME");
					password = rs.getString("PASSWORD");
					firstName = rs.getString("FIRSTNAME");
					lastName = rs.getString("LASTNAME");
					LocalDate birthday = rs.getDate("BIRTHDATE").toLocalDate();
					email = rs.getString("EMAIL");
					LocalDate dayRegistered = rs.getDate("DAYREGISTERED").toLocalDate();
					con.close();
					return new User(username, password, firstName, lastName, birthday, email, dayRegistered, valid);

				}
			} else {
				con.close();
				throw new InvalidAccountIdException();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void addUser(User u) {
		
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String userName = u.getUserName();
			System.out.println("USERNAME = " + userName);
			String password = u.getPassword();
			String firstName = u.getFirstName();
			String lastName = u.getLastName();
			LocalDate birthday = u.getBirthday();
			String email = u.getEmail();
			LocalDate dayCreated = u.getDayRegistered();
			String sql = "INSERT INTO CUSTOMER ( USERNAME, PWORD, FIRSTNAME, LASTNAME, "
					+ "BIRTHDATE, EMAIL, DAYREGISTERED, ACTIVE) VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement cs = con.prepareCall(sql);
			cs.setString(1, userName);
			cs.setString(2, password);
			cs.setString(3, firstName);
			cs.setString(4, lastName);
			cs.setDate(5, java.sql.Date.valueOf(birthday));
			cs.setString(6, email);
			cs.setDate(7, java.sql.Date.valueOf(dayCreated));
			cs.setInt(8, 1);
			cs.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getNextUserID() {
		int uid = 0;
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "SELECT PK_CUSTOMERS.NEXTVAL FROM DUAL";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				uid = rs.getInt(1);

			else
				throw new RuntimeException("No next value in sequence");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return uid;
	}

	public void deleteUser(User u) {
		
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "{call deactivate_user(?)}";
			CallableStatement cs = con.prepareCall(sql);
			cs.setInt(1, u.getUserID());
			if(cs.executeUpdate() > 1){
				System.out.println("More than one row updated");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	

}
