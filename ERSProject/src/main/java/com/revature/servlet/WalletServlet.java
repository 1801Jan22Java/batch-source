package com.revature.servlet;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Employee;
import com.revature.beans.Wallet;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.WalletDao;
import com.revature.dao.WalletDaoImpl;
import com.revature.json.BlockIO;

public class WalletServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WalletServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("walletServ get");
		HttpSession session = request.getSession();
		
		if(session != null) {
			String email = (String) session.getAttribute("username");
			
			if(email != null) {
				
				EmployeeDao dao = new EmployeeDaoImpl();
				Employee emp = dao.getEmployee(email);
				
				if(emp != null) {
					
					WalletDao walletDao = new WalletDaoImpl();
					List<Wallet> wallets = walletDao.getWallets(emp.getId());
					
					response.setContentType("application/json");
					response.getWriter().write("[");
					
					
					
					for(int i = 0; i < wallets.size(); i++) {
						double balance = 0.0;
						String network = "";
						try {
							URL url = new URL("https://block.io/api/v2/get_address_balance/?api_key=ac86-0f48-3ba6-cd8d&addresses="
									+wallets.get(i).getWalletAddress());
							
							ObjectMapper mapper = new ObjectMapper();
							BlockIO jsonBal = mapper.readValue(url, BlockIO.class);
							System.out.println(jsonBal.getStatus());
							balance = jsonBal.getData().getBalances().get(0).getAvailable_balance();
							network = jsonBal.getData().getNetwork();
						}
						catch(Exception e) {
							System.out.println("ERROR: WALLET SERVLET");
							//e.printStackTrace();
						}
						
						
						System.out.println(wallets.get(i).getWalletAddress());
						response.getWriter().write("{\"name\":\""+ wallets.get(i).getWalletName() +"\""
								+ ", \"address\":\"" +  wallets.get(i).getWalletAddress() + "\""
								+ ", \"type\":\"" +  network + "\""
								+ ", \"balance\":\"" +  balance + "\"}");
						//TODO::Get wallet name from database wallettype
						if(i + 1 < wallets.size()) response.getWriter().write(",") ;
					}
					
					response.getWriter().write("]");
				}
			}
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
