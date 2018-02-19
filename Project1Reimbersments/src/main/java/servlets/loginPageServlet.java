package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Request;
import main.ServerManager;

/**
 * Servlet implementation class loginPageServlet
 */
public class loginPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ServerManager serverManager = new ServerManager(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("views/login.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setContentType("application/json");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(serverManager.login(username,password)==1){
			serverManager.changePic(serverManager.currentEmployee.getEmployeeId());
			session.setAttribute("employeeId", serverManager.currentEmployee.getEmployeeId());
			session.setAttribute("email", serverManager.currentEmployee.getEmail());
			session.setAttribute("firstName", serverManager.currentEmployee.getFirstName());
			session.setAttribute("lastName", serverManager.currentEmployee.getLastName());
			
			ArrayList<Request> reqs = serverManager.reqDao.getRequests(serverManager.currentEmployee.getEmployeeId());
			if(!reqs.isEmpty())
			{
				session.setAttribute("requestId", reqs.get(0).getRequestId());
				session.setAttribute("requestStatus", reqs.get(0).getStatus());
				session.setAttribute("requestAmount", reqs.get(0).getAmountRequested());
				session.setAttribute("requestDocument", serverManager.docDao.downloadDocuments(reqs.get(0).getRequestId()));
			}
			response.sendRedirect("EmployeeProfile");
		} else {
			session.setAttribute("problem", "incorrect password");
			response.sendRedirect("login");
		}
	}

}
