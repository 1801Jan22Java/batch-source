package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.ManagerInformation;
import com.revature.util.ConnectionUtil;

public class ManagerInformationDaoSQL implements ManagerInformationDao {
	
	// returns a list of every Managerinformation in the database
		// if there is no Managerinformation in the DB then the list is empty
		public List<ManagerInformation> getManagerInformation() {
			
			// initializes a list to return, if the list is empty it is not for the
			// Dao object to decide
			List<ManagerInformation> listManagerInformation = new ArrayList<ManagerInformation>();
			try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")) {
				
				// result is a placeholder variable for creating Managers to insert into the list
				ManagerInformation result;
				String sql = "SELECT * FROM Manager";
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					int managerInformationId = rs.getInt("MANAGER_INFO_ID");
					String email = rs.getString("EMAIL");
					String firstname = rs.getString("FIRSTNAME");
					String lastname = rs.getString("LASTNAME");
					String address = rs.getString("ADDRESS");
					result = new ManagerInformation(managerInformationId,email,firstname,lastname,address);
					listManagerInformation.add(result);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return listManagerInformation;
		}

		// get an ManagerInformation from the database using the Id 
		// to be used predominately by the application no the user
		public ManagerInformation getManagerInformationByID(int requestedManagerInformationId) {
			// if ManagerInformationResult is null then you could not find the requested Id
			// not for this function to decide what to do with that information
			ManagerInformation managerInformationResult = null;
			try(Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
				
				String sql = "SELECT * FROM MANAGERINFO WHERE MANAGER_ID = ?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, requestedManagerInformationId);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					int managerInformationId = rs.getInt("MANAGER_INFO_ID");
					String email = rs.getString("EMAIL");
					String firstname = rs.getString("FIRSTNAME");
					String lastname = rs.getString("LASTNAME");
					String address = rs.getString("ADDRESS");
					managerInformationResult = new ManagerInformation(managerInformationId,email,firstname,lastname,address);
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return managerInformationResult;
		}

		@Override
		public boolean updateInformation(int managerInformationId,String email,String fname,String lname,String address) {
			boolean flag = false;
			try(Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
				con.setAutoCommit(false);
				String sql = "{call UPDATE_MANAGER_INFORMATION(?,?,?,?,?)}";
				CallableStatement cs = con.prepareCall(sql);
				cs.setInt(1, managerInformationId);
				cs.setString(2, email);
				cs.setString(3, fname);
				cs.setString(4, lname);
				cs.setString(5, address);
				
				flag = cs.execute();

			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return flag;
		}

}
