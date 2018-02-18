package com.revature.project1.servlet;

import java.io.File;
import java.io.IOException;
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


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 request.getRequestDispatcher("/views/main.html").forward(request,response);
    	
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In upload servlet");
	
		ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
		String empStr="";
		String amountStr="";
		String desc ="";
		String extent="";
		File file =null;
		try {
			
			List<FileItem> multiFiles = sf.parseRequest(request);
			for(FileItem item : multiFiles) {
				if(item.isFormField()) {
					String fieldname=item.getFieldName();
					String fieldvalue=item.getString();
					switch(fieldname) {
					case "employeeid":empStr=fieldvalue;break;
					case "charges": amountStr=fieldvalue;break;
					case "description": desc=fieldvalue;break;
					}
				}
				else if(item.getFieldName().equals("fileInput")) {
				item.write(new File("/temp/"+ item.getName()));
				 file = new File("/temp/"+item.getName());
				 System.out.println(file.getAbsolutePath());
				 String filename = file.getName();
				System.out.println("File uploaded");
				System.out.println(filename.indexOf("."));
				int period = filename.indexOf(".");
				extent =filename.substring(period+1);
				System.out.println(empStr + " "+ amountStr+ " " +desc);
				}
			
			}
			EmployeeDaoImpl edi = new EmployeeDaoImpl();
			int empInt = Integer.parseInt(empStr);
			float amount = Float.parseFloat(amountStr);
			Employee emp = edi.getEmployeeById(empInt);
			ReimbursementRequestDaoImpl rrdi = new ReimbursementRequestDaoImpl();
			rrdi.addReimbursementRequest(emp, file, amount, desc,file.getName());
			System.out.println("Request added");
			
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	response.sendRedirect("UploadServlet");	
	}

}
