package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.ServerManager;

/**
 * Servlet implementation class NewRequest
 */
public class NewRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("views/NewRequest.html").include(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServerManager serverManager = new ServerManager(); 
		HttpSession session = request.getSession();
		Float requestAmount = Float.parseFloat(request.getParameter("requestAmount"));
		String description = request.getParameter("description");
		if(serverManager.login((String)session.getAttribute("username"), (String)session.getAttribute("password"))==1)
		{
			serverManager.reqDao.addRequest(serverManager.currentEmployee.getEmployeeId(), requestAmount, description);
		}
		else if(serverManager.managerLogin((String)session.getAttribute("username"), (String)session.getAttribute("password"))==1)
		{
			serverManager.reqDao.addRequest(serverManager.currentManager.getEmployeeId(), requestAmount, description);
		}
		response.sendRedirect("EmployeeProfile");
	}

}
