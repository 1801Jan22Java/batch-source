<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modify Employee Information by an Employee</title>
<link rel="stylesheet" href="../../styles/employee.css" />
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
								<button class="btn btn-danger navbar-btn pull-right">My Account</button>
							</div>
						</div>
					</nav>

				</div>

				<br>
				<div class="row  ">
					<table class="table table-hover table-bordered ">
						<thead>
							<tr>
								<th colspan="2">Modify Information of Emp001</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td style="width: 20%">Login ID</td>
								<td style="width: 80%">Emp001</td>
							</tr>
							<tr>
								<td>Password</td>
								<td><input type="text" class="form-control" id="usr" value="**********"></td>
							</tr>
							<tr>
								<td>Email</td>
								<td><input type="text" class="form-control" id="usr" value="emp001@gmail.com"></td>
							</tr>
							<tr>
								<td>Contact No</td>
								<td><input type="text" class="form-control" id="usr" value="1 828 828 8883"> </td>
							</tr>


						</tbody>

					</table>
				</div>

				<div class="row btn-toolbar">
					<button class="btn btn-danger navbar-btn pull-right ">Go Back to Request List</button>
					<button class="btn btn-danger navbar-btn pull-right ">Modify My Info</button>
				</div>


			</div>
			<div class="col-md-1"></div>
		</div>
	</div>
</body>
</html>
