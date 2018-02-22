<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View a Resolved Reimbursement request by a Manager</title>
<link rel="stylesheet" href="../../styles/manager.css" />
<link rel="stylesheet" href="../../styles/common.css" />
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-10">

				<div class="row">
					<nav class="navbar navbar-inverse">
						<div class="container-fluid ">
							<div class="navbar-header">
								<a class="navbar-brand" href="#">Welcome, Emp001!</a>
							</div>
							<ul class="nav navbar-nav">
								<li class="active"><a href="#">Pending: 3</a></li>
								<li><a href="#">Approved: 4</a></li>
								<li><a href="#">Denied: 10</a></li>
							</ul>
							<div class="btn-toolbar">
								<button class="btn btn-default navbar-btn pull-right">Log-Out</button>
								<button class="btn btn-primary navbar-btn pull-right">My Account</button>
							</div>
						</div>
					</nav>

				</div>

				 
				
				<div class="row btn-toolbar">
					<button class="btn btn-primary navbar-btn pull-right ">Go Back to Request List</button>
				</div>
				
				<div class="row ">
					<table class="table table-hover table-bordered">
						<thead>
							<tr>
								<th colspan="2">Reimbursement Request No. 1022</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td colspan="2">
									<div class="alert alert-warning">
										<strong>Resolved</strong>  
									</div>
								</td>
							</tr>
							<tr>
								<td style="width: 20%">Employee ID</td>
								<td style="width: 80%">
									Emp100
								</td>
							</tr>
							<tr>
								<td style="width: 20%">Manager ID</td>
								<td style="width: 80%">
									Manager1002
								</td>
							</tr>
							<tr>
								<td style="width: 20%">Purpose</td>
								<td style="width: 80%">
									Business Trip
								</td>
							</tr>
							<tr>
								<td>Amount</td>
								<td>150 $</td>
							</tr>
							<tr>
								<td>Receipt Image</td>
								<td class="btn-toolbar">
									<button type="button" class="btn btn-primary btn-xs">Img1</button> 
									<button type="button" class="btn btn-primary btn-xs">Img2</button>
									<button type="button" class="btn btn-primary btn-xs">Img3</button>
									<!-- <input type="submit"> -->
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<img style=" width:100%;" src="../../resources/img/receipt.jpg">
								</td>
							</tr>
						</tbody>
					</table>
				</div>

			</div>
			<div class="col-md-1"></div>
			<br><br>
		</div>
	</div>
	<br>
</body>
</html>
