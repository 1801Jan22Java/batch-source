package com.revature.servlets;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.StoredFile;
import com.revature.dao.StoredFileDaoImpl;

/**
 * Servlet implementation class DownloadImageServlet
 */
public class DownloadImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       




	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		StoredFileDaoImpl sfdi = new StoredFileDaoImpl();
		
		//Pass in request ID as a parameter with the request
		String uri = req.getRequestURI();
		String shortened = uri.substring(uri.indexOf("downloadimage")+14);
		int requestID = Integer.valueOf(shortened);
		StoredFile file = sfdi.readStoredFile(requestID);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
//		
//		int bytesRead = -1;
//		byte[] buffer = new byte[1028];
//		
//		//LOOK AT THIS
//		while((bytesRead = file.getFileInStream().read(buffer)) != -1) {
//			baos.write(buffer, 0, bytesRead);
//		}
		
		ServletOutputStream sos = resp.getOutputStream();
		
//		byte [] byteArray = baos.toByteArray();
		resp.setContentLength(file.getImageBytes().length);
		sos.write(file.getImageBytes());
		
		sos.close();
	}

	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

	}

}
