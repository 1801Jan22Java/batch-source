package com.project.servlet;

import java.io.ByteArrayOutputStream;
import java.io.Console;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;
import com.revature.util.ReimburseUtil;

/**
 * Servlet implementation class GetImageServlet
 */
public class GetImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetImageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		ReimburseUtil ru = new ReimburseUtil();

		if (session != null) {

		} else {
			response.sendRedirect("login");
		}

		/*
		 * Turn the BAOS into a byte array Send byte array into response via
		 * ServletOutputStream.
		 */
		ByteArrayOutputStream image_blob = ru.viewImage(Integer.parseInt(request.getParameter("request_id")));

		byte[] buf = image_blob.toByteArray();
		response.setContentLength(buf.length);
		ServletOutputStream sos = response.getOutputStream();
		sos.write(buf);
		sos.close();

		// if(image_blob==null) {
		// } else {
		//// response.get
		// }

	}

}
