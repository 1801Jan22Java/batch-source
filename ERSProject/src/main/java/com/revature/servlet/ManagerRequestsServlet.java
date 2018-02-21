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

public class ManagerRequestsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ManagerRequestsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Manager Request servlet get");
		HttpSession session = request.getSession();
		
		if(session != null) {
			String email = (String) session.getAttribute("username");
			boolean manager = (boolean) session.getAttribute("manager");
			
			if(email != null && manager) {
				
				EmployeeDao dao = new EmployeeDaoImpl();
				Employee emp = dao.getEmployee(email);
				List<Employee> employees = dao.getEmployees();

				if(emp != null) {
					
					RequestDao requestDao = new RequestDaoImpl();
					List<Request> requests = requestDao.getRequests();
					
					response.setContentType("application/json");
					response.getWriter().write("{\"requests\":[");
					
					CryptoDao cryptoDao = new CryptoDaoImpl();
					WalletDao walletDao = new WalletDaoImpl();
										
					for(int i = 0; i < requests.size(); i++) {	
						
						CryptoType crypto = cryptoDao.getCryptoType(walletDao.getWalletByID(requests.get(i).getWalletID()).getWalletType());
						String symbol = crypto.getSymbol();
						String empEmail = "";
						
						for(Employee e : employees) {
							if(e.getId() == requests.get(i).getEmpID()) {
								empEmail = e.getEmail();
								break;
							}
						}
						
						String managerName = "";
						if(requests.get(i).getManagerID() >= 0) {
							for(Employee e : employees) {
								if(e.getId() == requests.get(i).getManagerID()) {
									managerName = e.getEmail();
									break;
								}
							}
						}
						
						//TODO::Send all required data!
						response.getWriter().write("{\"id\":\""+ requests.get(i).getReqId() +"\""
								+ ", \"email\":\"" + empEmail + "\""
								+ ", \"title\":\"" +  requests.get(i).getTitle() + "\""
								+ ", \"amount\":\"" +  requests.get(i).getAmount() + "\""
								+ ", \"symbol\":\"" +  symbol + "\""
								+ ", \"date\":\"" +  requests.get(i).getDate() + "\""
								+ ", \"manager\":\"" +  managerName + "\""
								+ ", \"status\":\"" +  requests.get(i).getStatus() + "\"}");
						
						if(i + 1 < requests.size()) response.getWriter().write(",") ;
					}
					
					response.getWriter().write("],\"employees\":[");
					
					for(int i = 0 ; i < employees.size(); i++) {
						response.getWriter().write("{\"id\":\""+ employees.get(i).getId() +"\""
								+ ", \"email\":\"" + employees.get(i).getEmail() + "\"}");
						
						if(i + 1 < employees.size()) response.getWriter().write(",") ;
					}
					
					response.getWriter().write("]}");
				}
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
