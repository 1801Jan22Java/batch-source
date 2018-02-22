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
 * Servlet implementation class EmployeesServlet
 */
public class EmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //Grabs an employee by ID
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		PrintWriter pw = response.getWriter();
		EmployeeDao ed = new EmployeeDaoImpl();
		HttpSession session = request.getSession(false);
		
		//String empzID = request.getParameter("empID");
		int empzID =  (Integer) session.getAttribute("userID");
		System.out.println(empzID);
		//if (empzID!= null) {
			//int empsID = Integer.parseInt(empzID);	
			Employee employee= ed.getEmpByID(empzID);
			
			response.setContentType("application/json");
			ObjectMapper om = new ObjectMapper();
			String empString = om.writeValueAsString(employee);
			pw.write(empString);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
