package com.revature.project1.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.project1.beans.Employee;
import com.revature.project1.beans.ReimbursementRequest;
import com.revature.project1.util.ConnectionUtil;

public class ReimbursementRequestDaoImpl implements ReimbursementRequestDao {
	private static String filename = "connection.properties";

	@Override
	public List<ReimbursementRequest> getReimbursementRequests() {
		// System.out.println("Entered method");
		List<ReimbursementRequest> rl = new ArrayList<ReimbursementRequest>();
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		ReimbursementRequest reibReq = null;
		Connection con;
		try {
			con = ConnectionUtil.getConnectionFromFile();
			PreparedStatement prepStmt = con.prepareStatement("SELECT * FROM REIBREQUEST");

			prepStmt.execute();
			ResultSet rs = prepStmt.getResultSet();
			// System.out.println("executing query");
			while (rs.next()) {
				// System.out.println("Getting reimbursement");
				int requestID = rs.getInt("REQ_ID");
				int requestingEmpId = rs.getInt("REQ_EMP_ID");
				int approvingEmpId = rs.getInt("APPROVING_EMP_ID");
				int approved = rs.getInt("APPROVED");
				int pending = rs.getInt("PENDING");
				float amount = rs.getFloat("AMOUNT");
				String description=rs.getString("DESCRIPTION");
				reibReq = new ReimbursementRequest(requestID, edi.getEmployeeById(requestingEmpId),
						edi.getEmployeeById(approvingEmpId), pending, approved, amount,description);
				rl.add(reibReq);
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return rl;
	}

	@Override
	public List<ReimbursementRequest> getReimbursementRequestsByEmployee(Employee employee) {
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		List<ReimbursementRequest> rl = new ArrayList<ReimbursementRequest>();
		ReimbursementRequest rr = null;
		File receipt=null;
		if (verifyEmployeePermission(employee)) {
			int id = edi.getEmployeeID(employee);
			//try (Connection con = ConnectionUtil.getConnectionFromFile(filename))
			try (Connection con = ConnectionUtil.getConnectionFromFile()){
				String sql = "SELECT * FROM REIBREQUEST WHERE APPROVING_EMP_ID=? OR REQ_EMP_ID=? ORDER BY PENDING, APPROVED";
				PreparedStatement prepStmt = con.prepareStatement(sql);
				prepStmt.setInt(1, id);
				prepStmt.setInt(2, id);
				ResultSet rs = prepStmt.executeQuery();
				while (rs.next()) {
					int reqID = rs.getInt("REQ_ID");
					int empID = rs.getInt("REQ_EMP_ID");
					int mgrID = rs.getInt("APPROVING_EMP_ID");
					int approved = rs.getInt("APPROVED");
					int pending = rs.getInt("PENDING");
					float amount = rs.getFloat("AMOUNT");
					String description=rs.getString("DESCRIPTION");
					String extension = rs.getString("EXTENSION");
					
					/*if(!(rs.getBlob("RECEIPT")==null))	{
					Blob blob = rs.getBlob("RECEIPT");
					InputStream is = blob.getBinaryStream();
					int b= is.read();
					receipt=new File("C:\\temp\\"+extension);
					FileOutputStream os = new FileOutputStream(receipt);
				
					
					while(is.read()!=-1) {
						os.write(b);
						os.flush();
					}
					is.close();
					os.close();
				
					}
					
					*/
					Employee verified = edi.getEmployeeById(empID);
					Employee manager = edi.getEmployeeById(mgrID);
					rr = new ReimbursementRequest(reqID,verified, manager, pending, approved, receipt, amount, description,extension);
					rl.add(rr);
				}
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("You do not have any requests to view");
		}
		return rl;
	}

	public boolean verifyEmployeePermission(Employee employee) {
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		boolean verified = false;
		List<ReimbursementRequest> rl = new ArrayList<ReimbursementRequest>();
		int id=0;
		ReimbursementRequest rr = null;
		try {
		 id = edi.getEmployeeID(employee);
		}
		catch(NullPointerException e) 
		{
			System.out.println("There is no such employee");
		}
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "SELECT * FROM REIBREQUEST WHERE APPROVING_EMP_ID=? OR REQ_EMP_ID=?";
			PreparedStatement prepStmt = con.prepareStatement(sql);
			prepStmt.setInt(1, id);
			prepStmt.setInt(2, id);
			ResultSet rs = prepStmt.executeQuery();
			if (rs.next()) {
				verified = true;
			} else {
				verified = false;
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return verified;
		}

	}

	@Override
	public ReimbursementRequest getReimbursementRequestById(int id) {
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		ReimbursementRequest reibReq = null;
		File file = null;
		Connection con;
		try {
			con = ConnectionUtil.getConnectionFromFile();
			PreparedStatement prepStmt = con.prepareStatement("SELECT * FROM REIBREQUEST WHERE REQ_ID=?");
			prepStmt.setInt(1, id);
			;
			prepStmt.execute();
			ResultSet rs = prepStmt.getResultSet();
			// System.out.println("executing query");
			while (rs.next()) {
				// System.out.println("Getting reimbursement");
				int requestID = rs.getInt("REQ_ID");
				int requestingEmpId = rs.getInt("REQ_EMP_ID");
				int approvingEmpId = rs.getInt("APPROVING_EMP_ID");
				int approved = rs.getInt("APPROVED");
				int pending = rs.getInt("PENDING");
				float amount = rs.getFloat("AMOUNT");
				String description=rs.getString("DESCRIPTION");
				reibReq = new ReimbursementRequest(requestID, edi.getEmployeeById(requestingEmpId),
						edi.getEmployeeById(approvingEmpId), pending, approved, amount,description);
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		} finally {
			return reibReq;
		}

	}

	@Override
	public void denyReimbursementRequest(int reqID, Employee manager) {
		ReimbursementRequest req = getReimbursementRequestById(reqID);
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		Connection con;
		if (req.getManager().getUserName().equals(manager.getUserName())) {
			int managerID = edi.getEmployeeID(manager);
			try {
				con = ConnectionUtil.getConnectionFromFile();
				CallableStatement cs = con.prepareCall("{CALL SP_DENY_REQUEST(?,?)}");
				cs.setInt(1, reqID);
				cs.setInt(2, managerID);
				cs.execute();
				System.out.println("request successfully denied. cheap skate");
			} catch (IOException | SQLException e) {
				e.printStackTrace();
				System.out.println("Something went wrong");
			}
		} else {
			System.out.println("You do not have permission to edit that request");
		}

	}

	@Override
	public void approveReimbursementRequest(int reqID, Employee manager) {
		ReimbursementRequest req = getReimbursementRequestById(reqID);
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		Connection con;
		if (req.getManager().getUserName().equals(manager.getUserName())) {
			int managerID = edi.getEmployeeID(manager);
			try {
				con = ConnectionUtil.getConnectionFromFile();
				CallableStatement cs = con.prepareCall("{CALL SP_APPROVE_REQUEST(?,?)}");
				cs.setInt(1, reqID);
				cs.setInt(2, managerID);
				cs.execute();
				System.out.println("request successfully approved. Way to throw money away.");
			} catch (IOException | SQLException e) {
				e.printStackTrace();
				System.out.println("Something went wrong");
			}
		} else {
			System.out.println("You do not have permission to edit that request");
		}
	}

	@Override
	public void addReimbursementRequest(Employee emp, File file, float amount, String descript,String filename) {
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		int empID = edi.getEmployeeID(emp);
		System.out.println("employee id is: " + empID);
		Connection con;
		FileInputStream input = null;
		try {
			input = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("That file was not found");
		}
		try {
			con = ConnectionUtil.getConnectionFromFile();
			CallableStatement cs = con.prepareCall("{CALL SP_ADD_REIB_REQUEST(?,?,?,?,?)}");
			cs.setInt(1, empID);
			cs.setFloat(2, amount);
			cs.setBlob(3, input);
			cs.setString(4, descript);
			cs.setString(5, filename);
			cs.execute();
			System.out.println("request successfully added.  Good luck on that...");
		} catch (IOException | SQLException e) {
			e.printStackTrace();
			System.out.println("Something went wrong");
		}

	}

	@Override
	public void deleteReimbursementRequest(int reqID, Employee emp) {
		ReimbursementRequest req = getReimbursementRequestById(reqID);

	}



}
