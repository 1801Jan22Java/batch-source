package project1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import project1.beans.RmbRequest;
import project1.dao.RmbRequestDaoImpl;

public class PendingRequestServlet extends HttpServlet {

	private static final long serialVersionUID = 6173856998408315563L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		HttpSession session = req.getSession(false);
		Integer id = (Integer)session.getAttribute("employeeId");
		RmbRequestDaoImpl rdi = new RmbRequestDaoImpl();
		List<RmbRequest> pending = rdi.viewPendingByEmpId(id);
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(pending);
		PrintWriter pw = resp.getWriter();
		pw.print(json);
		pw.flush();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
	}
}
