package com.revature.project1.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.project1.beans.Employee;
import com.revature.project1.dao.EmployeeDao;
import com.revature.project1.dao.EmployeeDaoImpl;
import com.revature.project1.dao.ReimbursementRequestDao;
import com.revature.project1.dao.ReimbursementRequestDaoImpl;

//import com.revature.util.RequestHelper;

/**
 * Servlet implementation class MasterServlet
 */
public class MasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MasterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("views/main.html");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("views/main.html");
		String firstName = request.getParameter("username");
		String empStr = request.getParameter("employeeid");
		String amountStr=request.getParameter("charges");
		int employeeInt = Integer.parseInt(empStr);
		float amount = Float.parseFloat(amountStr);
		File file = new File(request.getParameter("fileInput"));
		//OutputStream out = null;
		//FileInputStream filecontent=null;
		
		System.out.println(file);
		System.out.println(file.getPath());
		
		EmployeeDao ed = new EmployeeDaoImpl();
		Employee emp =ed.getEmployeeById(employeeInt);
		ReimbursementRequestDao rrd = new ReimbursementRequestDaoImpl();
		rrd.addReimbursementRequest(emp, file, amount);
	//response.sendRedirect("views/main.html");
		//String destination = RequestHelper.process(request);
		//response.sendRedirect(destination);
	}

}
