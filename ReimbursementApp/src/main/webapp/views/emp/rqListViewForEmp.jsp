<!DOCTYPE html>
<%@page import="com.revature.vo.MemberVo"%>
<%@page import="com.revature.dao.MemberDao"%>
<%@page import="com.revature.dao.MemberDaoImpl"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="UTF-8">
<title>Request List View For Emp</title>
<link rel="stylesheet" href="styles/employee.css" />
<link rel="stylesheet" href="styles/common.css" />
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>

<script src="scripts/emp/rqListViewForEmp.js"></script>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-10">

				<jsp:include page="../common/header.jsp"/>

				<div class="row">
					<div class="form-group">
						<!-- <label for="sel1">Sort By:</label> -->
						<a class="btn btn-danger pull-right" role="button" href="/ReimbursementApp/rqSubmitForEmp.do"> Submit Request </a>
					</div>
					<!-- <button class="btn btn-danger navbar-btn pull-right ">Submit Request</button> -->
				</div>
				<br />
				<div class="row  ">
					<table class="table table-hover table-bordered text-center">
						<thead>
							<tr>
								<th class="text-center">No.</th>
								<th class="text-center">Title</th>
								<th class="text-center">Status</th>
								<th class="text-center">Date</th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${ifRExist > 0 }">
									<c:forEach items="${rVos }" var="vo" varStatus="loop">
										<tr>
											<td>${loop.index}</td>
											<td style="cursor: pointer;"  class="title" data-reqNo="${vo.no }">${vo.purpose }/${vo.amount }$</td>
											<td>
												<c:choose>
													<c:when test="${vo.status == 1}">Pending</c:when>
													<c:when test="${vo.status == 2}">Approved</c:when>
													<c:when test="${vo.status == 3}">Denied</c:when>
													<c:otherwise>error!</c:otherwise>
												</c:choose>
											</td>
											<td><c:out value="${vo.day }"/></td>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="4">No Request History Exist.</td>
									</tr>
								</c:otherwise>
							</c:choose>
						</tbody>

					</table>
				</div>
				 <div class="row text-center">
					<div class="pagination">
						<a href="#">&laquo;</a>
						<a class="active" href="#">1</a> 
						<c:forEach var="i" begin="2" end="10">
							<li class="page-item"><a class="page-link" href="#">${i }</a></li>
						</c:forEach>
						<a href="#">&raquo;</a>
					</div>
				</div>
			</div>
			<div class="col-md-1"></div>
		</div>
	</div>
</body>

<script>
	window.onload = function() {
		var allTd = document.getElementsByClassName("title");
		for (var i = 0; i < allTd.length; i++) {
			allTd[i].addEventListener('click', viewARequest, false);
		}
	}

	function viewARequest(event) {
		var requestNo = event.target.getAttribute("data-reqNo");
		// move to the page of the request.
		window.location.href = "/ReimbursementApp/rqViewForEmp.do?request_no="
				+ requestNo;
	}
</script>

</html>
