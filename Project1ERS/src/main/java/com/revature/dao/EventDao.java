package com.revature.dao;

import com.revature.beans.*;

public interface EventDao {
	public boolean getEvents(Request thisRequest);
	public boolean addEvent(int requestStatusId, String message, Request thisRequest, Employee eventAuthor);
}
