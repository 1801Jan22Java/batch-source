package com.revature.dao;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import com.revature.beans.Manager;
import com.revature.util.ConnectionUtil;

public class ManagerDaoSQL implements ManagerDao {

	@Override
	public List<Manager> getManagers() {
		List<Manager> listManager = new ArrayList<Manager>();
		try(Connection con = ConnectionUtil.getConnectionFromFile()) {
			Manager result;
			String sql = "SELECT * FROM Manager";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int managerId = rs.getInt("MANAGER_ID");
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				int managerInfoId = rs.getInt("MANAGER_INFO_ID");
				result = new Manager(managerId,username,password,managerInfoId);
				listManager.add(result);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return listManager;
	}

	@Override
	public Manager getManagerByID(int requestedManagerId) {
		Manager managerResult = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile()) {
			
			String sql = "SELECT * FROM MANAGER WHERE MANAGER_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, requestedManagerId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int managerId = rs.getInt("MANAGER_ID");
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				int managerInfoId = rs.getInt("MANAGER_INFO_ID");
				managerResult = new Manager(managerId,username,password,managerInfoId);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return managerResult;
	}

	@Override
	public Manager getManagerByCredentials(String username, String password) {
		Manager managerResult = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile()) {
			
			String sql = "SELECT * FROM MANAGER WHERE (USERNAME = ?) AND (PASSWORD = ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int managerId = rs.getInt("MANAGER_ID");
				int managerInfoId = rs.getInt("MANAGER_INFO_ID");
				managerResult = new Manager(managerId,username,password,managerInfoId);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return managerResult;
	}

	@Override
	public int addManager(String username, String password, String email, String firstname, String lastname,
			String address) {
		int managerId = -1;
		try(Connection con = ConnectionUtil.getConnectionFromFile()) {
			con.setAutoCommit(false);
			String sql = "{call ADD_MANAGER(?,?,?,?,?,?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			cs.setString(1, username);
			cs.setString(2, password);
			cs.setString(3, email);
			cs.setString(4, firstname);
			cs.setString(5, lastname);
			cs.setString(6, address);
			cs.registerOutParameter(7, java.sql.Types.INTEGER);
			cs.execute();
			managerId = cs.getInt(7);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return managerId;
	}

}
