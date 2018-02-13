package com.revature.dao;

import java.io.IOException;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import com.revature.beans.Employee;
import com.revature.beans.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementDaoSQL implements ReimbursementDao {

	@Override
	public List<Reimbursement> getReimbursement() {
		List<Reimbursement> listReimbursement = new ArrayList<Reimbursement>();
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			
			// result is a placeholder variable for creating employees to insert into the list
			Reimbursement result;
			String sql = "SELECT * FROM Reimbursement";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int reimbursementId = rs.getInt("EMPLOYEE_ID");
				int employeeId = rs.getInt("EMPLOYEE_ID");
				int managerId = rs.getInt("MANAGER_ID");
				int status = rs.getInt("STATUS_ID");
				double reimbursementValue = rs.getDouble("REIMBURSEMENT_VALUE");
				Blob image = rs.getBlob("IMAGE");
				
				result = new Reimbursement(reimbursementId,employeeId,managerId,status,reimbursementValue,image);
				listReimbursement.add(result);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listReimbursement;
	}

	@Override
	public Reimbursement getReimbursementByID(int requestedReimbursementId) {
		Reimbursement reimbursementResult = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			
			String sql = "SELECT * FROM EMPLOYEE WHERE EMPLOYEE_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, requestedReimbursementId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int reimbursementId = rs.getInt("EMPLOYEE_ID");
				int employeeId = rs.getInt("EMPLOYEE_ID");
				int managerId = rs.getInt("MANAGER_ID");
				int status = rs.getInt("STATUS_ID");
				double reimbursementValue = rs.getDouble("REIMBURSEMENT_VALUE");
				Blob image = rs.getBlob("IMAGE");
				
				reimbursementResult = new Reimbursement(reimbursementId,employeeId,managerId,status,reimbursementValue,image);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return reimbursementResult;
	}

	@Override
	public int sumbitReimbursement(int requestedReimbursementId, double reimbursementValue, Blob image) {
		int reimbursementId = -1;
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			con.setAutoCommit(false);
			String sql = "{call ADD_REIMBURSEMENT(?,?,?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			cs.setInt(1, requestedReimbursementId);
			cs.setDouble(2, reimbursementValue);
			cs.setBlob(3, image);
			cs.registerOutParameter(4, java.sql.Types.INTEGER);
			cs.execute();
			reimbursementId = cs.getInt(4);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return reimbursementId;
	}

	@Override
	public boolean updateStatus(int reimbursementId, int managerId, int statusId) {
		boolean flag = false;
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			con.setAutoCommit(false);
			String sql = "{call UPDATE_REIMBURSEMENT(?,?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			cs.setInt(1, reimbursementId);
			cs.setInt(2, managerId);
			cs.setInt(3, statusId);

			
			flag = cs.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return flag;
	}

}
