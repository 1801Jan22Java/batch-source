<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="UTF-8">
<title>Request List View For Manager</title>
<link rel="stylesheet" href="styles/common.css" />
<link rel="stylesheet" href="styles/manager.css" />
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-10">

			<jsp:include page="../common/header.jsp"/>

				<div class="row">
						<a class="btn btn-primary pull-right" role="button" href="/ReimbursementApp/rqListViewForMng.do"> View Request </a>
				</div>
			<br/>
				<div class="row  ">
					<table class="table table-hover table-bordered text-center">
						<thead>
							<tr>
								<th class="text-center" style="width:10%">No.</th>
								<th class="text-center" style="width:50%">Employee ID</th>
								<th class="text-center" style="width:20%">Total Request Count</th>
								<th class="text-center" style="width:20%">Total Amount</th>
							</tr>
						</thead>
						<tbody>
						<c:choose>
							<c:when test="${ifRExist>0 }">
								<c:forEach items="${mVos }" var="vo">
									<tr>
										<td><c:out value="${vo.theRow }"/></td>
										<td style="cursor: pointer;" 
										class="employees"
										data-mId="<c:out value="${vo.employee_id }"/>"
										data-mNo="<c:out value="${vo.employee_no }"/>" >
											<c:out value="${vo.employee_id }"/>
										</td>
										<td><c:out value="${vo.cnt }"/></td>
										<td><c:out value="${vo.total_amount }"/></td>
									</tr>
									
								</c:forEach>
							</c:when>
							<c:otherwise><tr><td colspan="4"></td></tr></c:otherwise>
						</c:choose>
						</tbody>

					</table>
				</div>
				<div class="row text-center">
					<div class="pagination">
						<a href="#">&laquo;</a>
						<a href="#">1</a>
						<a class="active" href="#">2</a>
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
<script>
	window.onload = function() {
		var allTd = document.getElementsByClassName("employees");
		for (var i = 0; i < allTd.length; i++) {
			allTd[i].addEventListener('click', viewRequestsOfEmp, false);
		}
	}

	function viewRequestsOfEmp(event) {
		
		var employee_no = event.target.getAttribute("data-mNo");
		var employee_id = event.target.getAttribute("data-mId");
	 
		// move to the page of the request.
		 window.location.href = "/ReimbursementApp/empRqListViewForMng.do?employee_no="
				+ employee_no + "&employee_id="+employee_id;
		}
</script>
</html>
