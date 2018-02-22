package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.Request;
import com.revature.dao.RequestDao;
import com.revature.dao.RequestDaoImpl;

/**
 * Servlet implementation class DecideRequestServlet
 */
public class DecideRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DecideRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //Determines if a reimbursement is accepted or denied
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDao rd = new RequestDaoImpl();
		//HttpSession session = request.getSession(false);
		String deciderOfFates = request.getParameter("decVal");
		String rekt = request.getParameter("reqID");
		int rektarino = Integer.parseInt(rekt);
		Request rq = rd.getReqByID(rektarino);
		int theLastHour = Integer.parseInt(deciderOfFates);
		rd.modifyReqStatus(theLastHour, rq);
		System.out.println(theLastHour);
		System.out.println(rq);
		response.sendRedirect("erwmanhome.html");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
