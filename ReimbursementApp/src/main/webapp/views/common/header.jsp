
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%
	HttpSession ifSessionExist = request.getSession(false);
	if (ifSessionExist == null || ifSessionExist.getAttribute("m_no") == null) {
		// if session doesn't have member's primary key value, move back to the log in page.
		response.sendRedirect("/ReimbursementApp/login.do");
	}
%>
<div class="row">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid ">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Welcome to the Employee's Page, <c:out value="${m_id}" /> !!
				</a>
			</div>
			<div class="btn-toolbar">

				<a role="button" class="btn btn-default navbar-btn pull-right" href="/ReimbursementApp/login.do">Log-Out</a>
				<a class="btn btn-default navbar-btn pull-right" role="button" href="/ReimbursementApp/empViewForEmp.do">My Account</a>
			</div>
		</div>
	</nav>

</div>





