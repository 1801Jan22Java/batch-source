package com.revature.servlet;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOImpl;

public class GetImageServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String reimburseIdStr = req.getQueryString().split("=")[1];
		int reimburseId = Integer.parseInt(reimburseIdStr);
		ReimbursementDAO reimburse = new ReimbursementDAOImpl();
		ByteArrayOutputStream bao = reimburse.getRequestImage(reimburseId);
		resp.setContentLength(bao.size());
		ServletOutputStream out = resp.getOutputStream();
		byte[] baoImage = bao.toByteArray();
		out.write(baoImage);
		out.close();
	}
	
}
