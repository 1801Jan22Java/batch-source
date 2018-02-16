package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.Event;
import com.revature.beans.Request;
import com.revature.util.ConnectionUtil;

public class EventDaoImpl implements EventDao {

	public static final String filename = "connection.properties";
	
	public EventDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Request> getAllRequests() {
		ArrayList<Request> requests = new ArrayList<Request>();
		
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			
			con.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return requests;
	}

	public ArrayList<Request> getAllApproved() {
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			
			con.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Request> getAllDenied() {
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			
			con.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Request> getAllPending() {
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			
			con.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Request> getEventsByRequest(int rid) {
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			
			con.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Event getEventById(int eid) {
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			
			con.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
