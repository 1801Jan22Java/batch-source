package com.revature.servlet;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Request;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.RequestDao;
import com.revature.dao.RequestDaoImpl;
import com.revature.dao.WalletDao;
import com.revature.dao.WalletDaoImpl;

public class RequestModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RequestModServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Reqmod get");
		HttpSession session = request.getSession();
		
		if(session != null) {
			String email = (String) session.getAttribute("username");
			boolean manager = (boolean) session.getAttribute("manager");
			
			if(email != null && manager) {
				
				EmployeeDao empDao = new EmployeeDaoImpl();
				int empID = empDao.getEmployee(email).getId();
				
				try {
					int id = Integer.parseInt(request.getParameter("id"));
					int type = Integer.parseInt(request.getParameter("type"));
					
					RequestDao reqDao = new RequestDaoImpl();
					if(type == 1) {
						
						Request req = reqDao.GetRequest(id);
						
						if(req != null && req.getStatus() == 0) {
							
							reqDao.ApproveRequest(id, empID);
							
							try {
								WalletDao walletDao = new WalletDaoImpl();
								String walletAddress = walletDao.getWalletByID(req.getWalletID()).getWalletAddress();
								
								URL url = new URL("https://block.io/api/v2/withdraw/?api_key=ac86-0f48-3ba6-cd8d&amounts="+ req.getAmount()+"&to_addresses="
										+walletAddress+"&pin=123456789");
								//System.out.println(url);
								String USER_AGENT = "Mozilla/5.0";
								HttpURLConnection con = (HttpURLConnection) url.openConnection();
								con.setRequestMethod("GET");
								con.setRequestProperty("User-Agent", USER_AGENT);
								int responseCode = con.getResponseCode();
								System.out.println("withdraw response: " + responseCode);
							}
							catch(Exception e) {
								e.printStackTrace();
							}
						}else {System.out.println("Request already handled!");}
					}
					else {
						reqDao.DenyRequest(id, empID);
					}
				}
				catch(NumberFormatException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
