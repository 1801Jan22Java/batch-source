package com.project.servlet;

import java.io.ByteArrayOutputStream;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import com.revature.beans.User;
import com.revature.util.ReimburseUtil;
import com.revature.util.UserUtil;

/**
 * Servlet implementation class SubmitRequestServlet
 */
public class SubmitRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SubmitRequestServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("login");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserUtil uu = new UserUtil();
		ReimburseUtil ru = new ReimburseUtil();
		int id = 0;
		if (session != null) {
			User user = uu.getUser((String) session.getAttribute("username"));
			id = user.getUser_id();

			List<FileItem> items = null;
			
			// Create a factory for disk-based file items
			DiskFileItemFactory factory = new DiskFileItemFactory();

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);


			// Parse the request
			try {
			 items = upload.parseRequest(new ServletRequestContext(request));
			} catch (FileUploadException e) {
				e.printStackTrace();
			}


			InputStream is=null;
			int request_id = 0;
			Double amount = 0.0;
			// Process the uploaded items
			Iterator<FileItem> iter = items.iterator();
			while (iter.hasNext()) {
			    FileItem item = iter.next();
			    
			    if (item.isFormField()) {
			    	if(item.getString().equals("")) {
			    		amount = 0.0;
			    	}else {
				    	amount = Double.parseDouble(item.getString());
			    	}
			    } else {
			    	is = item.getInputStream();
			    }
			}
			
			ru.submitRequest(id, amount);
			ru.uploadImage(request_id, is);
			is.close();
			if (user.getPosition_id() == 1) {
				response.sendRedirect("reimbursement");
			} else if (user.getPosition_id() == 2) {
				response.sendRedirect("mreimbursement");
			}
		} else {
			response.sendRedirect("login");
		}
	}

}
