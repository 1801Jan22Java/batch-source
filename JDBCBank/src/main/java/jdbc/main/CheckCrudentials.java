package jdbc.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.exceptions.InvalidPasswordException;
import jdbc.exceptions.InvalidUsernameException;
import jdbc.util.ConnectionUtil;

public class CheckCrudentials {

	String filename = "connection.properties";
	
	public boolean checkUsername(String user) throws InvalidUsernameException{
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM BANK_USER WHERE USERNAME = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				con.close();
				return true;
				
			}
			else {
				throw new InvalidUsernameException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean checkPassword(String user, String pass) throws InvalidPasswordException{
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM BANK_USER WHERE USERNAME = ? AND PASSWORD = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user);
			pstmt.setString(2, pass);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				con.close();
				return true;
			}
			else {
				throw new InvalidPasswordException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}

