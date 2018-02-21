package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Staff;
import com.revature.dao.StaffDAO;
import com.revature.dao.StaffDAOImpl;

public class GetAllEmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetAllEmployeesServlet() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null) {
			StaffDAO getAllEmp = new StaffDAOImpl();
			List<Staff> listAllEmp = getAllEmp.getAllStaff();

			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			ObjectMapper objectMapper = new ObjectMapper();
			String jsonString = objectMapper.writeValueAsString(listAllEmp);
			PrintWriter pw = resp.getWriter();
			pw.print(jsonString);
			pw.flush();
		} else {
			resp.setContentType("application/json");
			resp.getWriter().write("{\"listAllEmp\":null}");
		}
	}

}
