package com.revature.dao;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.Manager;
import com.revature.beans.Reimb;
import com.revature.util.ConnectionUtil;

public class ReimbDaoImpl implements ReimbDao {
	
	private static String filename = "connection.properties";

	public void createReimb(Reimb r) {
		CallableStatement cstmt = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "{CALL CREATE_REIMB(?, ?, ?, ?, ?)}";
			
			cstmt = con.prepareCall(sql);
			cstmt.setInt(1, r.getEmpId());
			cstmt.setDouble(2, r.getAmt());
			cstmt.setInt(3, r.getStatus());
			InputStream in = new ByteArrayInputStream(r.getImage());
			cstmt.setBinaryStream(4, in, in.available());
			cstmt.setDate(5, r.getDoc());
			cstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Reimb> getAllReimbs() {
		PreparedStatement pstmt = null;
		List<Reimb> reimbs = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			reimbs = new ArrayList<Reimb>();
			String sql = "SELECT * FROM REIMB";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int reimbId = rs.getInt("REIMB_ID");
				int empId = rs.getInt("EMPLOYEE_ID");
				int mgrId = rs.getInt("MANAGER_ID");
				double amt = rs.getDouble("AMOUNT");
				int sts = rs.getInt("STATUS");
				Blob imgData = rs.getBlob("IMAGE");
				byte[] img = new byte[(int) imgData.length()];
				img = imgData.getBytes(1, (int) imgData.length());
				Date dc = rs.getDate("DOC");
				Date dod = rs.getDate("DOAD");
				
				reimbs.add(new Reimb(reimbId, empId, mgrId, amt, sts, img, dc, dod));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return reimbs;
	}

	public List<Reimb> getPendingReimbs() {
		PreparedStatement pstmt = null;
		List<Reimb> reimbs = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			reimbs = new ArrayList<Reimb>();
			String sql = "SELECT * FROM REIMB WHERE STATUS=0";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int reimbId = rs.getInt("REIMB_ID");
				int empId = rs.getInt("EMPLOYEE_ID");
				int mgrId = rs.getInt("MANAGER_ID");
				double amt = rs.getDouble("AMOUNT");
				int sts = rs.getInt("STATUS");
				Blob imgData = rs.getBlob("IMAGE");
				byte[] img = new byte[(int) imgData.length()];
				img = imgData.getBytes(1, (int) imgData.length());
				Date dc = rs.getDate("DOC");
				Date dod = rs.getDate("DOAD");
				
				reimbs.add(new Reimb(reimbId, empId, mgrId, amt, sts, img, dc, dod));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return reimbs;
	}

	public List<Reimb> getResolvedReimbs() {
		PreparedStatement pstmt = null;
		List<Reimb> reimbs = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			reimbs = new ArrayList<Reimb>();
			String sql = "SELECT * FROM REIMB WHERE STATUS=1";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int reimbId = rs.getInt("REIMB_ID");
				int empId = rs.getInt("EMPLOYEE_ID");
				int mgrId = rs.getInt("MANAGER_ID");
				double amt = rs.getDouble("AMOUNT");
				int sts = rs.getInt("STATUS");
				Blob imgData = rs.getBlob("IMAGE");
				byte[] img = new byte[(int) imgData.length()];
				img = imgData.getBytes(1, (int) imgData.length());
				Date dc = rs.getDate("DOC");
				Date dod = rs.getDate("DOAD");
				
				reimbs.add(new Reimb(reimbId, empId, mgrId, amt, sts, img, dc, dod));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return reimbs;
	}

	public List<Reimb> getAllReqFromEmp(Employee emp) {
		PreparedStatement pstmt = null;
		List<Reimb> reimbs = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			reimbs = new ArrayList<Reimb>();
			String sql = "SELECT * FROM REIMB WHERE EMPLOYEE_ID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, emp.getEmpId());
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int reimbId = rs.getInt("REIMB_ID");
				int empId = rs.getInt("EMPLOYEE_ID");
				int mgrId = rs.getInt("MANAGER_ID");
				double amt = rs.getDouble("AMOUNT");
				int sts = rs.getInt("STATUS");
				Blob imgData = rs.getBlob("IMAGE");
				byte[] img = new byte[(int) imgData.length()];
				img = imgData.getBytes(1, (int) imgData.length());
				Date dc = rs.getDate("DOC");
				Date dod = rs.getDate("DOAD");
				
				reimbs.add(new Reimb(reimbId, empId, mgrId, amt, sts, img, dc, dod));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return reimbs;
	}
	
	public List<Reimb> getAllPendingReqFromEmp(Employee emp) {
		PreparedStatement pstmt = null;
		List<Reimb> reimbs = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			reimbs = new ArrayList<Reimb>();
			String sql = "SELECT * FROM REIMB WHERE EMPLOYEE_ID=? AND STATUS=0";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, emp.getEmpId());
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int reimbId = rs.getInt("REIMB_ID");
				int empId = rs.getInt("EMPLOYEE_ID");
				int mgrId = rs.getInt("MANAGER_ID");
				double amt = rs.getDouble("AMOUNT");
				int sts = rs.getInt("STATUS");
				Blob imgData = rs.getBlob("IMAGE");
				byte[] img = new byte[(int) imgData.length()];
				img = imgData.getBytes(1, (int) imgData.length());
				Date dc = rs.getDate("DOC");
				Date dod = rs.getDate("DOAD");
				
				reimbs.add(new Reimb(reimbId, empId, mgrId, amt, sts, img, dc, dod));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return reimbs;
	}
	
	public List<Reimb> getAllResolvedReqFromEmp(Employee emp) {
		PreparedStatement pstmt = null;
		List<Reimb> reimbs = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			reimbs = new ArrayList<Reimb>();
			String sql = "SELECT * FROM REIMB WHERE EMPLOYEE_ID=? AND STATUS=1";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, emp.getEmpId());
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int reimbId = rs.getInt("REIMB_ID");
				int empId = rs.getInt("EMPLOYEE_ID");
				int mgrId = rs.getInt("MANAGER_ID");
				double amt = rs.getDouble("AMOUNT");
				int sts = rs.getInt("STATUS");
				Blob imgData = rs.getBlob("IMAGE");
				byte[] img = new byte[(int) imgData.length()];
				img = imgData.getBytes(1, (int) imgData.length());
				Date dc = rs.getDate("DOC");
				Date dod = rs.getDate("DOAD");
				
				reimbs.add(new Reimb(reimbId, empId, mgrId, amt, sts, img, dc, dod));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return reimbs;
	}

	public void approve(Manager mgr, Reimb r) {
		CallableStatement cstmt = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "{CALL UPDATE_REIMB(?, ?, ?)}";
			
			cstmt = con.prepareCall(sql);
			cstmt.setInt(1, r.getReimbId());
			cstmt.setDouble(2, mgr.getMgrId());
			r.setMgrId(mgr.getMgrId());
			cstmt.setInt(3, 1);
			r.setStatus(1);
			cstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void deny(Manager mgr, Reimb r) {
		CallableStatement cstmt = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "{CALL UPDATE_REIMB(?, ?, ?)}";
			
			cstmt = con.prepareCall(sql);
			cstmt.setInt(1, r.getReimbId());
			cstmt.setDouble(2, mgr.getMgrId());
			r.setMgrId(mgr.getMgrId());
			cstmt.setInt(3, 2);
			r.setStatus(2);
			cstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
