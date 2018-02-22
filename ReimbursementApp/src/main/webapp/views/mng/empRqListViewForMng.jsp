<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="UTF-8">
<title>View Request List of an Employee For Manager</title>
<link rel="stylesheet" href="styles/common.css" />
<link rel="stylesheet" href="styles/manager.css" />
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-10">

				<jsp:include page="../common/header.jsp" />

				<div class="row">
					<button class="btn btn-primary pull-left" type="button"> Employee ID : <c:out value="${employee_id }"/> </button> 
					<a class="btn btn-primary pull-right" role="button" href="/ReimbursementApp/empListViewForMng.do"> View Employees </a> 
					<a class="btn btn-primary pull-right" role="button" href="/ReimbursementApp/rqListViewForMng.do"> View Requests </a>
					<!-- <button class="btn btn-danger navbar-btn pull-right ">Submit Request</button> -->
				</div>
				<br>
				<div class="row  ">
					<table class="table table-hover table-bordered text-center">
						<thead>
							<tr>
								<th class="text-center" style="width: 10%">No.</th>
								<th class="text-center" style="width: 50%">Title</th>
								<th class="text-center" style="width: 20%">Status</th>
								<th class="text-center" style="width: 20%">Date</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${ rVos}" var="vo" >
								<tr>
									<td><c:out value="${vo.rowNum }"/></td>
									<td>${vo.purpose }${vo.amount } $</td>
									<td>
										<c:choose>
											<c:when test="${vo.status == 1}">Pending</c:when>
											<c:when test="${vo.status == 2}">Approved</c:when>
											<c:when test="${vo.status == 3}">Denied</c:when>
											<c:otherwise>error!</c:otherwise>
										</c:choose>
									</td>
									<td>${vo.day }</td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
				<div class="row text-center">
					<div class="pagination">
						<a href="#">&laquo;</a> 
						 <a class="active" href="#">1</a> 
						<a href="#">2</a>
						 <a href="#">3</a> 
						 <a href="#">4</a> 
						 <a href="#">5</a> 
						 <a href="#">6</a> 
						 <a href="#">&raquo;</a>
					</div>
				</div>
			</div>
			<div class="col-md-1"></div>
		</div>
	</div>
</body>
</html>
