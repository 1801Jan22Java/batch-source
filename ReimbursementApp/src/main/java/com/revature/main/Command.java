package com.revature.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {

	void execute (HttpServletRequest req, HttpServletResponse resp);
	
}
