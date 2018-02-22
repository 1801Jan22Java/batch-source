package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.RequestDaoImpl;

public class EmployeeCompletedInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EmployeeCompletedInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDaoImpl info = new RequestDaoImpl();
		System.out.println(request.getSession().getAttribute("Employee_Id").toString());
		String Reinbursment_Object = info.getResolvedReinbursments(Integer.parseInt(request.getSession().getAttribute("Employee_Id").toString())).toString();
		response.setContentType("text/html");
		response.getWriter().write(Reinbursment_Object);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
