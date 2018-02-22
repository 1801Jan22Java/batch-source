package com.revature.servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Employee;
import com.revature.beans.EmployeeTitle;
import com.revature.beans.ProcessedRequest;
import com.revature.beans.RequestStatus;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDaoPLSQLImpl;
import com.revature.dao.ProcessedRequestDAO;
import com.revature.dao.ProcessedRequestDAOPLSQLImpl;
import com.revature.dao.ReimbursementRequestDAO;
import com.revature.dao.ReimbursementRequestPLSQLImpl;

/**
 * Servlet implementation class ProcessedRequestServlet
 */
public class ProcessedRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProcessedRequestServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		int emplId;
		Employee empl;
		EmployeeDAO d = new EmployeeDaoPLSQLImpl();
		ObjectMapper map = new ObjectMapper();
		String json;
		ProcessedRequestDAO prd = new ProcessedRequestDAOPLSQLImpl();
		List<ProcessedRequest> prs = new ArrayList<>();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		if (session != null && session.getAttribute("emplId") != null) {
			String param = request.getParameter("load");
			if (param != null) {
				emplId = (int) session.getAttribute("emplId");
				empl = d.getEmployeeById(emplId);
				if (empl.getTitle() == EmployeeTitle.MANAGER) {
					prs = prd.getProcessedRequests();
				}else {
					prs = prd.getProcessedRequests(emplId);
				}
				
				map.writeValue(out, prs);
				json = new String(out.toByteArray());
				response.getWriter().write(json);
				
			} else {
				RequestDispatcher view = request
						.getRequestDispatcher("views/ProcessedRequests.html");
				view.forward(request, response);
			}
		} else {
			response.sendRedirect("login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ObjectMapper mapper = new ObjectMapper();
		ProcessedRequestDAO prd = new ProcessedRequestDAOPLSQLImpl();
		JsonNode j = mapper.readTree(request.getInputStream());
		int emplId = (int) session.getAttribute("emplId");
		RequestStatus s;
		if (j.get("status").asText().equals(RequestStatus.APPROVED)) {
			s = RequestStatus.APPROVED;
		} else {
			s = RequestStatus.DENIED;
		}
		ProcessedRequest pr = new ProcessedRequest(j.get("id").asInt(), s,
				emplId, LocalDate.now());
		prd.createProcessedRequest(pr);

	}

}
