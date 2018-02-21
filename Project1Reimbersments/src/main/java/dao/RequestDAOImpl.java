package dao;
//Fin
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Document;
import beans.Request;
import beans.Status;
import util.ConnectionUtil;

public class RequestDAOImpl implements RequestDAO
{
	private static String filename = "Properties";
	@Override
	public ArrayList<Request> getRequest() 
	{
		ArrayList<Request> reqs = new ArrayList<Request>();
		try(Connection con = ConnectionUtil.getConnectionFromFile())
		{
			String sql = "SELECT * FROM REQUEST";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(stmt);
			
			while (rs.next())
			{
				int employeeId = rs.getInt("EMPLOYEE_ID");
				float amountRequested = rs.getFloat("AMOUNT_REQUEST");
				int statusId = rs.getInt("STATUS");
				int reqId = rs.getInt("REQUEST_ID");
				Request r = new Request(reqId, employeeId, amountRequested, statusId);
				reqs.add(r);
			}	
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		return reqs;
	}

	@Override
	public ArrayList<Document> getRequestDocuments(int requestId) {
		DocumentDAOImpl docdao = new DocumentDAOImpl();
		docdao.getDocuments(requestId);
		return null;
	}

	@Override
	public float getAmount(int requestId) {
		for( Request r: this.getRequest())
		{
			if(r.getRequestId()==requestId)
			{
				return r.getAmountRequested();
			}
		}
		return -1;
	}

	@Override
	public int getStatus(int requestId) {
		for( Request r: this.getRequest())
		{
			if(r.getRequestId()==requestId)
			{
				return r.getStatus();
			}
		}
		return -1;
	}

	@Override
	public boolean addRequest(int employeeId, float requestAmount, String details) {
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile())
		{
			String sql = "INSERT INTO REQUEST(EMPLOYEE_ID, AMOUNT_REQUEST, REQUEST_DETAILS, STATUS) VALUES(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setFloat(2, requestAmount); 
			pstmt.setInt(1, employeeId);  // set the PK value
			pstmt.setString(3, details);
			pstmt.setInt(4, 101);
			pstmt.executeUpdate();
			pstmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return false;
	}

	@Override
	public float updateAmountRequested(int requestId, float newAmount) {
		try(Connection con = ConnectionUtil.getConnectionFromFile())
		{
			String sql = "UPDATE AMOUNT_REQUEST = ? FROM REQUESTS WHERE REQUEST_ID = ?";
			PreparedStatement pstmt = null;
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(2, requestId);
			pstmt.setFloat(1, newAmount);
			pstmt.execute();
			return newAmount;
		}
		catch (SQLException e1)
		{
			e1.printStackTrace();
		} 
		catch (IOException e2) 
		{
			e2.printStackTrace();
		}
		return -1;
	}

	@Override
	public boolean changeStaus(int requestId, int newStatus) {
		try(Connection con = ConnectionUtil.getConnectionFromFile())
		{
			String sql = "UPDATE STATUS = ? FROM REQUESTs WHERE REQUEST_ID = ?";
			PreparedStatement pstmt = null;
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, newStatus);
			pstmt.setFloat(2, requestId);
			return pstmt.execute();
		}
		catch (SQLException e1)
		{
			e1.printStackTrace();
		} 
		catch (IOException e2) 
		{
			e2.printStackTrace();
		}
		return false;
	}
	public ArrayList<Request> getRequests(int empId)
	{
		ArrayList<Request> requests = new ArrayList<Request>();
		for( Request r: this.getRequest())
		{
			if (r.getEmployeeId()==empId)
			{
				requests.add(r);
			}
		}
		return requests;
	}
	public static void main(String[] args) 
	{
		RequestDAOImpl imp = new RequestDAOImpl();
		System.out.println(imp.getRequests(1012));
	}
}
