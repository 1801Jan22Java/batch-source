package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao {
	private String filename = "Connection.properties";
	public static int Employee_ID;
	public static String Email;
	public static String Password;
	private String First_Name;

	public int getEmployee_ID() {
		return Employee_ID;
	}
	
	public boolean getAuthorization(String username, String password) {
		String stored_username = null, stored_password = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			PreparedStatement statement = con.prepareStatement("select * from employee where username = ?");
			statement.setString(1, username);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				this.Employee_ID = rs.getInt(1);
				this.Email = rs.getString(5);
				this.Password = rs.getString(7);
				stored_username = rs.getString(6);
				stored_password = rs.getString(7);

				if (username.equals(stored_username) && password.equals(stored_password)) {
					PreparedStatement statement_2 = con
							.prepareStatement("select * from employee where employee_id = ?");
					statement_2.setInt(1, this.Employee_ID);
					ResultSet rn = statement_2.executeQuery();
					rn.next();
					this.First_Name = rn.getString(3);
					return true;
				} else {
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
		return false;
	}
	public boolean is_Manager(String username, String password) {
		int Role = 0;
		String stored_username = null, stored_password = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			PreparedStatement statement = con.prepareStatement("select * from employee where employee_id =?");
			statement.setInt(1, this.Employee_ID);
			
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				Role = rs.getInt(2);

				if (Role>1) {
					
					return true;
				} else {
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
		return false;
	}
	
	public String getEmployeeInfo(int employee_Id) {
		String employeeInfo = "";
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			PreparedStatement statement = con.prepareStatement("select * from employee where employee_id = ?");
			statement.setInt(1, this.Employee_ID);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				employeeInfo += "{\"Employee_Id\":" + rs.getInt(1) + " ";
				employeeInfo += "\"Role_Id\":" + rs.getInt(2) + " ";
				employeeInfo += "\"F_Name\":\"" + rs.getString(3) + "\"";
				employeeInfo += "\"L_Name\":" + rs.getDouble(4) + " ";
				employeeInfo += "\"Email\":\"" + rs.getString(5) + "\"";
				employeeInfo += "\"Username\":\"" + rs.getString(6) + "\"";
				employeeInfo += "\"Password\":\"" + rs.getString(7) + "\"}";

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeInfo;
	}
	
	public String getAllEmployeeInfo() {
		String employeeInfo = "{\"things\":[";
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			PreparedStatement statement = con.prepareStatement("select * from employee");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				employeeInfo += "{\"Employee_Id\":" + rs.getInt(1) + ",";
				employeeInfo += "\"Role_Id\":" + rs.getInt(2) + ",";
				employeeInfo += "\"F_Name\":\"" + rs.getString(3) + "\",";
				employeeInfo += "\"L_Name\":\"" + rs.getString(4) + "\",";
				employeeInfo += "\"Email\":\"" + rs.getString(5) + "\",";
				employeeInfo += "\"Username\":\"" + rs.getString(6) + "\",";
				employeeInfo += "\"Password\":\"" + rs.getString(7) + "\"},";

			}
			employeeInfo = employeeInfo.substring(0, employeeInfo.length()-1);
			employeeInfo+= "]}";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeInfo;
	}
	public void updateEmployeeId(int employee_id) {
		CallableStatement cs = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			con.setAutoCommit(false);
			String sql = "{call UPDATE_EMPLOYEEID(?)}";
			cs = con.prepareCall(sql);
			cs.setInt(1, employee_id);
			cs.execute();
			con.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void updateRoleId(int role_id) {
		CallableStatement cs = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			con.setAutoCommit(false);
			String sql = "{call UPDATE_ROLEID(?)}";
			cs = con.prepareCall(sql);
			cs.setInt(1, role_id);
			cs.execute();
			con.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}




	public void updateEmail(String email,int Employee_id) {
		CallableStatement cs = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			con.setAutoCommit(false);
			String sql = "{call UPDATE_EMAIL(?,?)}";
			cs = con.prepareCall(sql);
			cs.setString(1, email);
			cs.setInt(2,Employee_id);
			cs.execute();
			con.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void updateUsername(String username,int Employee_id) {
		CallableStatement cs = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			con.setAutoCommit(false);
			String sql = "{call UPDATE_USERNAME(?, ?)}";
			cs = con.prepareCall(sql);
			cs.setString(1, username);
			cs.setInt(2, Employee_id);
			cs.execute();
			con.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void updatePassword(String password,int Employee_id) {
		CallableStatement cs = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			con.setAutoCommit(false);
			String sql = "{call UPDATE_PASSWORD(?,?)}";
			cs = con.prepareCall(sql);
			cs.setString(1, password);
			cs.setInt(2,Employee_id);
			cs.execute();
			con.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
