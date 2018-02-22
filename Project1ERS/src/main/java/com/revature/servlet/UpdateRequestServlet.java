package com.revature.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
public class UpdateRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	// Update a request
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		EmployeeDao emd = new EmployeeDaoImpl();
		RequestDao rd = new RequestDaoImpl();
		EventDao evd = new EventDaoImpl();
		UploadDao ud = new UploadDaoImpl();
		ArrayList<RequestType> requestTypes = rd.getRequestTypes();
		
		Employee thisEmployee = new Employee();
		String action = "";
		int requestId = 0;
		
		if (session != null) {
			int employeeId = (int) session.getAttribute("employeeId");
			thisEmployee = emd.getEmployee(employeeId);
			if (thisEmployee != null) {
				
				if (request.getParameter("request-id") != null) { 
					requestId = Integer.parseInt(request.getParameter("request-id"));
					Employee requestAuthor = rd.getRequestAuthor(requestId);
					Request thisRequest = requestAuthor.getRequests().get(0);
					
					int requestStatusId = 0;
					// If no change to request id, procedure will use current status of request
					if (request.getParameter("request-status") != null) {
						requestStatusId = Integer.parseInt(request.getParameter("request-status"));
					}
					ArrayList<String> displayNames = new ArrayList<>();
					
					
					// ...
				    List<Part> fileParts = request.getParts().stream().filter(part -> "uploads".equals(part.getName())).collect(Collectors.toList()); // Retrieves <input type="file" name="file" multiple="true">
				    action = "success";
				    for (Part filePart : fileParts) {
				        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
				        if (!fileName.equals("") && fileName != null) {
				        	if (fileName.length() > 100) {
				        		String splitDisplayName[]= fileName.split("\\.");
				        		String extension = "." + splitDisplayName[splitDisplayName.length - 1];
				        		// Database limits display names to 100 characters
				        		fileName = "Filename Too Long" + extension;
				        	}
					        displayNames.add(fileName);
					        if (ud.addUpload(fileName, thisRequest, thisEmployee)) {
					        	String newFileName = thisRequest.getUploads().get(thisRequest.getUploads().size()-1).getFilename();
					        	// Save uploaded file to File Server outside of tomcat war
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
				    
				    String message = "";
				    if (request.getParameter("message") != null) {
				    	message = request.getParameter("message");
				    }
				    if (message.equals("")) {
				    	message = "No Comment";
				    }
				    if (displayNames.size() > 0) {
					    for (String s : displayNames) {
					    	message = message + "\n - " + s + " was uploaded.";
					    }
				    }
				    
				    if (evd.addEvent(requestStatusId, message, thisRequest, thisEmployee)) {
				    	action = "success";
				    }
					
					
				} else {
					// The request id was not provided
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
		String url = "";
		if (action == "logout" || action == "login") {
			url = "../logout?action=login";
		} else if (requestId == 0) {
			url = "../requests?action=not-found";
		} else {
			url = "../request?id=" + requestId;
			if (action != "" ) {
				query = "&action=" + action;
			}
		}
		response.sendRedirect(url + query);
	}
}
