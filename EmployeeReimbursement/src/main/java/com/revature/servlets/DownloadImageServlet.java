package com.revature.servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.StoredFile;
import com.revature.dao.StoredFileDaoImpl;

/**
 * Servlet implementation class DownloadImageServlet
 */
@WebServlet("/DownloadImageServlet")
public class DownloadImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       




	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		StoredFileDaoImpl sfdi = new StoredFileDaoImpl();
		
		//Pass in request ID as a parameter with the request
		int requestID = Integer.valueOf(req.getAttribute("requestID").toString());
		StoredFile file = sfdi.readStoredFile(requestID);
//		
//		ServletContext context = getServletContext();
//		
//		String mimeType = context.getMimeType("E:\\Work\\Revature\\Training\\Project 1\\test.jpg");
//		if(mimeType == null)
//			mimeType = "application/octet-stream";
//		
//		resp.setContentType(mimeType);
//		resp.setContentLength((int) downloadFile.length());
		
//		resp.setHeader("Content-Disposition",String.format("attachment; filename=\"%s\"", file.getFileName()));
		OutputStream os = new FileOutputStream("E:\\Work\\Revature\\Training\\Project 1\\test.jpg");
		
		int bytesRead = -1;
		byte[] buffer = new byte[4096];
		while((bytesRead = file.getFileInStream().read(buffer)) != -1) {
			os.write(buffer, 0, bytesRead);
		}
		
		file.getFileInStream().close();
		os.close();
		
		
		
	}

}
