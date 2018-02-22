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

				<jsp:include page="../common/header.jsp"></jsp:include>

				<br>
				<form action="requestUpdate.do" method="post" enctype="multipart/form-data" id="request">
					<div class="row ">
						<table class="table table-hover table-bordered text-center">
							<thead>
								<tr>
									<th colspan="2">Reimbursement Request Application</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td style="width: 20%">Purpose</td>
									<td style="width: 80%">
										<select class="form-control" name="purpose">
											<option>Business Trip</option>
											<option>Purchase Office Supply</option>
											<option>Certificate</option>
											<option>Buyer Treatment</option>
											<option>Relocation</option>
											<option>Health Insurance</option>
											<option>ETC</option>
										</select>
									</td>
								</tr>
								<tr>
									<td>Amount</td>
									<td>
										<div class="input-group">
											<span class="input-group-addon"><i class="glyphicon glyphicon-usd"></i></span> 
											<input type="number" class="form-control" name="amount" id="amount">
										</div>
									</td>
								</tr>
								<tr>
									<td>
										Receipt Image<br /> (only .jpg, .gif, png)<br />
										<br />
										<!-- <button type="button" class="btn btn-danger" id="addFile">Add</button> -->
									</td>
									<td>
										<div class="input-group">
											<span class="input-group-addon"><i class="glyphicon glyphicon-remove"></i>
											<input type="file" name="receipt_img" accept="image/*"> 
											</span> 
											<span class="input-group-addon"><i class="glyphicon glyphicon-remove"></i>
											<input type="file" name="receipt_img2" accept="image/*"> 
											</span>
											<span class="input-group-addon"><i class="glyphicon glyphicon-remove"></i>
											<input type="file" name="receipt_img3" accept="image/*"> 
											</span>
											<!-- <input type="file" name="receipt_img2" accept="image/*"> 
											<input type="file" name="receipt_img3" accept="image/*"> -->
										</div>
									</td>
								</tr>

							</tbody>
						</table>
					</div>

					<div class="row ">
						<div class="btn-toolbar">
							<a class="btn btn-danger pull-right" role="button" href="javascript:history.back()"> Go Back to Request List </a>
							<input type="button" class="btn btn-danger pull-right" value="Submit Request" onclick="submitRequest();"> 
						</div>
					</div>

				</form>

			</div>
			<div class="col-md-1"></div>
		</div>
	</div>
</body>
<script>

window.onload = function(){
	var xs = document.getElementsByClassName("glyphicon glyphicon-remove")
	for (var i = 0 ; i < xs.length ; i++){
		xs[i].addEventListener("click", resetImg);
	}
	
}
function resetImg(event){
	event.target.nextElementSibling.value = "";
}
	function submitRequest() {
		var amount = document.getElementById("amount").value;
		if (amount == "" || amount == null) {
			alert("The amount should be more than zero.");
			document.getElementById("amount").focus();
			return;
		}
		if (window.confirm("Are you sure to submit the request?")){
			document.getElementById("request").submit();
		}
	}
</script>

</html>
