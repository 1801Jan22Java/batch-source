//package com.revature.servlets;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.google.gson.Gson;
///*import com.revature.beans.Bear;
//import com.revature.dao.BearDao;
//import com.revature.dao.BearDaoImpl;*/
//import com.revature.beans.Cat;
//
///**
// * Servlet implementation class IndexServlet
// */
//public class IndexServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		HttpSession session = req.getSession(false);
//		if(session != null && session.getAttribute("email") != null) {
//			//req.getRequestDispatcher("index.html").forward(req, resp);
//			/*CatDao cd = new CatDaoImpl();*/
//			List<Cat> catList = new ArrayList<Cat>();
//			Cat cat = new Cat("Jimmy", "Persian", 1);
//			catList.add(cat);
//			resp.setContentType("application/json");
//			
//			Gson gson = new Gson();
//			String catString = gson.toJson(catList);
//			resp.getWriter().write("{\"Cat\":"+catString+"}");
//		} else {
//			resp.sendRedirect("login");
//		}
//	}
//
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
