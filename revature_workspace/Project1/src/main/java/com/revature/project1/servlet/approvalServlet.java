package com.revature.project1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.project1.beans.Employee;
import com.revature.project1.beans.ReimbursementRequest;
import com.revature.project1.dao.EmployeeDaoImpl;
import com.revature.project1.dao.ReimbursementRequestDaoImpl;


public class approvalServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3287432004319736179L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// forward the request to Calculator.html page from "Calculator"
		RequestDispatcher rd = req.getRequestDispatcher("approvalpage.html");
		//System.out.println(arg0);
		rd.forward(req, res);
		

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String n1 = req.getParameter("employeeid");
		int id = Integer.parseInt(n1);
		System.out.println(n1);
		EmployeeDaoImpl edi= new EmployeeDaoImpl();
		ReimbursementRequestDaoImpl rrdi = new ReimbursementRequestDaoImpl();
		Employee emp = edi.getEmployeeById(id);
		List<ReimbursementRequest> rl = rrdi.getReimbursementRequestsByEmployee(emp);
	//	String answer =(String) req.getAttribute("answer");
		PrintWriter prw = res.getWriter();
		for(int i =0;i<rl.size();i++) {
			prw.write("<p style= \"margin:30px\"> The answer is: "+ rl.get(i)+"</p>");
		}
		RequestDispatcher rd = req.getRequestDispatcher("approvalpage.html");
		//prw.write("<p style= \"margin:30px\"> The answer is: "+ answer+"</p>");
	//	prw.write("<p style = \"margin:30px\"><a href=\"Calculator.html\">Do more calculashunz</a></p>");
		//Include answer in request
	//	req.setAttribute("approval", answer);
		
		//Forward request to answer servlet
		//RequestDispatcher rd =req.getRequestDispatcher("approval");
		//rd.forward(req, res);

}
}
