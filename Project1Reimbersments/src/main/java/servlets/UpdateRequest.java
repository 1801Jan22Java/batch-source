package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.ServerManager;

/**
 * Servlet implementation class UpdateRequest
 */
public class UpdateRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("views/UpdateRequest.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String approve = request.getParameter("approve");
		System.out.println(approve);
		String deny = request.getParameter("deny");
		System.out.println(deny);
		String requestId = request.getParameter("requestId");
		System.out.println(requestId);
		ServerManager serverManager = new ServerManager();
		if(deny == null)
		{
			serverManager.updateStatus(Integer.parseInt(requestId), 103);
		}
		else
		{
			serverManager.updateStatus(Integer.parseInt(requestId), 104);
		}
		request.getRequestDispatcher("ViewUnresolvedRequests").include(request,response);
	}

}
