package com.revature.project1.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.*;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.revature.project1.beans.Employee;
import com.revature.project1.dao.EmployeeDaoImpl;
import com.revature.project1.dao.ReimbursementRequestDaoImpl;

/**
 * Servlet implementation class UploadServlet
 */
public class UploadServlet extends HttpServlet {

	public UploadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("views/main_employee.html").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		System.out.println("In upload servlet");
		HttpSession session = request.getSession();
		String username = session.getAttribute("username").toString();
		String password = session.getAttribute("password").toString();
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		Employee loggedInEmp = edi.getEmployeeByCredentials(username, password);
		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyMMdd-HH-mm");
		String dateStr = ldt.format(df);
		ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
		String empStr = "";
		String amountStr = "";
		String desc = "";
		String extent = "";
		File file = null;
		try {

			List<FileItem> multiFiles = sf.parseRequest(request);
			for (FileItem item : multiFiles) {
				if (item.isFormField()) {
					String fieldname = item.getFieldName();
					String fieldvalue = item.getString();
					switch (fieldname) {
					case "employeeid":
						empStr = fieldvalue;
						break;
					case "charges":
						amountStr = fieldvalue;
						break;
					case "description":
						desc = fieldvalue;
						break;
					}
				} else if (item.getFieldName().equals("fileInput")) {
					System.out.println(item.getName().indexOf("."));
					int period = item.getName().indexOf(".");
					extent = item.getName().substring(period + 1);
					item.write(new File("C:\\Users\\user\\Desktop\\Cornu Sinistra\\gitrepos\\batch-source\\revature_workspace\\Project1\\src\\main\\webapp\\images\\" + dateStr + empStr + "." + extent));
					file = new File("C:\\Users\\user\\Desktop\\Cornu Sinistra\\gitrepos\\batch-source\\revature_workspace\\Project1\\src\\main\\webapp\\images\\" + dateStr + empStr + "." + extent);
					System.out.println(file.getAbsolutePath());
					String filename = file.getName();
					System.out.println("File uploaded");
					
					System.out.println(empStr + " " + amountStr + " " + desc);
				}
				
			
			}
		
			int empInt = Integer.parseInt(empStr);
			float amount = Float.parseFloat(amountStr);
			Employee emp = edi.getEmployeeById(empInt);
			if(!loggedInEmp.getUserName().equals(emp.getUserName())) {
				
				RequestDispatcher rd = request.getRequestDispatcher("views/main.html");
				rd.include(request, response);
				response.setContentType("text/html");
				pw.println("<div><p style=\"background-color:yellow; width:450px;margin-left:auto;margin-right:auto;\">You may only add reimbursement requests for yourself");
				
				pw.println("<br>Request not added</p></div>");
				//response.sendRedirect("MasterServlet");
			
			}
			else {
			ReimbursementRequestDaoImpl rrdi = new ReimbursementRequestDaoImpl();
			rrdi.addReimbursementRequest(emp, file, amount, desc, file.getAbsolutePath());
			System.out.println("Request added");
			}

		}
		catch(NumberFormatException e) {
			pw.println(
					"<html><body style=\"background-color:black; color:white; width:450px;margin-left:auto;margin-right:auto;\">");
			pw.println("No information entered!");
			pw.println("<a style=\"color:white\" href=\"EmployeeServlet\">Back to upload page.</a>");
			pw.write("</div></body></html>");
			
		}
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	//	response.sendRedirect("UploadServlet");
	}

}
