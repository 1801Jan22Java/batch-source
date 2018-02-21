package com.revature.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Employee;
import com.revature.beans.Request;
import com.revature.beans.RequestType;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.EventDao;
import com.revature.dao.EventDaoImpl;
import com.revature.dao.RequestDao;
import com.revature.dao.RequestDaoImpl;
import com.revature.dao.UploadDao;
import com.revature.dao.UploadDaoImpl;

@MultipartConfig
public class NewRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		EmployeeDao emd = new EmployeeDaoImpl();
		RequestDao rd = new RequestDaoImpl();
		EventDao evd = new EventDaoImpl();
		UploadDao ud = new UploadDaoImpl();
		ArrayList<RequestType> requestTypes = rd.getRequestTypes();
		
		Employee thisEmployee = new Employee();
		String action = "";
		
		if (session != null) {
			int employeeId = (int) session.getAttribute("employeeId");
			thisEmployee = emd.getEmployee(employeeId);
			if (thisEmployee != null) {
				if (request.getParameter("request-type") != null)
				{
					int requestTypeId = Integer.parseInt(request.getParameter("request-type"));
					if (request.getParameter("amount") != null) {
						double amount = Double.parseDouble(request.getParameter("amount"));
						if (request.getParameter("description") != null  && !request.getParameter("description").equals("")) {
							String description = request.getParameter("description");
							if (rd.addRequest(requestTypeId, amount, description, thisEmployee)) {
								Request thisRequest = thisEmployee.getRequests().get(thisEmployee.getRequests().size()-1);
								System.out.println(thisRequest.toString());
								// ...
							    List<Part> fileParts = request.getParts().stream().filter(part -> "uploads".equals(part.getName())).collect(Collectors.toList()); // Retrieves <input type="file" name="file" multiple="true">
							    System.out.println("fileparts = " + fileParts.toString());
							    action = "success";
							    for (Part filePart : fileParts) {
							        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
							        System.out.println("filename = " + fileName);
							        if (!fileName.equals("") && fileName != null) {
								        if (ud.addUpload(fileName, thisRequest, thisEmployee)) {
								        	System.out.println(thisRequest.getUploads().get(thisRequest.getUploads().size()-1).toString());
								        	String newFileName = thisRequest.getUploads().get(thisRequest.getUploads().size()-1).getFilename();
								        	String filePath = "C:\\xampp\\htdocs\\uploads\\" + newFileName;
								        	OutputStream saveContent = new FileOutputStream(filePath);
								        	
								        	InputStream fileContent = filePart.getInputStream();
								        	
								        	IOUtils.copy(fileContent, saveContent);
								        	fileContent.close();
								        	saveContent.close();
								        	
								        	
									        // ... (do your job here)
								        } else {
								        	action = "fail";
								        }
							        }
							    }
								
							} else {
								action = "fail";
							}
						} else {
							// no description was provided
							action = "fail";
						}
					} else {
						// no amount was provided
						action = "fail";
					}
				} else {
					// no type was provided
					action = "fail";
				}
			} else {
				// This employeeId could not be found
				action = "logout";
			}
		} else {
			// This session could not be found
			action = "login";
		}
		String query = "";
		String url = "../requests";
		if (action == "logout" || action == "login") {
			url = "../logout?action=login";
		} else {
			if (action != "" ) {
				url = "../requests";
				query = "?action=" + action;
			}
		}
		response.sendRedirect(url + query);
	}
}
