package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Staff;
import com.revature.dao.ReimbReqDAO;
import com.revature.dao.ReimbReqDAOImpl;
import com.revature.dao.StaffDAO;
import com.revature.dao.StaffDAOImpl;

public class NewReqServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public NewReqServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		resp.setContentType("text/html");
		String reqName = req.getParameter("reqName");
		// amount is taken as string then converted to double type
		String strAmount = req.getParameter("amount");
		double amount = Double.valueOf(strAmount);
		String receipt = req.getParameter("receipt");
		
		String email = session.getAttribute("email").toString();
		StaffDAO getStaff = new StaffDAOImpl();
		Staff currStaff = getStaff.getStaff(email);
		ReimbReqDAO newReq = new ReimbReqDAOImpl();
		int successAdd = newReq.addNewReimbReq(reqName, amount, currStaff.getEmployeeId(), "pending", receipt);
		if(successAdd == 1) {
			System.out.println("Added new reimbursement success!");
		}
		resp.sendRedirect("employeeHome");
	
	}
	
}
