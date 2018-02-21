package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.util.RequestHelper;

public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// check for session, redirect to request page or login page
		HttpSession session = request.getSession(false);
		if(session != null){
			int employeeId = (int) session.getAttribute("employeeId");
			EmployeeDao emd = new EmployeeDaoImpl();
			Employee thisEmployee = emd.getEmployee(employeeId);
			if (thisEmployee != null) {
				String query = "";
				if (request.getParameter("action") != null) {
					query = "?action=" + request.getParameter("action");
				}
				response.sendRedirect("requests" + query);
			}
		} else {
			String message = "";
			String inputAction = request.getParameter("action");
			if (inputAction != null) {
				switch (inputAction) {
				case "logout":
					message = "You Have Logged Out";
					break;
				case "login":
					message = "Please Login";
					break;
				case "bad-email":
					message = "Email Not Found";
					break;
				case "bad-password":
					message = "Incorrect Password";
					break;
				case "missing-info":
					message = "Information is Missing";
					break;
				case "missing-email":
					message = "Email is Missing";
					break;
				case "missing-password":
					message = "Password is Missing";
					break;
				}
			}
			if (message != "") {
				response.setContentType("text/html");
				String javaScript = "<script>window.onload = function () { document.getElementById(\"message\").innerHTML = \"" + message + "\"; }</script>";
				PrintWriter pw = response.getWriter();
				request.getRequestDispatcher("index.html").include(request, response);;
				pw.println(javaScript);
			} else {
				response.sendRedirect("http://localhost:8888/Project1ERS/");
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDao emd = new EmployeeDaoImpl();
		String action = "";
		if (request.getParameter("inputEmail") != null) {
			String inputEmail = request.getParameter("inputEmail");
			if (request.getParameter("inputPassword") != null) {
				String inputPassword = request.getParameter("inputPassword");
				
				if (inputEmail.length()  < 1 && inputPassword.length() < 1) {
					action = "missing-info";
				} else {
					if (inputEmail.length() > 0) {
						if (!emd.isAvailable(inputEmail)) {
							if (inputPassword.length() > 0) {
								inputPassword = getHash(inputPassword);
								Employee thisEmployee = emd.login(inputEmail, inputPassword);
								if (thisEmployee != null) {
									HttpSession session = request.getSession(true);
									session.setAttribute("employeeId", thisEmployee.getEmployeeId());
									action = "requests";
								} else {
									action = "bad-password";
								}
							} else {
								action = "missing-password";
							}
						} else {
							action = "bad-email";
						}
					} else {
						action = "missing-email";
					}
				}
			} else {
				action = "missing-password";
			}
		} else {
			action = "missing-email";
		}
		if (action != "requests" ) {
			action = "login?action=" + action;
		}
		response.sendRedirect(action);
	}
	
	private static String getHash(String originalString) {
		String newString = "";
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] encodedhash = digest.digest(originalString.getBytes(StandardCharsets.UTF_8));
			newString = bytesToHex(encodedhash);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return newString;
	}
	
	private static String bytesToHex(byte[] hash) {
	    StringBuffer hexString = new StringBuffer();
	    for (int i = 0; i < hash.length; i++) {
	    String hex = Integer.toHexString(0xff & hash[i]);
	    if(hex.length() == 1) hexString.append('0');
	        hexString.append(hex);
	    }
	    return hexString.toString();
	}
}
