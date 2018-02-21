package com.revature.servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
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
import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDaoPLSQLImpl;

/**
 * Servlet implementation class EmployeeServlet
 */
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int emplId;
		
		if (session != null && session.getAttribute("emplId") != null) {
			String param = request.getParameter("load");
			if (param != null) {
				emplId = (int) session.getAttribute("emplId");
				EmployeeDAO d = new EmployeeDaoPLSQLImpl();
				Employee empl =  d.getEmployeeById(emplId);
				empl = empl.setPassword(null);
				ObjectMapper map = new ObjectMapper();
				String json;
				if (empl.getTitle() == EmployeeTitle.MANAGER) {
					List<Employee> empls = d.getEmployees();
					for (int i = 0; i < empls.size(); i++) {
						if (empls.get(i).getId() == emplId) {
							empls.set(i, empls.get(i).setId(-1));
							break;
						}
					}
					ByteArrayOutputStream out = new ByteArrayOutputStream();
					map.writeValue(out, empls);
					json = new String(out.toByteArray());
				}else {
					json = map.writeValueAsString(empl);
				}
				response.getWriter().write(json);
			}else {
				RequestDispatcher view = request.getRequestDispatcher("views/Employee.html");
				view.forward(request, response);
			}
		} else {
			response.sendRedirect("login");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode j = mapper.readTree(request.getInputStream());
		Employee empl = new Employee(j.get("firstName").asText(), j.get("lastName").asText(), 
				j.get("userName").asText(), j.get("password").asText(), EmployeeTitle.EMPLOYEE, 
				j.get("email").asText(), null);
		EmployeeDAO d = new EmployeeDaoPLSQLImpl();
		d.createEmployee(empl);
		response.getWriter().write("Added Employee");
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode j = mapper.readTree(req.getInputStream());
		int id = j.get("id").asInt();
		EmployeeDAO d = new EmployeeDaoPLSQLImpl();
		Employee e = d.getEmployeeById(id);
		d.deleteEmployee(e);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode j = mapper.readTree(req.getInputStream());
		String firstName = j.get("firstName").asText();
		String lastName = j.get("lastName").asText();
		String password = j.get("password").asText();
		HttpSession session = req.getSession();
		int emplId = (int) session.getAttribute("emplId");
		EmployeeDAO d = new EmployeeDaoPLSQLImpl();
		Employee e = d.getEmployeeById(emplId);
		e = e.setFirstName(firstName);
		e = e.setLastName(lastName);
		if (!password.equals("")) {
			e = e.setPassword(password);
		}
		d.updateEmployee(e);
	
	}

}
