package com.revature.servlet;

import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.revature.beans.User;
import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOImpl;


@MultipartConfig
public class ProcessRequestServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if(session != null && session.getAttribute("currentUser") != null) {
			User currentUser = (User) session.getAttribute("currentUser");
			Part fileImage = req.getPart("uploadFile");
			String fileName = Paths.get(getSubmittedFileName(fileImage)).getFileName().toString();
			System.out.println(fileName);
			System.out.println(req.getParameter("amount"));
			ReimbursementDAO addReimbursement = new ReimbursementDAOImpl();
			addReimbursement.submitReimbursement(currentUser, fileImage.getInputStream(), Double.parseDouble(req.getParameter("amount")));
			resp.sendRedirect("/ExpenseReimbursements/submitRequest");
		}
		
	}
	
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
