package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Employee;
import com.revature.beans.Wallet;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.WalletDao;
import com.revature.dao.WalletDaoImpl;

public class CreateWalletServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateWalletServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Wallet post");
		HttpSession session = request.getSession();
		
		if(session != null) {
			String email = (String) session.getAttribute("username");
			System.out.println("email: " + session.getAttribute("username"));
			if(email != null) {
				
				EmployeeDao dao = new EmployeeDaoImpl();
				Employee emp = dao.getEmployee(email);
				
				//Ensure we have a valid employee
				if(emp != null) {
					System.out.println("Creating wallet in the database...");
					String name = request.getParameter("name");
					String address = request.getParameter("walletAddress");
				
					//Add a wallet for this employee
					WalletDao walletDao = new WalletDaoImpl();
					walletDao.addWallet(new Wallet(0, emp.getId(), name, address, 0));
					
				}
			}
		}
		response.sendRedirect("account.html");
	}
}
