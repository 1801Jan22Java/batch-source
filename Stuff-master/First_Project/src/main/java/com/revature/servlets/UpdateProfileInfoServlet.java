package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.EmployeeDaoImpl;

public class UpdateProfileInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateProfileInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("EmployeeHome.html");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDaoImpl emp = new EmployeeDaoImpl();
		int emp_id =Integer.parseInt(request.getSession().getAttribute("Employee_Id").toString());
		//System.out.println("kdsjfal  "+emp.getEmployee_ID());
		//int emp_id = emp.getEmployee_ID();
		//System.out.println("got here");
		String[] choice = new String[3];
		choice[0] = request.getParameterValues("UpdatePasswordForm")[0];
		choice[1] = request.getParameterValues("UpdateUsernameForm")[0];
		choice[2] = request.getParameterValues("UpdateEmailForm")[0];
		//System.out.println(choice[1]);

		for(int i = 0;i<3;i++) {
			if(choice[i].length()>0) {
				System.out.println("sdfasfas "+i+choice[i]);
				switch(i) {
					case 1:emp.updatePassword(choice[i],emp_id);
							break;
					case 2: emp.updateUsername(choice[i],emp_id);
							break;
					case 3: emp.updateEmail(choice[i],emp_id);
							break;
					default:break;		
					
				}
			}
		}
		
		response.sendRedirect("UpdateProfile.html");
	}

}
