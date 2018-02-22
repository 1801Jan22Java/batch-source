package com.revature.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.ImgDao;
import com.revature.dao.ImgDaoImpl;
import com.revature.dao.MemberDao;
import com.revature.dao.MemberDaoImpl;
import com.revature.dao.RequestDao;
import com.revature.dao.RequestDaoImpl;
import com.revature.vo.MemberVo;
import com.revature.vo.RequestVo;

public class ServiceCommon {

	MemberDao mDao = new MemberDaoImpl();
	RequestDao rDao = new RequestDaoImpl();
	ImgDao imgDao = new ImgDaoImpl();
	String viewPage;

	public String loginValidation(HttpServletRequest req, HttpServletResponse resp) {

		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		HttpSession session = req.getSession();

		int ifExist = mDao.ifMemberExist(id);
		if (ifExist > 0) {
			int ifRightPwd = mDao.ifRightPwd(id, pwd);
			if (ifRightPwd == 1) {

				// store info into session
				session.setAttribute("m_id", id);
				session.setAttribute("m_pwd", pwd);
				// log in success
				MemberVo vo = mDao.getMemberById(id);
				session.setAttribute("m_no", vo.getNo());

				String lv = vo.getLv();
				if (lv.equals("0")) {
					// init page No as 1 
					int pageNo = 1;				//init pageNo as 1 when log-in
					List<RequestVo> rVos = rDao.getRequests(pageNo);
					//session.setAttribute("rVos", rVos);
					req.setAttribute("rVos", rVos);
					req.setAttribute("ifRExist", rVos.size());
					viewPage = "views/mng/rqListViewForMng.jsp?no=" + vo.getNo() + "&id=" + vo.getId();
				} else {
					// int empNo = Integer.parseInt(req.getParameter("no")); //empNo
					int ifRExist = mDao.ifRequestExistByEmployeeNo(vo.getNo());
					req.setAttribute("ifRExist", ifRExist);

					List<RequestVo> vos = new ArrayList<RequestVo>();
					if (ifRExist > 0) {
						int pageNo = 1;		//temp -need to be changed.
						vos = mDao.getRequestsByEmployeeNo(vo.getNo(), pageNo);
					} else {
						vos.add(new RequestVo());
					}
					req.setAttribute("rVos", vos);
					viewPage = "views/emp/rqListViewForEmp.jsp?no=" + vo.getNo() + "&id=" + vo.getId();
				}
			} else {
				// wrong password
				viewPage = "views/common/msg.jsp?error_code=3";
			}
		} else {
			// id doesn't exist
			viewPage = "views/common/msg.jsp?error_code=4";
		}
		return viewPage;
	}


	public String joinValidation(HttpServletRequest req, HttpServletResponse resp) {
		MemberVo mVo = new MemberVo();
		mVo.setId(req.getParameter("id"));
		mVo.setEmail(req.getParameter("email"));
		mVo.setPwd(req.getParameter("pwd"));
		mVo.setLv(req.getParameter("lv"));

		int cnt = mDao.ifMemberExist(mVo.getId());
		// int cnt = 0;
		if (cnt > 0) {
			// id already exist.
			viewPage = "views/common/msg.jsp?error_code=1";
		} else {
			// success to join in.
			mDao.insertMember(mVo);
			viewPage = "views/common/msg.jsp?error_code=2";
		}
		return viewPage;
	}
	
	public void getMemberInfo(HttpServletRequest req, HttpServletResponse resp) {
		
		HttpSession session = req.getSession();
		int m_no = (Integer)session.getAttribute("m_no"); // no of login member
		MemberVo mVo = mDao.getMemberByNo(m_no);
		req.setAttribute("mVo", mVo);
		
	}
	
	public String updateMemberInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String viewPage = "";
		
		HttpSession session = req.getSession();
		int m_no = (Integer)session.getAttribute("m_no"); // no of login member
		
		String email = req.getParameter("email");
		int ifEmailExsit = mDao.ifEmailExist(email, m_no);
		
		if (ifEmailExsit > 0) {
			viewPage = "views/common/msg.jsp?error_code=5";
		} else {
			String password = req.getParameter("password");
			MemberVo mVo = new MemberVo();
			mVo.setEmail(email);
			mVo.setPwd(password);
			mVo.setNo(m_no);
			mDao.updateMember(mVo);
			viewPage = "views/common/empViewForEmp.jsp"; 
		}
		
		return viewPage;
	}

}
