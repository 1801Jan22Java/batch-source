package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Request;
import main.ServerManager;

/**
 * Servlet implementation class ManagerLogin
 */
public class ManagerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerLogin() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("views/login.html").forward(request, response);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    ServerManager serverManager = new ServerManager(); 
		HttpSession session = request.getSession();
		response.setContentType("application/json");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		session.setAttribute("username", username);
		session.setAttribute("password", password);
		serverManager.managerLogin((String)username, (String)password);
		if(serverManager.managerLogin(username,password)==1){
			serverManager.changePic(serverManager.currentEmployee.getEmployeeId());
			session.setAttribute("managerId", serverManager.currentManager.getManagerId());
			session.setAttribute("employeeId", serverManager.currentManager.getEmployeeId());
			session.setAttribute("email", serverManager.currentManager.getEmail());
			session.setAttribute("firstName", serverManager.currentManager.getFirstName());
			session.setAttribute("lastName", serverManager.currentManager.getLastName());
			response.sendRedirect("ManagerProfile");
		} else {
			session.setAttribute("problem", "incorrect password");
			response.sendRedirect("loginPage");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

}
