package com.revature.dao;

import java.util.ArrayList;

import com.revature.beans.Event;
import com.revature.beans.Request;

public interface EventDao {
	
	public void addEvent(Event e);

	public ArrayList<Event> getAllEvents();

	public ArrayList<Event> getAllApproved();

	public ArrayList<Event> getAllDenied();

	public ArrayList<Event> getAllPending();

	public ArrayList<Event> getEventsByRequest(int rid);

	public Event getEventById(int eid);

}
