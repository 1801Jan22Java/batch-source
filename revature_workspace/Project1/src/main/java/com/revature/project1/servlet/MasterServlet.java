package com.revature.project1.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.revature.project1.beans.Employee;
import com.revature.project1.dao.EmployeeDao;
import com.revature.project1.dao.EmployeeDaoImpl;
import com.revature.project1.dao.ReimbursementRequestDao;
import com.revature.project1.dao.ReimbursementRequestDaoImpl;

//import com.revature.util.RequestHelper;

/**
 * Servlet implementation class MasterServlet
 */
public class MasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MasterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void processRequest(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		RequestDispatcher rd = req.getRequestDispatcher("views/main.html");
		res.setContentType("text/html;charset=UTF-8");
		String empStr = req.getParameter("employeeid");
		String amountStr = req.getParameter("charges");
		String description = req.getParameter("description");
		String applicationPath = req.getServletContext().getRealPath("");
		String uploadFilePath = applicationPath + File.separator + "uploads";
		System.out.println(empStr);
		System.out.println(description);
		Part filePart = req.getPart("fileinput");
		String filename = req.getParameter("fileinput");
		System.out.println(filename);
		System.out.println(filePart);
		InputStream is = null;
		OutputStream os = null;
		InputStream filecontent = null;
		try {
			os = new FileOutputStream(new File(uploadFilePath + File.separator + filename));
			is = filePart.getInputStream();
			int read = 0;
			final byte[] bytes = new byte[1024];
			while ((read = filecontent.read(bytes)) != -1) {
				os.write(bytes, 0, read);
			}
			System.out.println("New file " + filename + " created at " + uploadFilePath);

		} catch (FileNotFoundException fne) {
			System.out.println("You either did not specify a file to upload or are "
					+ "trying to upload a file to a protected or nonexistent " + "location.");

		} finally {
			if (os != null) {
				os.close();
			}
			if (filecontent != null) {
				filecontent.close();
			}
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("views/main.html");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String applicationPath = request.getServletContext().getRealPath("");
		String uploadFilePath = applicationPath + File.separator + "uploads";
		RequestDispatcher rd = request.getRequestDispatcher("views/main.html");
		String empStr = request.getParameter("employeeid");
		String amountStr = request.getParameter("charges");
		String description = request.getParameter("description");
		HttpSession session = request.getSession();
	
		System.out.println(empStr);
		System.out.println(description);
		EmployeeDao ed = new EmployeeDaoImpl();
		Employee emp = null;
		int employeeInt = Integer.parseInt(empStr);
		float amount = Float.parseFloat(amountStr);
		if(emp!=null) {
			session.setAttribute("employeeid", empStr);
			session.setAttribute("amountStr", amountStr);
			session.setAttribute("description", description);
		}
		response.sendRedirect("MasterServlet");
		}

}
