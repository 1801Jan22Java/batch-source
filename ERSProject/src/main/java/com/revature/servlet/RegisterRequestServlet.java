package com.revature.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.RequestDao;
import com.revature.dao.RequestDaoImpl;
import com.revature.dao.WalletDao;
import com.revature.dao.WalletDaoImpl;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@MultipartConfig
public class RegisterRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterRequestServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	private final String UPLOAD_DIRECTORY = "/uploads";
	
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
					Part filePart = request.getPart("img");
					
					//
					
					//process only if its multipart content
			        if(ServletFileUpload.isMultipartContent(request)){
			            try {
			                List<FileItem> multiparts = new ServletFileUpload(
			                                         new DiskFileItemFactory()).parseRequest(request);
			              
			                for(FileItem item : multiparts){
			                    if(!item.isFormField()){
			                        String name = new File(item.getName()).getName();
			                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
			                    }
			                }
			           
			               //File uploaded successfully
			               request.setAttribute("message", "File Uploaded Successfully");
			            } catch (Exception ex) {
			               request.setAttribute("message", "File Upload Failed due to " + ex);
			            }          
			         
			        }else{
			            request.setAttribute("message",
			                                 "Sorry this Servlet only handles file upload request");
			        }
			    
			        request.getRequestDispatcher("/result.jsp").forward(request, response);
					
					//
				
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
									//reqDao.createRequest(new Request(0, emp.getId(), title, amount, desc, null, null, walletID, 0, -1));
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

}
