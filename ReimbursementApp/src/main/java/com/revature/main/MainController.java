package com.revature.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.ImgDao;
import com.revature.dao.ImgDaoImpl;
/*import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;*/
import com.revature.dao.MemberDao;
import com.revature.dao.MemberDaoImpl;
import com.revature.util.LoggingClass;

@WebServlet("*.do")
public class MainController extends HttpServlet {

	public static LoggingClass lc = new LoggingClass();

	private static final long serialVersionUID = 7207469793728272196L;

	public MainController() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// super.doGet(req, resp);
		actionDo(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		actionDo(req, resp);
	}

	private void actionDo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {

		ServiceCommon cc = new ServiceCommon();
		ServiceRequest sr = new ServiceRequest();
		
		String viewPage = null;
		
		String uri = req.getRequestURI();
		String conPath = req.getContextPath();
		String com = uri.substring(conPath.length());

		System.out.println("com: "+ com);
		if (com.equals("/login.do")) {
			HttpSession session = req.getSession();
			session.invalidate();
			viewPage = "views/common/login.jsp";
			
		} else if (com.equals("/loginOk.do")) {
			
			viewPage = cc.loginValidation(req, resp);
			
		} else if (com.equals("/join.do")) {
			viewPage = "views/common/join.jsp";
			
		} else  if(com.equals("/rqListViewForEmp.do")) {
			
			sr.viewRequestListForEmp(req, resp);
			viewPage = "views/emp/rqListViewForEmp.jsp";
		
		} else if (com.equals("/joinOk.do")) {
			
			viewPage = cc.joinValidation(req, resp);
			
		} else if (com.equals("/rqSubmitForEmp.do")) {
			
			viewPage = "views/emp/rqSubmitForEmp.jsp";
		
		}  else if (com.equals("/requestUpdate.do")) {
			
			viewPage = sr.requestUpdate(req, resp);
			 
		} else if (com.equals("/rqViewForEmp.do")) {
			
			sr.getaRequestInfo(req, resp);
			 viewPage = "views/emp/rqViewForEmp.jsp";
			 
		} else if (com.equals("/rqViewForMng.do")) {
			
			sr.getaRequestInfo(req, resp);
			 viewPage = "views/mng/rqViewForMng.jsp";
			 
		}  else if (com.equals("/rqListViewForMng.do")) {
			
			sr.viewRequestListForMng(req, resp);
			 viewPage = "views/mng/rqListViewForMng.jsp";
		
		} else if (com.equals("/rqResolveForMng.do")) {

			sr.resolveRequest(req, resp);
			sr.viewRequestListForMng(req, resp);
			viewPage = "views/mng/rqListViewForMng.jsp";
			
		} else if (com.equals("/empListViewForMng.do")) {
			
			sr.getRequestsOfAllEmployees(req, resp);
			viewPage = "views/mng/empListViewForMng.jsp";
		
		} else if (com.equals("/empRqListViewForMng.do")) {
			
			sr.viewEmpRequestListForMng(req, resp);
			viewPage = "views/mng/empRqListViewForMng.jsp";
		
		} else if (com.equals("/empViewForEmp.do")) {
			
			cc.getMemberInfo(req, resp);
			viewPage = "views/common/empViewForEmp.jsp";
		
		} else if (com.equals("/empViewModifyForEmp.do")) {
			cc.getMemberInfo(req, resp);
			viewPage = "views/common/empViewModifyForEmp.jsp";

		} else if (com.equals("/updateMemberInfo.do")) {
			// check if email is same 
			viewPage = cc.updateMemberInfo(req, resp);		// return view page upon result of existing same email
			cc.getMemberInfo(req, resp);
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
		dispatcher.forward(req, resp);
		
	}
}
