package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.revature.beans.Employee;
import com.revature.dao.EmployeeDaoImpl;

public class viewInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		int empID = (int)session.getAttribute("employeeID");
		int isManager = (int)session.getAttribute("isManager");
		ArrayList<Employee> list = new ArrayList<Employee>(); 
		try {
			list = edi.viewInfo(empID, isManager);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		resp.setContentType("application/json");
		PrintWriter pw = resp.getWriter();
		Gson gson = new Gson();
		gson.toJson(list, pw);
	}
}
