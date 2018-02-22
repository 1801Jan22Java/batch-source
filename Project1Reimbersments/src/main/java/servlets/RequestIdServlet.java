package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Request;
import main.ServerManager;

/**
 * Servlet implementation class RequestIdServlet
 */
public class RequestIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServerManager serverManager = new ServerManager();
		HttpSession session = request.getSession();
		serverManager.login((String)session.getAttribute("username"), (String)session.getAttribute("password"));
		serverManager.managerLogin((String)session.getAttribute("username"), (String)session.getAttribute("password"));
		response.setContentType("text/html");
		int id = 0;
		System.out.println((String)session.getAttribute("username")+(String)session.getAttribute("password"));
		ArrayList<Request> reqs = null;
		reqs = serverManager.reqDao.getRequest();
		
			System.out.println("emp1");
			String html = "<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"<head>\r\n" + "<center>"+
					"<meta charset=\"ISO-8859-1\">\r\n" + 
					"<link rel=\"stylesheet\" href=\"styles/DunderTableStyle.css\">"+
					"<title>View Requests</title>\r\n" + 
					"</head>\r\n" + 
					"<body>"+"<h1> Pending Reimbursement Requests</h1>\r\n" + 
							"<table id=\"Requests\" class=\"table table-dark\">\r\n" + 
							"<thead>\r\n" + 
							"<tr>\r\n" + 
							"<th scope=\"col\">Request ID</th>\r\n" + 
							"<th scope=\"col\">Manager</th>\r\n" +
							"<th scope=\"col\">Description</th>\r\n" +
							"<th scope=\"col\">Request Status</th>\r\n" +  
							"<th scope=\"col\">Amount Requested</th>"+
							"</tr>\r\n" + "</thead>";
			int c =0;
			for(Request r: reqs )
			{
				if(r.getStatus()<102 && serverManager.currentEmployee.getEmployeeId()==r.getEmployeeId())
				{
					html+= "<tr><td>"+r.getRequestId()+"</td><td>"+serverManager.manDao.getManagerById(serverManager.empDao.getEmployee(r.getEmployeeId()).getManagerId())+"</td><td>"+r.getDescription()+"</td> <td>"+serverManager.statDao.getStatusName(r.getStatus())+"</td> <td>"+r.getAmountRequested()+"</td></tr>";
				}
			}
			html+="</table>\r\n" + "</center>"+
					"</body>\r\n" + 
					"<script src = \"scripts/ViewRequests.js\"></script>\r\n" + 
					"</html>";
			response.getWriter().write(html);
		request.getRequestDispatcher("views/RequestId.html").include(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestId = request.getParameter("requestId");
		response.sendRedirect("http://localhost:8084/Project1Reimbersments/RequestDocumentServlet?requestId="+requestId);
	}

}
