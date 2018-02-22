package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Employee;
import beans.Request;
import main.ServerManager;

/**
 * Servlet implementation class ViewAllEmployees
 */
public class ViewAllEmployees extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllEmployees() {
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
		serverManager.login((String)session.getAttribute("username"), (String)session.getAttribute("password"));
		response.setContentType("text/html");
		System.out.println(serverManager.currentEmployee +""+ serverManager.currentManager);
		//System.out.println((String)session.getAttribute("username")+(String)session.getAttribute("password"));
		ArrayList<Request> reqs = null;
			System.out.println("emp1");
			String html = "<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"<head>\r\n" + "<center>"+
					"<meta charset=\"ISO-8859-1\">\r\n" + 
					"<link rel=\"stylesheet\" href=\"styles/DunderTableStyle.css\">"+
					"<title>View Requests</title>\r\n" + 
					"</head>\r\n" + 
					"<body>"+"<h1> Employees' of Dunder Mifflin</h1>\r\n" + 
							"<table id=\"Requests\" class=\"table table-dark\">\r\n" + 
							"<thead>\r\n" + 
							"<tr>\r\n" + 
							"<th scope=\"col\">Emploee ID</th>\r\n" + 
							"<th scope=\"col\">First Name</th>\r\n" +
							"<th scope=\"col\">Last Name</th>\r\n" + 
							"<th scope=\"col\">Email</th>\r\n" + 
							"<th scope=\"col\">User Name</th>\r\n" + 
							"<th scope=\"col\">Manager Id</th>\r\n" +
							"</tr>\r\n" + 
							" 			</thead>";
			int c =0;
			for(Employee e: serverManager.empDao.getEmployees())
			{
					html+= "<tr><td>"+e.getEmployeeId()+"</td><td>"+e.getFirstName()+"</td> <td>"+e.getLastName()+"</td> <td>"+e.getEmail()+"</td><td>"+e.getUserName()+"</td><td>"+e.getManagerId()+"</td></tr>";

			}
			html+="</table>\r\n" + "</center>"+
					"</body>\r\n" + 
					"<script src = \"scripts/ViewRequests.js\"></script>\r\n" + 
					"</html>";
			response.getWriter().write(html);
		
		//response.sendRedirect("views/ViewRequests.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
