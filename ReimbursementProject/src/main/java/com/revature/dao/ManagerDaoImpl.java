package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.Manager;
import com.revature.util.ConnectionUtil;

public class ManagerDaoImpl implements ManagerDao {

	@Override
	public List<Manager> getManagers() {
		List<Manager> managerList = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "SELECT * FROM MANAGER";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int managerId = rs.getInt("MANAGER_ID");
				String firstName = rs.getString("FIRST_NAME");
				String lastName = rs.getString("LAST_NAME");
				String address = rs.getString("ADDRESS");
				String city = rs.getString("CITY");
				String state = rs.getString("STATE");
				String phoneNumber = rs.getString("PHONE_NUMBER");
				String email = rs.getString("EMAIL");
				String password = rs.getString("M_PASSWORD");
				managerList.add(new Manager(managerId, firstName, lastName, address, city, state,
						phoneNumber, email, password));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return managerList;
	}

	@Override
	public Manager getManagerById(int managerId) {
		PreparedStatement pstmt = null;
		Manager manager = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "SELECT * FROM MANAGER WHERE EMPLOYEE_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, managerId);
			ResultSet rs = pstmt.executeQuery();

			if(rs.next()){
				String firstName = rs.getString("FIRST_NAME");
				String lastName = rs.getString("LAST_NAME");
				String address = rs.getString("ADDRESS");
				String city = rs.getString("CITY");
				String state = rs.getString("STATE");
				String phoneNumber = rs.getString("PHONE_NUMBER");
				String email = rs.getString("EMAIL");
				String password = rs.getString("M_PASSWORD");

				manager = new Manager(managerId, firstName, lastName, address, city, state,
						phoneNumber, email, password);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return manager;
	}

}
