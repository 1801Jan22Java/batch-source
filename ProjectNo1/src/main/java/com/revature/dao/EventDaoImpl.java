package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.revature.beans.Event;
import com.revature.beans.Request;
import com.revature.util.ConnectionUtil;

public class EventDaoImpl implements EventDao {

	public static final String filename = "C:\\Users\\Leonard\\GitRepos\\batch-source\\Project1_Reimbursment\\connection.properties";

	public ArrayList<Event> getAllEvents() {
		ArrayList<Event> requests = new ArrayList<Event>();

		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			int eid = 0; // all valid IDs (event, request, employee, etc)
			int rid = 0; // are greater than 1000
			int empid = 0;
			Integer resolveid = 0;
			String message;
			LocalDate timestamp;
			String sql = "SELECT * FROM EVENT";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				eid = rs.getInt("EventID");
				rid = rs.getInt("RID");
				empid = rs.getInt("EmpID");
				resolveid = rs.getInt("ResolveID");
				message = rs.getString("Message");
				timestamp = rs.getDate("EventTime").toLocalDate();
				requests.add(new Event(eid, rid, empid, resolveid, message, timestamp));
			}
			con.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return requests;
	}

	public ArrayList<Event> getAllApproved() {
		ArrayList<Event> requests = new ArrayList<Event>();
		ArrayList<Event> temp = getAllEvents();
		for (Event e : temp) {
			if (e.getMessage().equals("APPROVED")) {
				requests.add(e);
			}
		}

		return requests;
	}

	public ArrayList<Event> getAllDenied() {
		ArrayList<Event> requests = new ArrayList<Event>();
		ArrayList<Event> temp = getAllEvents();
		for (Event e : temp) {
			if (e.getMessage().equals("DENIED")) {
				requests.add(e);
			}
		}

		return requests;
	}

	public ArrayList<Event> getAllPending() {
		ArrayList<Event> requests = new ArrayList<Event>();
		ArrayList<Event> temp = getAllEvents();
		for (Event e : temp) {
			if (e.getMessage().equals("PENDING")) {
				requests.add(e);
			}
		}

		return requests;
	}

	public ArrayList<Event> getEventsByRequest(int rid) {
		ArrayList<Event> requests = new ArrayList<Event>();

		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			int eid = 0; // all valid IDs (event, request, employee, etc)
			int reqId = 0; // are over 1000
			int empid = 0;
			Integer resolveid = 0;
			String message;
			LocalDate timestamp;
			String sql = "SELECT * FROM EVENT WHERE RID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, rid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				eid = rs.getInt("EventID");
				reqId = rs.getInt("RID");
				empid = rs.getInt("EmpID");
				resolveid = rs.getInt("ResolveID");
				message = rs.getString("Message");
				timestamp = rs.getDate("EventTime").toLocalDate();
				requests.add(new Event(eid, reqId, empid, resolveid, message, timestamp));
			}
			con.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return requests;
	}

	public Event getEventById(int eid) {

		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			int reqId = 0; // are over 1000
			int empid = 0;
			Integer resolveid = 0;
			String message;
			LocalDate timestamp;
			String sql = "SELECT * FROM EVENT WHERE EID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, eid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				eid = rs.getInt("EventID");
				reqId = rs.getInt("RID");
				empid = rs.getInt("EmpID");
				resolveid = rs.getInt("ResolveID");
				message = rs.getString("Message");
				timestamp = rs.getDate("EventTime").toLocalDate();
				con.close();
				return new Event(eid, reqId, empid, resolveid, message, timestamp);
			}
			con.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void addEvent(Event eve) {
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "INSERT INTO EVENT (RID, EmpID, ResolveID, Message) "
					+ " VALUES (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, eve.getRequestID());
			ps.setInt(2, eve.getEmployeeID());
			ps.setInt(3, eve.getManagerID());
			ps.setString(4, eve.getMessage());
			ps.executeUpdate();
			con.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
