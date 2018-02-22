<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Information viewed by an Employee</title>
<link rel="stylesheet" href="styles/employee.css" />
<link rel="stylesheet" href="styles/common.css" />
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-10">

				<jsp:include page="../common/header.jsp"></jsp:include>

				<br>
				<div class="row  ">
					<table class="table table-hover table-bordered text-center">
						<thead>
							<tr>
								<th colspan="2">View Information of <c:out value="${mVo.id }"/></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td style="width: 20%">Login ID</td>
								<td style="width: 80%"><c:out value="${mVo.id }"/></td>
							</tr>
							<tr>
								<td>Password</td>
								<td><c:out value="${mVo.pwd }"/></td>
							</tr>
							<tr>
								<td>Email</td>
								<td><c:out value="${mVo.email }"/></td>
							</tr>
							<tr>
								<td>Level</td>
								<td>
								<input type="hidden" name="lv" id="lv" value="<c:out value="${mVo.lv }"/>">
								<c:if test="${mVo.lv == 0 }">Manager</c:if>
								<c:if test="${mVo.lv == 1 }">Employee</c:if>
								</td>
							</tr>


						</tbody>

					</table>
				</div>

				<div class="row btn-toolbar">
					<button id="moveToReqList"  class="btn btn-success navbar-btn pull-right " role="button">Go Back to Request List</button>
					<a class="btn btn-success navbar-btn pull-right " role="button" href="empViewModifyForEmp.do">Update My Info</a>
				</div>


			</div>
			<div class="col-md-1"></div>
		</div>
	</div>
</body>
<script>
	window.onload = function() {
		document.getElementById("moveToReqList").addEventListener("click", moveToReqList);
	}
	function moveToReqList(event){
		var lv = document.getElementById("lv").value;
		if (lv == 0){			// if manager
			window.location.replace("/ReimbursementApp/rqListViewForMng.do");
		} else if (lv == 1){	// if employee
			window.location.replace("/ReimbursementApp/rqListViewForEmp.do");
		}
	}
</script>

</html>
