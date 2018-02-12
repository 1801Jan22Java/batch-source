package com.revature.project1.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.project1.beans.Employee;
import com.revature.project1.beans.ReimbursementRequest;
import com.revature.project1.util.ConnectionUtil;

public class ReimbursementRequestDaoImpl implements ReimbursementRequestDao{
	private static String filename = "connection.properties";
	
	
	@Override
	public List<ReimbursementRequest> getReimbursementRequests() {
		System.out.println("Entered method");
		List<ReimbursementRequest> rl = new ArrayList<ReimbursementRequest>();
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		ReimbursementRequest reibReq = null;
		Connection con;
		try {
			con = ConnectionUtil.getConnectionFromFile(filename);
			PreparedStatement prepStmt= con.prepareStatement("SELECT * FROM REIBREQUEST");
			
			prepStmt.execute();
			ResultSet rs = prepStmt.getResultSet();
			System.out.println("executing query");
			while(rs.next()) {
				System.out.println("Getting reimbursement");
				int requestingEmpId=rs.getInt("REQ_EMP_ID");
				int approvingEmpId = rs.getInt("APPROVING_EMP_ID");
				int receiptID = rs.getInt("RECEIPT_ID");
				int approved= rs.getInt("APPROVED");
				int pending=rs.getInt("PENDING");
				reibReq=new ReimbursementRequest
						(edi.getEmployeeById(requestingEmpId),
								edi.getEmployeeById(approvingEmpId),receiptID,pending,approved);
				rl.add(reibReq);			
			}	
		} 
		catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return rl;
	}

	@Override
	public List<ReimbursementRequest> getReimbursementRequestsByEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReimbursementRequest getReimbursementRequestById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
