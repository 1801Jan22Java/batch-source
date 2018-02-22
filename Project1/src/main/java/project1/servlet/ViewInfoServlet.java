package project1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import project1.beans.Employee;
import project1.dao.EmployeeDaoImpl;


public class ViewInfoServlet extends HttpServlet {

	private static final long serialVersionUID = 6073856998408315563L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		HttpSession session = req.getSession(false);
		Integer id = (Integer)session.getAttribute("employeeId");
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		Employee emp = edi.viewInfromationById(id);
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(emp);
		PrintWriter pw = resp.getWriter();
		pw.print(json);
		pw.flush();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
	}
}

