package com.revature.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Employee;
import com.revature.beans.Manager;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.ManagerDaoImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/Login.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();			// create a new session
		
		response.setContentType("text/html");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		EmployeeDaoImpl edi = new EmployeeDaoImpl();		
		List<Employee> employeeList = edi.getEmployees();	// get employee list
		String employeeid = null;
		boolean isEmployee = false;
		for (Employee e : employeeList) {
			if (username != null && e.getEmail().equals(username) && e.getPassword().equals(password)) {
				isEmployee = true;
			}
			if (isEmployee) {
				employeeid = Integer.toString(e.getEmployeeId());
				break;
			}
		}
		
		ManagerDaoImpl mdi = new ManagerDaoImpl();
		List<Manager> managerList = mdi.getManagers();		// get manager list
		String managerid = null;
		boolean isManager = false;
		for (Manager m : managerList) {
			if (username != null && m.getEmail().equals(username) && m.getPassword().equals(password)) {
				isManager = true;
			}
			if (isManager) {
				managerid = Integer.toString(m.getManagerId());
				break;
			}
		}

		if(isEmployee){
			session.setAttribute("username", username);
			session.setAttribute("problem", null);	// setting password attribute to null to exclude from redirect?
			session.setAttribute("employeeid", employeeid);
			response.sendRedirect("employeehome");
		} else if(isManager) {
			session.setAttribute("username", username);
			session.setAttribute("problem", null);	// setting password attribute to null to exclude from redirect?
			session.setAttribute("managerid", managerid);
			//doesn't exist YET. 
			response.sendRedirect("managerhome");
		} else {
			session.setAttribute("problem", "incorrect password");
			response.sendRedirect("login");
		}
	}
}
