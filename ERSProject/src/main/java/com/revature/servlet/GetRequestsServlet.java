package com.revature.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.CryptoType;
import com.revature.beans.Employee;
import com.revature.beans.Request;
import com.revature.dao.CryptoDao;
import com.revature.dao.CryptoDaoImpl;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.RequestDao;
import com.revature.dao.RequestDaoImpl;
import com.revature.dao.WalletDao;
import com.revature.dao.WalletDaoImpl;

public class GetRequestsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetRequestsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Request servlet get");
		HttpSession session = request.getSession();
		
		if(session != null) {
			String email = (String) session.getAttribute("username");
			
			if(email != null) {
				
				EmployeeDao dao = new EmployeeDaoImpl();
				Employee emp = dao.getEmployee(email);
				
				if(emp != null) {
					
					RequestDao requestDao = new RequestDaoImpl();
					List<Request> requests = requestDao.getRequests(emp.getId());
					
					response.setContentType("application/json");
					response.getWriter().write("[");
					
					CryptoDao cryptoDao = new CryptoDaoImpl();
					WalletDao walletDao = new WalletDaoImpl();
					
					for(int i = 0; i < requests.size(); i++) {	
						
						CryptoType crypto = cryptoDao.getCryptoType(walletDao.getWalletByID(requests.get(i).getWalletID()).getWalletType());
						String symbol = crypto.getSymbol();
						
						String managerName = "";
						
						if(requests.get(i).getManagerID() > 0)
							managerName = dao.getEmployee(requests.get(i).getManagerID()).getEmail();
						
						//TODO::Send all required data!
						response.getWriter().write("{\"id\":\""+ requests.get(i).getReqId() +"\""
								+ ", \"email\":\"" + email + "\""
								+ ", \"title\":\"" +  requests.get(i).getTitle() + "\""
								+ ", \"amount\":\"" +  requests.get(i).getAmount() + "\""
								+ ", \"symbol\":\"" +  symbol + "\""
								+ ", \"date\":\"" +  requests.get(i).getDate() + "\""
								+ ", \"manager\":\"" +  managerName + "\""
								+ ", \"status\":\"" +  requests.get(i).getStatus() + "\"}");
						
						if(i + 1 < requests.size()) response.getWriter().write(",") ;
					}
					
					response.getWriter().write("]");
				}
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
