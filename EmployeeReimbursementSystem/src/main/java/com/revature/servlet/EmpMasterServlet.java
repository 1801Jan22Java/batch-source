package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Employee;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;

/**
 * Servlet implementation class EmpMasterServlet
 */
public class EmpMasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpMasterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//Used for grabbing the information of an individual employee and going to a new web page with that data
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		PrintWriter pw = response.getWriter();
		String employeeID = request.getParameter("empIdent");
		System.out.println("started");
		if (employeeID != null)
		{
			//System.out.println("somewhere");
			int eID = Integer.parseInt(employeeID);
			EmployeeDao ed = new EmployeeDaoImpl();
			Employee employee = ed.getEmpByID(eID);
			if (employee != null) {
				session.setAttribute("employID",eID);
				response.setContentType("application/json");
				ObjectMapper om = new ObjectMapper();
				String eString = om.writeValueAsString(employee);
				pw.write(eString);
				response.sendRedirect("erwmanmanipulate.html");
			}
			else {
				session.setAttribute("problem", "employee does not exist");
				response.sendRedirect("erwmanemps.html");
			} 
		}
		else {
			session.setAttribute("problem", "employee does not exist");
			response.sendRedirect("erwmanemps.html");
		}
	}

}
