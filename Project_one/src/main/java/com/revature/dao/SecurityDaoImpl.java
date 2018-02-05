package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.revature.beans.Customer;
import com.revature.util.ConnectionUtil;

public class SecurityDaoImpl implements SecurityDao {
	private static String filename = "Connection.properties";
	private static int UserID;
	private static String First_Name;
	private static int Account_Number;

	public static int getUserID() {
		return UserID;
	}
	public static String getFirst_Name() {
		return First_Name;
	}



	public static int getAccount_Number() {
		return Account_Number;
	}



	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean check_Availability(String username) {
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			PreparedStatement stmt = con.prepareStatement("select * from security where username = ?" );
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return false;
			}else {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean check_AccountNumber(int accounts) {
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			PreparedStatement stmt = con.prepareStatement("select * from accounts where accountid = ? " );
			stmt.setInt(1, accounts);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean check_Credentials(String username, String password) {
		String stored_username = null, stored_password = null;
		boolean verify = false;
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			
			PreparedStatement statement = con.prepareStatement("select * from security where username = ?");
			//"select * from security where username = ?"
			statement.setString(1, username);
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {

			this.UserID = rs.getInt(1);
			
			stored_username =rs.getString(2);
			stored_password = rs.getString(3);
			
			
				
			
			if(username.equals(stored_username) && password.equals(stored_password)) {
				verify = true;
				PreparedStatement statement_2 = con.prepareStatement("select * from customer where userid = ?");
				statement_2.setInt(1, this.UserID);
				
				 ResultSet rn = statement_2.executeQuery();
				 rn.next();
				 this.First_Name = rn.getString(2);
				 
				 PreparedStatement statement_3 = con.prepareStatement("select * from accounts where userid = ?");
					statement_3.setInt(1, this.UserID);
					
					ResultSet rk = statement_3.executeQuery();
					rk.next();
					 this.Account_Number = rk.getInt(2);
				 
				 
				return true;
			}else {
				return false;
			}
		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (verify == true) {
			return true;
		}else {
		return false;
		}
	}




	


}
