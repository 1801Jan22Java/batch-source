package com.revature.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.revature.dao.ImgDao;
import com.revature.dao.ImgDaoImpl;
import com.revature.dao.MemberDao;
import com.revature.dao.MemberDaoImpl;
import com.revature.dao.RequestDao;
import com.revature.dao.RequestDaoImpl;
import com.revature.vo.ImgVo;
import com.revature.vo.MemberVo;
import com.revature.vo.RequestVo;

public class ServiceRequest {

	MemberDao mDao = new MemberDaoImpl();
	RequestDao rDao = new RequestDaoImpl();
	ImgDao imgDao = new ImgDaoImpl();

	String viewPage;

	public   void viewRequestListForMng(HttpServletRequest req, HttpServletResponse resp) {
		
		int pageNo = 1;				// temporary (need to change)
		List<RequestVo> rVos = rDao.getRequests(pageNo);
		req.setAttribute("rVos", rVos);
		req.setAttribute("ifRExist", rVos.size());
	}
	
	public void  viewRequestListForEmp(HttpServletRequest req, HttpServletResponse resp) {

		HttpSession session = req.getSession();
		int empNo = (Integer) session.getAttribute("m_no");		// m_no : pk of member who logged-in 
		int ifRExist = mDao.ifRequestExistByEmployeeNo(empNo);
		req.setAttribute("ifRExist", ifRExist);

		List<RequestVo> vos = new ArrayList<RequestVo>();
		if (ifRExist > 0) {
			int pageNo = 1;		// temp : need to be changed.
			vos = mDao.getRequestsByEmployeeNo(empNo, pageNo);
		} else {
			vos.add(new RequestVo());
		}
		req.setAttribute("rVos", vos);
	}
	
	public void  viewEmpRequestListForMng(HttpServletRequest req, HttpServletResponse resp) {

		int empNo = Integer.parseInt( req.getParameter("employee_no"));		// m_no : pk of member who logged-in 
		int ifRExist = mDao.ifRequestExistByEmployeeNo(empNo);
		req.setAttribute("ifRExist", ifRExist);

		List<RequestVo> vos = new ArrayList<RequestVo>();
		if (ifRExist > 0) {
			int pageNo = 1;		// temp : need to be changed.
			vos = mDao.getRequestsByEmployeeNo(empNo, pageNo);
		} else {
			vos.add(new RequestVo());
		}
		req.setAttribute("employee_no", empNo);
		req.setAttribute("rVos", vos);
		req.setAttribute("employee_id", req.getParameter("employee_id"));
	}

	public String requestUpdate(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		HttpSession session = req.getSession();
		// (1) pictures of Receipts update
		String directory = "C:\\GitRepos\\1801-Jan22-java\\batch-source\\ReimbursementApp\\src\\main\\webapp\\img";
		int maxSize = 1024 * 1024 * 2;
		String encoding = "UTF-8";

		MultipartRequest multiRequest = new MultipartRequest(req, directory, maxSize, encoding,
				new DefaultFileRenamePolicy());

		// (2) Request update
		int m_no = (Integer) session.getAttribute("m_no");
		String purpose = multiRequest.getParameter("purpose");
		int amount = Integer.parseInt(multiRequest.getParameter("amount"));
		int request_no = mDao.insertRequest(new RequestVo(amount, purpose, m_no));

		Enumeration<String> enu = multiRequest.getFileNames();
		while(enu.hasMoreElements()) {
			
			String savedfileName = multiRequest.getFilesystemName(enu.nextElement());
			if (savedfileName != null && savedfileName != "") {
				//System.out.println("filename:"+ savedfileName);
				rDao.insertImg(savedfileName, request_no); // save the file with request no.
			}
		}
		viewPage = "/rqListViewForEmp.do";
		return viewPage;
	}

	public void resolveRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
		
		int status = Integer.parseInt(req.getParameter("status"));
		int request_no = Integer.parseInt(req.getParameter("request_no"));
		int manager_no = (Integer)req.getSession().getAttribute("m_no");
		rDao.resolveRequest(status, request_no, manager_no);
		System.out.println("resolve success!");
	}
	
	public void getaRequestInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		// requestNo >> get requestVo + ImgVos
		int request_no = Integer.parseInt(req.getParameter("request_no"));

		RequestVo rVo = rDao.getRequestByRNo(request_no);
		List<ImgVo> iVos = rDao.getImgByRNo(request_no);
		req.setAttribute("rVos", rVo); // request info
	    MemberVo empVo = mDao.getMemberByNo(rVo.getEmployee_no());
		req.setAttribute("empVo", empVo);
		
		if (rVo.getStatus() > 1) {
			MemberVo mngVo = mDao.getMemberByNo(rVo.getManager_no());
			req.setAttribute("mngVo", mngVo);
		}
	    req.setAttribute("imgCnt", iVos.size());
		req.setAttribute("iVos", iVos); // imgs' info
		
	}
	
	public void getRequestsOfAllEmployees(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
		int pageNo = 1;
		List<HashMap<String, Object>> mVos = mDao.getRequestsOfAllEmployees(pageNo);
		req.setAttribute("mVos", mVos);
		req.setAttribute("ifRExist", mVos.size());
		
	}

	
	
}