package com.revature.JDBCBank;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.*;

import com.revature.beans.BankUsers;
import com.revature.dao.UserOracle;
import com.revature.util.ConnectionUtil;

public class UserOracleTest {
	// Test printing out all users
	@Test
	public void displayAllUsers() {
		UserOracle uo = new UserOracle();
		uo.showAllUsers();
	}

	// Login test
	@Test
	public void validLogin() {
		UserOracle uo = new UserOracle();
		BankUsers bu = uo.login("sungkwon", "password");
		assertEquals("sungkwon", bu.getUsername());
	}

	// Invalid login
	@Test
	public void invalidLoginEmptyStringsReturnsNull() {
		UserOracle uo = new UserOracle();
		BankUsers bu = uo.login("", "");
		assertEquals(null, bu);
	}

	// Create new user
	@Test
	public void newUserCreatedValid() {
		UserOracle uo = new UserOracle();
		uo.newUser("test3", "case1");
		String uname = "";
		int uid = 0;
		try (Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			// SQL to select username of the newest account for testing
			String sql = "SELECT USERNAME FROM BANK_USERS WHERE USERNAME = 'test'";
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				uname = rs.getString("USERNAME");
			}
			String del = "SELECT MAX(USER_ID) AS \"UID\" FROM BANK_USERS";
			Statement delstmt = con.createStatement();

			ResultSet rs2 = delstmt.executeQuery(del);

			while (rs2.next()) {
				uid = rs2.getInt("UID");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(uname, "test");
		uo.deleteUser(uid);

	}

	// Delete user
	@Test
	public void deleteValidUser() {
		UserOracle uo = new UserOracle();
		uo.newUser("test3", "case1");

		int uid = 0;
		try (Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			String del = "SELECT USER_ID FROM BANK_USERS WHERE USERNAME = 'test3'";
			Statement delstmt = con.createStatement();

			ResultSet rs2 = delstmt.executeQuery(del);

			while (rs2.next()) {
				uid = rs2.getInt("USER_ID");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(uo.deleteUser(uid));
	}

	// Delete non-existent user
	@Test
	public void deleteInvalidUser() {
		UserOracle uo = new UserOracle();
		uo.newUser("test3", "case1");
		assertTrue(uo.deleteUser(0));
	}

	// Edit user, check if user is edited
	@Test
	public void checkIfUserUpdated() {
		UserOracle uo = new UserOracle();
		uo.newUser("test5", "case1");
		Integer uid = 0;
		String testid = "";
		String testrole = "";
		String testusername = "";
		String testpassword = "";
		String[] teststringarray = new String[4];

		try (Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			String del = "SELECT USER_ID FROM BANK_USERS WHERE USERNAME = 'test5'";
			Statement delstmt = con.createStatement();

			ResultSet rs2 = delstmt.executeQuery(del);

			while (rs2.next()) {
				uid = rs2.getInt("USER_ID");
			}
			uo.editUser(uid, 2, "test5", "updated");

			String check = "SELECT USER_ID, ROLE_ID, USERNAME, PASSWORD FROM BANK_USERS WHERE USERNAME = 'test5'";
			Statement checkstmt = con.createStatement();
			ResultSet rsUpdate = checkstmt.executeQuery(check);
			while (rsUpdate.next()) {
				teststringarray[0] = String.valueOf(rsUpdate.getInt("USER_ID"));
				teststringarray[1] = String.valueOf(rsUpdate.getInt("ROLE_ID"));
				teststringarray[2] = rsUpdate.getString("USERNAME");
				teststringarray[3] = rsUpdate.getString("PASSWORD");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] expectedstring = {uid.toString(),"2","test5","updated"};
		assertArrayEquals(expectedstring, teststringarray);
		uo.deleteUser(uid);
	}
}
