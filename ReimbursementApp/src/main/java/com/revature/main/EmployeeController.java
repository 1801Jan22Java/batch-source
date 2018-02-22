package com.revature.main;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.MemberDao;
import com.revature.dao.MemberDaoImpl;
import com.revature.vo.RequestVo;

public class EmployeeController {

	MemberDao memberDao = new MemberDaoImpl();
	String viewPage;
	
	public String viewRequestListForEmp(HttpServletRequest req, HttpServletResponse resp) {
		
		HttpSession session = req.getSession();
		int empNo = (Integer)session.getAttribute("m_no");
		//int empNo = Integer.parseInt(req.getParameter("m_no"));			//empNo
		int ifRExist = memberDao.ifRequestExistByEmployeeNo(empNo);
		req.setAttribute("ifRExist", ifRExist);
		
		List<RequestVo> vos = new ArrayList<RequestVo>();
		int pageNo = 1;		//temp -need to be changed.
		if (ifRExist > 0 ) {
			vos = memberDao.getRequestsByEmployeeNo(empNo, pageNo);
		} else {
			vos.add(new RequestVo());
		}
		req.setAttribute("rVos", vos);
		viewPage = "views/emp/rqListViewForEmp.jsp";
		
		return viewPage;
	}
}
