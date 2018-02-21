package com.revature.servlet;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Reimbursement;
import com.revature.beans.User;
import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOImpl;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;

public class EmployeeDetailsServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		User currentUser = (User) session.getAttribute("currentUser");
		if(session.getAttribute("currentUser") != null && currentUser.getPosition_id() == 2) {
			UserDAO userDao = new UserDAOImpl();
			String uri = req.getPathInfo().substring(1);
			User employee = userDao.getUserById(Integer.parseInt(uri));
			ReimbursementDAO empReimbursement = new ReimbursementDAOImpl();
			List<Reimbursement> empRequests = empReimbursement.empViewPendingReimbursementById(employee);
			List<Reimbursement> empResolved = empReimbursement.empViewRevolvedReimbursement(employee);
			resp.setContentType("application/json");
			Map<String, Object> empMap = new LinkedHashMap();
			empMap.put("employee", employee);
			empMap.put("pending", empRequests);
			empMap.put("resolved", empResolved);
			ObjectMapper om = new ObjectMapper();
			String empObject = om.writeValueAsString(empMap);
			resp.getWriter().write(empObject);

		}
	}

}
