package com.revature.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.*;
import com.revature.dao.*;

/**
 * Servlet implementation class SubmitRequestServlet
 */
public class SubmitRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("employeeHome");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		// if (true) throw new IllegalArgumentException();
		
		String username = (String) session.getAttribute("username");
		EmployeeDao edi = new EmployeeDaoImpl();
		Employee emp = edi.getEmployeeByUsername(username);
		
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		List<FileItem> fields = null;
		try {
			fields = upload.parseRequest(req);
		} catch (FileUploadException e1) {
			e1.printStackTrace();
		}
		
		double amt = 0.0;
		byte[] picBytes = null;
		
		for (FileItem f : fields) {
			if (f.getFieldName().equals("amt")) {
				amt = Double.parseDouble(f.getString());
			} else if (f.getFieldName().equals("pic")) {
				picBytes = f.get();
			}
		}
		
		ReimbDao rdi = new ReimbDaoImpl();
		Date sqlDate = new Date(System.currentTimeMillis());
		Reimb r = new Reimb(emp.getEmpId(), amt, 0, picBytes, sqlDate);
		rdi.createReimb(r);
		resp.sendRedirect("SuccessfulSubmission.html");
	}

}
