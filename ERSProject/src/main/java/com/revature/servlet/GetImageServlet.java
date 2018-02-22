package com.revature.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Request;
import com.revature.dao.RequestDao;
import com.revature.dao.RequestDaoImpl;

public class GetImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("image get");
		HttpSession session = request.getSession();
		
		if(session != null) {
			int id = Integer.parseInt(request.getParameter("id"));
			
			RequestDao reqDao = new RequestDaoImpl();
			Request req = reqDao.GetRequest(id);
			
			if(req != null && req.getReciept() != null) {
				
				response.setContentType("image/jpeg");
				ServletOutputStream outStream;
				outStream = response.getOutputStream();
				
				FileInputStream fin = new FileInputStream(req.getReciept());
				
				BufferedInputStream bin = new BufferedInputStream(fin);
			    BufferedOutputStream bout = new BufferedOutputStream(outStream);
			    int ch = 0;
			    	while((ch=bin.read())!=-1)
			            bout.write(ch);

			    bin.close();
			    fin.close();
			    bout.close();
			    outStream.close();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
