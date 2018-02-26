package com.revature.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.revature.beans.Upload;
import com.revature.dao.RequestDao;
import com.revature.dao.RequestDaoImpl;

import org.apache.commons.io.FileUtils;

/**
 * Servlet implementation class ReimbursementServlet
 */
@MultipartConfig
public class ReimbursementServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;   
	private String filePath;

	public void init( )
	{
		// Get the file location where it would be stored.
		filePath = getServletContext().getInitParameter("file-upload"); 
	}
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReimbursementServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//Handles reimbursement forms sent by the user.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		String purpose = request.getParameter("purpose");
		double amount = Double.parseDouble(request.getParameter("amount"));
		String notes = request.getParameter("notes");
		//System.out.println("Filename = " + filename);
		// Check that we have a file upload request
		String fileName = null;
	    try {
	    	//get the file that was uploaded by the user and save it.
	    	Part filePart = request.getPart("uploads"); // Retrieves <input type="file" name="file">
	    	//get the name of the file.
		    fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
		    //convert the file to an input stream
		    InputStream fileContent = filePart.getInputStream();
		    //make a new file based on the path of where we are saving files 
		    //(stored in the web.xml file in src/main/webapp/data) + the user provided name
		    File targetFile = new File(filePath+fileName);
		    //if the file already exists
		    if(targetFile.exists())
		    	//create a file with the same name, but attach the number of existing files in the folder to the end of the file name
		    	targetFile = new File(filePath+fileName.substring(0, fileName.indexOf("."))+"("+new File(filePath).listFiles().length+")"+fileName.substring(fileName.indexOf(".")));
		    //copy the contents of the user's uploaded file into the we created above.
		    FileUtils.copyInputStreamToFile(fileContent, targetFile);
		    RequestDao rd = new RequestDaoImpl();
		    //save that file to the request it belongs to.
			rd.addRequest(Integer.parseInt(session.getAttribute("id").toString()), LocalDate.now(), amount, "Pending", purpose, notes, 0, "", new Upload(targetFile.getName(), 0));
	    }catch(Exception ex) {
			ex.printStackTrace();
		}
	    //redirect the user to the homepage.
	    response.sendRedirect("home");
	}
}
