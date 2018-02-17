package com.revature.project1.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.revature.project1.beans.Employee;
import com.revature.project1.dao.EmployeeDao;
import com.revature.project1.dao.EmployeeDaoImpl;
import com.revature.project1.dao.ReimbursementRequestDao;
import com.revature.project1.dao.ReimbursementRequestDaoImpl;

//import com.revature.util.RequestHelper;

/**
 * Servlet implementation class MasterServlet
 */
public class MasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MasterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("views/main.html");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("views/main.html");
	
		File file = null;
		EmployeeDao ed = new EmployeeDaoImpl();
		Employee emp = null;
		float amount=0;
		String description = "";
		/*try {
		ReimbursementRequestDao rrd = new ReimbursementRequestDaoImpl();
		if(	ServletFileUpload.isMultipartContent(request)) {
			ServletFileUpload upload = new ServletFileUpload();
			FileItemIterator items = upload.getItemIterator(request);
			while(items.hasNext()) {
				FileItemStream item = items.next();
			
			if(item.isFormField()) {
				String empStr = request.getParameter("employeeid");
				String amountStr=request.getParameter("charges");
				 description = request.getParameter("description");
				int employeeInt = Integer.parseInt(empStr);
				 amount = Float.parseFloat(amountStr);
				System.out.println(file);
				System.out.println(file.getPath());	
				emp =ed.getEmployeeById(employeeInt);
				
			}
			else {
					//item.write(file);
				}
			}
			rrd.addReimbursementRequest(emp, file, amount,description);
		}}
		 catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	
		*/
	

	}
}
	//response.sendRedirect("views/main.html");
		//String destination = RequestHelper.process(request);
		//response.sendRedirect(destination);
	

