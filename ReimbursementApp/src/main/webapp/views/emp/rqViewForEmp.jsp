<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="UTF-8">
<title>Submit Reimbursement request by an Employee</title>
<link rel="stylesheet" href="styles/employee.css" />
<link rel="stylesheet" href="styles/common.css" />
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-10">

				<jsp:include page="../common/header.jsp" />

				<br>
				<div class="row btn-toolbar">
					<a role="button" class="btn btn-danger navbar-btn pull-right" href="javascript:history.back()">Go Back to Request List</a>
				</div>
				<c:if test="${rVos.status > 1 }">
					<div class="row">
						<div class="alert alert-danger text-center">
							 <strong>Resolved By : [<c:out value="${mngVo.id}" />]</strong>
						</div>
					</div>
				</c:if>
				<div class="row ">
					<table class="table table-hover table-bordered">
						<thead>
							<tr>
								<th colspan="2">
									Reimbursement Request No.
									<c:out value="${rVos.no}" />
								</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td style="width: 20%">Purpose</td>
								<td style="width: 80%">
									<c:out value="${rVos.purpose}" />
								</td>
							</tr>
							<tr>
								<td>Amount</td>
								<td>
									<c:out value="${rVos.amount }" />
									$
								</td>
							</tr>
							<!-- <tr>
								<td>Receipt Image</td>
								<td class="btn-toolbar">
									<button type="button" class="btn btn-primary btn-xs">Img1</button>
									<button type="button" class="btn btn-primary btn-xs">Img2</button>
									<button type="button" class="btn btn-primary btn-xs">Img3</button>
									<input type="submit">
								</td>
							</tr> -->
							<tr>
								<td colspan="2" class="text-center">
									<c:choose>
										<c:when test="${imgCnt > 0 }">
											<c:forEach items="${ iVos}" var="vo">
												<img style="width: 70%;" src=" <c:url value="${vo.filename }"/> ">
											</c:forEach>
										</c:when>
										<c:otherwise>
											No image is registered on this request.
										</c:otherwise>
									</c:choose>
								</td>
							</tr>

						</tbody>
					</table>
				</div>

			</div>
			<div class="col-md-1"></div>
		</div>
	</div>
	<br>
</body>
<script>
	var img = new Image();
	document.getElementById("")
</script>
</html>
