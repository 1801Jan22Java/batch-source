package com.revature.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.ManagerDaoImpl;
import com.revature.dao.RequestDaoImpl;
import com.revature.dao.RequestLogDaoImpl;

/**
 * Servlet that handles the Manager's response when a Manager chooses to
 * approve or deny a reimbursement request.
 */
public class RespondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}



	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int approved = 2;
		int declined = 3;
		
		RequestDaoImpl rdi = new RequestDaoImpl();
		RequestLogDaoImpl rldi = new RequestLogDaoImpl();
		ManagerDaoImpl mdi = new ManagerDaoImpl();
		
		HttpSession session = req.getSession(false);
		
		if(req.getParameter("approve") != null) {
			//Approve all checked requests
			String[] approvedIDStrs = req.getParameterValues("selected");
			int[] approvedIDInts = new int[approvedIDStrs.length];
			for(int i = 0; i < approvedIDStrs.length; i++) {
				approvedIDInts[i] = Integer.valueOf(approvedIDStrs[i]);
			}
			
			
			for(int i = 0; i < approvedIDInts.length; i++) {
				//Approve the request
				rdi.updateRequest(approvedIDInts[i], approved);
				
				//Get the manager's ID
				int managerID = mdi.getManagerID(Integer.valueOf(session.getAttribute("id").toString()));
				
				//Create a RequestLog now that the request is approved
				rldi.createRequestLog(approvedIDInts[i], req.getParameter("description"),
						managerID, approved, Double.valueOf(req.getParameter("amount").toString()));
			}
			
			
			
		} else if (req.getParameter("decline") != null) {
			//Decline all checked requests
			String[] declinedIDStrs = req.getParameterValues("selected");
			int[] declinedIDInts = new int[declinedIDStrs.length];
			for(int i = 0; i < declinedIDStrs.length; i++) {
				declinedIDInts[i] = Integer.valueOf(declinedIDStrs[i]);
			}
			
			
			for(int i = 0; i < declinedIDInts.length; i++) {
				//Approve the request
				rdi.updateRequest(declinedIDInts[i], declined);
				
				//Get the manager's ID
				int managerID = mdi.getManagerID(Integer.valueOf(session.getAttribute("id").toString()));
				
				//Create a RequestLog now that the request is approved
				rldi.createRequestLog(declinedIDInts[i], req.getParameter("description"),
						managerID, declined, Double.valueOf(req.getParameter("amount").toString()));
			}
			
			
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("managerequests");
		rd.forward(req, resp);	
	}

}
