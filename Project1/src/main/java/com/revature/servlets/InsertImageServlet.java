package com.revature.servlets;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.revature.beans.Reimbursement;
import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoSQL;
import com.revature.util.ConnectionUtil;

public class InsertImageServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		ReimbursementDao rd = new ReimbursementDaoSQL();
		Reimbursement gotReimbursement = rd.getReimbursementByID(1003);
		byte [] byteArr = gotReimbursement.getImage();
		if (gotReimbursement != null) {
			OutputStream out = resp.getOutputStream();
			out.write(byteArr);
			out.close();
            
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		ServletInputStream in = req.getInputStream();
		ByteArrayOutputStream bao = new ByteArrayOutputStream();
		
		ReimbursementDao rd = new ReimbursementDaoSQL();
		if (in.available() > 0) {
			int c = 0;
			int count = 0;
			while((c=in.read()) != -1) {
				bao.write(c);
				count += 1;
			}
			byte [] byteArr = bao.toByteArray();
			rd.submitReimbursement(1000, 123.5, byteArr);
		}
		
	}
}
