package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Employee;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;

/**
 * Servlet implementation class EmpEditServlet
 */
public class EmpEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //Changing the employee database entry based on the field chosen
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		EmployeeDao ed = new EmployeeDaoImpl();
		//HttpSession session = request.getSession(false);
		String paramChange = request.getParameter("statChange");
		//Checking which field is being modified
		if (paramChange.equals("passwordchange"))
			paramChange = "EMPLOYEE_PASSWORD";
		else if (paramChange.equals("emailchange"))
			paramChange = "EMPLOYEE_EMAIL";
		else if (paramChange.equals("firstnamechange"))
			paramChange = "EMPLOYEE_FNAME";
		else if (paramChange.equals("lastnamechange"))
			paramChange = "EMPLOYEE_LNAME";
		else
			response.sendRedirect("erwemphome.html");
		
		String paramVal = request.getParameter("statVal");
		String empChange = request.getParameter("empUse");
		int empUseID = Integer.parseInt(empChange);
		Employee emp = ed.getEmpByID(empUseID);		
		ed.modifyEmployeeField(paramChange, paramVal, emp);
		emp = ed.getEmpByID(empUseID);
		response.setContentType("application/json");
		ObjectMapper om = new ObjectMapper();
		String empString = om.writeValueAsString(emp);
		pw.write(empString);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
