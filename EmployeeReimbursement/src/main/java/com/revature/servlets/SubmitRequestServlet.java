package com.revature.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.revature.dao.RequestDaoImpl;
import com.revature.dao.StoredFileDaoImpl;

/**
 * Servlet implementation class SubmitRequestServlet
 */
@MultipartConfig
public class SubmitRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}


	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		
		RequestDaoImpl rdi = new RequestDaoImpl();
		StoredFileDaoImpl sfdi = new StoredFileDaoImpl();
		java.util.Date currDate = new java.util.Date();	//Get current time in milliseconds
		Date dateSubmitted = new Date(currDate.getTime());
		
		int id = Integer.valueOf(session.getAttribute("id").toString());
		String description = req.getParameter("description");
		Double amount = Double.valueOf(req.getParameter("amount"));
		
		
		int made = rdi.createRequest(id, dateSubmitted, description, amount);

		//Grab the file from the HTML
		Part screenshot = req.getPart("screenshot");
		String fileName = Paths.get(getSubmittedFileName(screenshot)).getFileName().toString();
		InputStream screenshotContents = screenshot.getInputStream();
		
		sfdi.createStoredFile(fileName, made, screenshotContents);
		
		if(made != -1) {
			req.getRequestDispatcher("submitpage").forward(req, resp);
		} else {
			req.getRequestDispatcher("submitrequest").forward(req, resp);
		}
	}
	
	
	//Helper method for grabbing the file name from the submitted screenshot
	private static String getSubmittedFileName(Part part) {
	    for (String cd : part.getHeader("content-disposition").split(";")) {
	        if (cd.trim().startsWith("filename")) {
	            String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
	            return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); // MSIE fix.
	        }
	    }
	    return null;
	}

}
