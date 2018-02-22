package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.RequestDao;
import com.revature.dao.RequestDaoImpl;

/**
 * Servlet implementation class EditRequestServlet
 */
public class EditRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		int id = Integer.parseInt(request.getParameter("id"));
		String status = request.getParameter("status");
		String notes = request.getParameter("notes");
		RequestDao rd = new RequestDaoImpl();
		boolean edited = false;
		if(status.equalsIgnoreCase("Approved"))
		{
			rd.updateRequest(id, "1004", "Status_Id");
			edited = true;
		}	
		if(status.equalsIgnoreCase("Declined"))
		{
			rd.updateRequest(id, "1005", "Status_Id");
			edited = true;
		}
		if(notes.length() > 0)
		{
			rd.updateRequest(id, notes, "Manager_Notes");
			edited = true;
		}
		if(edited)
			rd.updateRequest(id, session.getAttribute("id").toString(), "Manager_Id");
		response.sendRedirect("home");
	}

}
