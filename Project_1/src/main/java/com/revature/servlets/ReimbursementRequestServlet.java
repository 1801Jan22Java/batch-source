package com.revature.servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
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
import com.revature.beans.ReimbursementRequest;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDaoPLSQLImpl;
import com.revature.dao.ReimbursementRequestDAO;
import com.revature.dao.ReimbursementRequestPLSQLImpl;

/**
 * Servlet implementation class ReimbursementRequestServlet
 */
public class ReimbursementRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReimbursementRequestServlet() {
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
		ReimbursementRequestDAO rrd = new ReimbursementRequestPLSQLImpl();
		List<ReimbursementRequest> rrList;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		//Seesion check
		if (session != null && session.getAttribute("emplId") != null) {
			String param = request.getParameter("load");
			if (param != null) {
				emplId = (int) session.getAttribute("emplId");
				empl = d.getEmployeeById(emplId);
				//If the user is a manger
				if (empl.getTitle() == EmployeeTitle.MANAGER) {
					rrList = rrd.getReimbursementRequests();
				} else {
					rrList = rrd.getReimbursementRequestsByEmplId(emplId);
					for (int i = 0; i < rrList.size(); i++) {
						rrList.set(i, rrList.get(i).setEmplId(-1));
					}
				}

				map.writeValue(out, rrList);
				json = new String(out.toByteArray());
				response.getWriter().write(json);
			} else {
				RequestDispatcher view = request
						.getRequestDispatcher("views/PendingRequests.html");
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
		//creates a reimbursement request from the dat provided in the request
		HttpSession session = request.getSession();
		ObjectMapper mapper = new ObjectMapper();
		ReimbursementRequestDAO rrd = new ReimbursementRequestPLSQLImpl();
		JsonNode j = mapper.readTree(request.getInputStream());
		int emplId = (int) session.getAttribute("emplId");
		ReimbursementRequest rr = new ReimbursementRequest(
				j.get("amount").asDouble(), LocalDate.now(), emplId, null,
				j.get("description").asText());
		rrd.createReimbursementRequest(rr);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//deletes a reimbursement request
		ObjectMapper mapper = new ObjectMapper();
		ReimbursementRequestDAO rrd = new ReimbursementRequestPLSQLImpl();
		JsonNode j = mapper.readTree(req.getInputStream());
		ReimbursementRequest rr = new ReimbursementRequest();
		rr = rr.setId(j.get("id").asInt());
		rrd.deleteReimbursementRequest(rr);
	}
	
	

}
