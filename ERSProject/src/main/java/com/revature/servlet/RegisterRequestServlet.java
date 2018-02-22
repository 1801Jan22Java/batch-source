package com.revature.servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.revature.beans.Employee;
import com.revature.beans.Request;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.RequestDao;
import com.revature.dao.RequestDaoImpl;
import com.revature.dao.WalletDao;
import com.revature.dao.WalletDaoImpl;

@MultipartConfig
public class RegisterRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterRequestServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Register Request Post");
		HttpSession session = request.getSession();
		
		if(session != null) {
			String email = (String) session.getAttribute("username");
			
			if(email != null) {
				
				EmployeeDao dao = new EmployeeDaoImpl();
				Employee emp = dao.getEmployee(email);
				
				if(emp != null) {
					RequestDao reqDao = new RequestDaoImpl();
			
					String title = request.getParameter("title");
					String desc = request.getParameter("desc");
					String addr = request.getParameter("selection");
					
					// Create path components to save the file
				    final String path = "uploads/";
				    final Part filePart = request.getPart("img");
				    final String fileName = getFileName(filePart);
				    //System.out.println(System.getProperty("user.dir"));
				    OutputStream out = null;
				    InputStream filecontent = null;
				    final PrintWriter writer = response.getWriter();
				    
				    File file = null;
				    
				    try {
				    	file = new File(path);
				    	System.out.println(System.getProperty("user.dir"));
				    	file.mkdir();
				    	file = new File(path + fileName);
				    	System.out.println(file.getAbsolutePath());
				    	System.out.println(file.getPath());
				        out = new FileOutputStream(file);
				        filecontent = filePart.getInputStream();
				        
				        int read = 0;
				        final byte[] bytes = new byte[1024];

				        while ((read = filecontent.read(bytes)) != -1) {
				            out.write(bytes, 0, read);
				        }
				        
				        System.out.println("New file " + fileName + " created at " + path +  new Object[]{fileName, path});
				        
				    } catch (FileNotFoundException fne) {
				       // writer.println("You either did not specify a file to upload or are "
				        //        + "trying to upload a file to a protected or nonexistent "
				      //          + "location.");
				      //  writer.println("<br/> ERROR: " + fne.getMessage());

				        System.out.println("Problems during file upload. Error: " + fne.getMessage());
				        
				    } finally {
				        if (out != null) {
				          //  out.close();
				        }
				        if (filecontent != null) {
				          //  filecontent.close();
				        }
				        if (writer != null) {
				         //   writer.close();
				        }
				    }

					try {
						String inputAmount = request.getParameter("amount");
						
						if(inputAmount != null) {
							float amount = Float.parseFloat(request.getParameter("amount"));
							if(amount > 0) {
								WalletDao walDao = new WalletDaoImpl();
								int walletID = walDao.getWalletID(emp.getId(), addr);
								
								if(walletID >= 0) {
									//TODO::Proper values for all this
									//
									reqDao.createRequest(new Request(0, emp.getId(), title, amount, desc, null, file, walletID, 0, -1));
									//
								}else {
									System.out.println("Failed to find wallet!");
								}
							}
						}
						else {
							System.out.println("Amount is null!");
						}
					}
					catch(NumberFormatException e) {
						
					}
					
				}
			}
		}
			
		response.sendRedirect("EmployeeDashboard.html");
	}

	private String getFileName(final Part part) {
	    final String partHeader = part.getHeader("content-disposition");
	    //LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
	    System.out.println("Part Header = " + partHeader);
	    for (String content : part.getHeader("content-disposition").split(";")) {
	        if (content.trim().startsWith("filename")) {
	            return content.substring(
	                    content.indexOf('=') + 1).trim().replace("\"", "");
	        }
	    }
	    return null;
	}
	
}
