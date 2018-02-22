package project1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import project1.beans.RmbRequest;
import project1.dao.RmbRequestDaoImpl;

public class AllRequestsOneEmployeeServlet extends HttpServlet {

	private static final long serialVersionUID = 6973856998408315563L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Integer empId = Integer.parseInt(req.getParameter("empId"));
		RmbRequestDaoImpl rdi = new RmbRequestDaoImpl();
		List<RmbRequest> requests = rdi.viewRequestsByEmpId(empId);
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(requests);
		PrintWriter pw = resp.getWriter();
		pw.print(json);
		pw.flush();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
	}
}

