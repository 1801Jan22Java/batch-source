package com.revature.dao;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
		try(Connection con = ConnectionUtil.getConnectionFromFile()) {
			
			// result is a placeholder variable for creating employees to insert into the list
			Reimbursement result;
			String sql = "SELECT * FROM Reimbursement";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int reimbursementId = rs.getInt("REIMBURSEMENT_ID");
				int employeeId = rs.getInt("EMPLOYEE_ID");
				int managerId = rs.getInt("MANAGER_ID");
				int status = rs.getInt("STATUS_ID");
				double reimbursementValue = rs.getDouble("REIMBURSEMENT_VALUE");
				Blob blob = rs.getBlob("IMAGE");
				InputStream in = blob.getBinaryStream();
				ByteArrayOutputStream bao = new ByteArrayOutputStream();
				int c = 0;
				int count = 0;
				while((c=in.read()) != -1) {
					bao.write(c);
					count += 1;
				}
				byte [] byteArr = bao.toByteArray();
				result = new Reimbursement(reimbursementId,employeeId,managerId,status,reimbursementValue,byteArr);
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
	public List<Reimbursement> getReimbursementByEmployeeId(int requestedEmployeeId) {
		
		List<Reimbursement> listReimbursement = new ArrayList<Reimbursement>();
		try(Connection con = ConnectionUtil.getConnectionFromFile()) {
			
			// result is a placeholder variable for creating employees to insert into the list
			Reimbursement result;
			String sql = "SELECT * FROM Reimbursement WHERE EMPLOYEE_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, requestedEmployeeId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int reimbursementId = rs.getInt("REIMBURSEMENT_ID");
				int employeeId = rs.getInt("EMPLOYEE_ID");
				int managerId = rs.getInt("MANAGER_ID");
				int status = rs.getInt("STATUS_ID");
				double reimbursementValue = rs.getDouble("REIMBURSEMENT_VALUE");
				Blob blob = rs.getBlob("IMAGE");
				InputStream in = blob.getBinaryStream();
				ByteArrayOutputStream bao = new ByteArrayOutputStream();
				int c = 0;
				int count = 0;
				while((c=in.read()) != -1) {
					bao.write(c);
					count += 1;
				}
				byte [] byteArr = bao.toByteArray();
				result = new Reimbursement(reimbursementId,employeeId,managerId,status,reimbursementValue,byteArr);
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
		try(Connection con = ConnectionUtil.getConnectionFromFile()) {
			
			String sql = "SELECT * FROM REIMBURSEMENT WHERE REIMBURSEMENT_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, requestedReimbursementId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int reimbursementId = rs.getInt("REIMBURSEMENT_ID");
				int employeeId = rs.getInt("EMPLOYEE_ID");
				int managerId = rs.getInt("MANAGER_ID");
				int status = rs.getInt("STATUS_ID");
				double reimbursementValue = rs.getDouble("REIMBURSEMENT_VALUE");
				Blob blob = rs.getBlob("IMAGE");
				InputStream in = blob.getBinaryStream();
				ByteArrayOutputStream bao = new ByteArrayOutputStream();
				int c = 0;
				int count = 0;
				while((c=in.read()) != -1) {
					bao.write(c);
					count += 1;
				}
				byte [] byteArr = bao.toByteArray();
				reimbursementResult = new Reimbursement(reimbursementId,employeeId,managerId,status,reimbursementValue,byteArr);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return reimbursementResult;
	}

	@Override
	public int submitReimbursement(int requestedReimbursementId, double reimbursementValue, byte [] byteArr) {
		int reimbursementId = -1;
		try(Connection con = ConnectionUtil.getConnectionFromFile()) {
			Blob blob = con.createBlob();
			System.out.println("not null");
			ReimbursementDao rd = new ReimbursementDaoSQL();
			OutputStream out = blob.setBinaryStream(1);

			out.write(byteArr);
			out.close();
			System.out.println(blob.length());
			con.setAutoCommit(false);
			String sql = "{call ADD_REIMBURSEMENT(?,?,?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			cs.setInt(1, requestedReimbursementId);
			cs.setDouble(2, reimbursementValue);
			cs.setBlob(3, blob);
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
	public void updateStatus(int reimbursementId, int managerId, int statusId) {
		try(Connection con = ConnectionUtil.getConnectionFromFile()) {
			con.setAutoCommit(false);
			String sql = "{call UPDATE_REIMBURSEMENT(?,?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			cs.setInt(1, reimbursementId);
			cs.setInt(2, managerId);
			cs.setInt(3, statusId);

			
			cs.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
