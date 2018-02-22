package com.revature.servlet;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.revature.dao.RequestDao;
import com.revature.dao.RequestDaoImpl;

/**
 * Servlet implementation class SubmitServlet
 */
public class SubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("erwmakerequest.html").forward(request,  response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//Grabs a persons requests and stores in the database as well as store their file if added
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		//PrintWriter pw = response.getWriter();
		
	    // upload settings
		/*
	    final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
	    final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
	    final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
	    */
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		// Configure a repository (to ensure a secure temp location is used)
		ServletContext servletContext = this.getServletConfig().getServletContext();
		File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		factory.setRepository(repository);
		
	    // constructs the directory path to store upload file
        // this path is relative to application's directory
        String uploadPath = getServletContext().getRealPath("")
                + File.separator /*+ "upload"*/;
      

        //System.out.println(uploadPath);
        
        String newPath = getServletContext().getContextPath();
        
		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		 String fieldName;
		 String fieldValue;
		 String reimAmount ="0.0";
		 String reimReason ="";
		 String reimDesc ="";
		
		// Parse the request
		try {
			 List<FileItem> formItems = upload.parseRequest(request);
		
			
			 
	            if (formItems != null && formItems.size() > 0) {
	                // iterates over form's fields
	                for (FileItem item : formItems) {
	                	if (item.isFormField())
	                	{
	                		fieldName= item.getFieldName();
	                	    fieldValue = item.getString();
	                	    
	                	    if (fieldName.equals("amount")) 
	                	    	reimAmount = fieldValue;
	                	    else if (fieldName.equals("subReason"))
	                	    	reimReason = fieldValue;
	                	    else if (fieldName.equals("descript"))
	                	    	reimDesc = fieldValue;
	                
	                	    
	                	    	
	                	    
	                	}
	                    // processes only fields that are not form fields
	                    if (!item.isFormField()) {
	                        String fileName = new File(item.getName()).getName();
	                        String filePath = uploadPath + File.separator + fileName;
	                        File storeFile = new File(newPath+fileName);
	 
	                        // saves the file on disk
	                        try {
								item.write(storeFile);
								System.out.println(newPath);
								System.out.println(filePath);
							} catch (Exception e) {
								 request.setAttribute("message","There was an error: " + e.getMessage());
								 System.out.println("boo");
								 System.out.println(newPath);
					
							}
	                        request.setAttribute("message",
	                            "Upload has been done successfully!");
	                    }
	                }
	            }
		} catch (FileUploadException e) {
			   request.setAttribute("message","There was an error: " + e.getMessage());
		}
		
		RequestDao rd = new RequestDaoImpl();
		int useID = (Integer) session.getAttribute("userID");
		int typeID = 21;
		if (reimReason.equals("business"))
			typeID = 11;
		else if (reimReason.equals("travel"))
			typeID = 12;
		else if (reimReason.equals("housing"))
			typeID = 13;
		else if (reimReason.equals("education"))
			typeID = 14;
		else if (reimReason.equals("hiring"))
			typeID = 15;
		else if (reimReason.equals("inventory"))
			typeID = 16;
		else if (reimReason.equals("food"))
			typeID = 17;
		else if (reimReason.equals("personal"))
			typeID = 18;
		else if (reimReason.equals("insurance"))
			typeID = 19;
		else if (reimReason.equals("entertainment"))
			typeID = 20;
		double reAmount = Double.parseDouble(reimAmount);
		System.out.println(reAmount);
		System.out.println(reimDesc);
		System.out.println(typeID);
		rd.createRequest(1000, useID, typeID, 1, reimDesc, reAmount, 
				LocalDate.now(), LocalDate.now(), useID);
		
		response.sendRedirect("erwemphome.html");
		
		/*
		String password = request.getParameter("password");
		EmployeeDao ed = new EmployeeDaoImpl();
		Employee employee = ed.getEmpByAcc(username);
		if (username.equals(employee.getAccount())&&(password.equals(employee.getPassword()))) {
			int empID = employee.getEmployeeID();
			session.setAttribute("userID",empID);
			response.sendRedirect("erwemphome.html");
		}else {
			session.setAttribute("problem", "incorrect password");
			response.sendRedirect("erwemplogin.html");
		}*/
	
	}

}
