package com.revature.dao;

import java.util.ArrayList;

import com.revature.beans.Event;
import com.revature.beans.Request;

public interface EventDao {

	public ArrayList<Request> getAllRequests();

	public ArrayList<Request> getAllApproved();

	public ArrayList<Request> getAllDenied();

	public ArrayList<Request> getAllPending();

	public ArrayList<Request> getEventsByRequest(int rid);

	public Event getEventById(int eid);

}
