package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.revature.beans.Employee;
import com.revature.beans.Event;
import com.revature.beans.Request;
import com.revature.util.ConnectionUtil;
import com.revature.util.InvalidActionException;

public class RequestDaoImpl implements RequestDao {

	public static final String filename = "C:\\Users\\Leonard\\GitRepos\\batch-source\\ProjectNo1\\connection.properties";
	// I know it's a horrible practice, but a FileNotFoundException was giving me grief
	// and copy/pasting the file to every folder in the project didn't solve a thing. So, I'm using an absolute path to get it working.
	public void addRequest(Request req) {

		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "INSERT INTO REQUEST (EmpID, Amount, Status, Message) VALUES (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, req.getEmployeeID());
			ps.setDouble(2, req.getAmount());
			ps.setString(3, req.getStatus());
			ps.setString(4, req.getDescription());
			ps.executeUpdate();

			String query = "SELECT RID FROM REQUEST WHERE EmpID = ? AND Message = ? AND Amount = ?";

			PreparedStatement ps0 = con.prepareStatement(query);
			ps0.setInt(1, req.getEmployeeID());
			ps0.setString(2, req.getDescription());
			ps0.setDouble(3, req.getAmount());
			ResultSet rs0 = ps0.executeQuery();
			int rid = 0;
			if (rs0.next()) {
				rid = rs0.getInt("RID");
			}
			con.close();
			String eventMessage = "ADDED NEW REQUEST" + " ID = " + rid;
			EventDaoImpl edi = new EventDaoImpl();
			edi.addEvent(new Event(rid, req.getEmployeeID(), 0, eventMessage));

		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Request> getEmployeeRequests(int eid) {
		ArrayList<Request> requests;
		try {
			requests = new ArrayList<Request>();
			int requestID = 0;
			int employeeID = 0;
			Integer resolveID; // wrapper class b/c database field is nullable
			Double amount = 0.0;
			LocalDate whenRequested;
			String status;
			String message;
			String reply;
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "SELECT * FROM REQUEST WHERE EMPID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, eid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				requestID = rs.getInt("RID");
				resolveID = rs.getInt("ResolveID");
				amount = rs.getDouble("Amount");
				whenRequested = rs.getDate("whenMade").toLocalDate();
				status = rs.getString("Status");
				message = rs.getString("Message");
				reply = rs.getString("Reply");

				requests.add(
						new Request(requestID, eid, resolveID, amount, message, reply, status, whenRequested));
			}

			con.close();
			return requests;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Request> getAllRequests() {
		ArrayList<Request> requests;
		try {
			requests = new ArrayList<Request>();
			int requestID = 0;
			int employeeID = 0;
			Integer resolveID; // wrapper class b/c database field is nullable
			Double amount = 0.0;
			LocalDate whenRequested;
			String status;
			String message;
			String reply;
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "SELECT * FROM REQUEST";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				requestID = rs.getInt("RID");
				employeeID = rs.getInt("EmpID");
				resolveID = rs.getInt("ResolveID");
				amount = rs.getDouble("Amount");
				whenRequested = rs.getDate("whenMade").toLocalDate();
				status = rs.getString("Status");
				message = rs.getString("Message");
				reply = rs.getString("Reply");

				requests.add(
						new Request(requestID, employeeID, resolveID, amount, message, reply, status, whenRequested));
			}

			con.close();
			return requests;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void resolveRequest(Request req, Employee emp, String reply) throws InvalidActionException {
		// emp arg is the resolving employee. Can be a manager or the employee
		// who made the request, on condition that the request is either
		// being Revoked or Denied. Any employee, manager or not, can revoke or deny
		// their own request

		if (!emp.isManager() && (!((req.getStatus() == "REVOKED") || (req.getStatus() == "DENIED")))) {
			throw new InvalidActionException("Employee doesn't have this permission!");
		}
		if (emp.isManager() && (req.getEmployeeID() == emp.getEmployeeID())) {
			if (!((req.getStatus() == "REVOKED") || (req.getStatus() == "DENIED"))) {
				throw new InvalidActionException("Manager cannot approve their own request!");
			}
		}

		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "UPDATE Request SET ResolveID = ?, Status = ?, Reply = ?  WHERE RID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, emp.getEmployeeID());
			ps.setString(2, req.getStatus());
			ps.setString(3, req.getReply());
			ps.setInt(4, req.getRequestID());
			ps.executeUpdate();

			con.close();

			EventDaoImpl edi = new EventDaoImpl();
			String message = req.getStatus() + " REQUEST";
			edi.addEvent(new Event(req.getRequestID(), req.getEmployeeID(), req.getManagerID(), message));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
