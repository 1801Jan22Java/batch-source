<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View a Resolved Reimbursement request by a Manager</title>
<link rel="stylesheet" href="styles/common.css" />
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="scripts/login.js"></script>
</head>
<body>

	<div class="container">
		<div class="row text-center">
			<div class="jumbotron" style="background-color: orange !important;">
				<h1>Welcome to Reimbursement App!</h1>
				<p>
				<h3>Please enter loginID with password below.</h3>

			</div>
		</div>
		
		<div class="row center-block" style="width: 40%;">
			 
			<form action="/ReimbursementApp/loginOk.do" method="post">
				<div class="form-group center-block">
					Name: <input type="text"  name="id" class="form-control input-lg" >
				</div>
				<div class="form-group">
					Password:<input type="password" name="pwd" class="form-control input-lg">
				</div>
			
			<div class="btn-toolbar pull-right">
			<input type="submit" class="btn btn-primary btn-lg center-block" value="Log In">
			<a role="button" class="btn btn-primary btn-lg center-block" href="/ReimbursementApp/join.do">Sign Up</a>
			</div>
			</form>
	
		</div>
	</div>
	<br>
</body>
</html>
