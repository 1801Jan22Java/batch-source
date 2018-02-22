<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign up Form</title>
<link rel="stylesheet" href="styles/common.css" />
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="scripts/login.js"></script> 

</head>
<body>

	<div class="container">
		<div class="row text-center">
			<div class="jumbotron" style="background-color: orange !important;">
				<h1>Ready for Sign up?!</h1>
				<p>
				<h3>Please Submit loginID with password, email address below.</h3>

			</div>
		</div>

		<form action="/ReimbursementApp/joinOk.do" method="post" name="reg_fm">
			<div class="row center-block" style="width: 40%;">

				<div class="form-group center-block">
					Name: <input type="text" name="id" id="id" class="form-control input-lg">
				</div>
				<div class="form-group">
					Password: <input type="password" name="pwd" id="pwd" class="form-control input-lg"> 
					<input type="hidden" id="lv" name="lv" value="1">
				</div>
				<div class="form-group">
					email: <input type="email" name="email" id="email" class="form-control input-lg">
				</div>

				<input type="checkbox" id="ifManager" value="" style="transform: scale(1.5);"> Manager
				<div class="btn-toolbar pull-right">
					<input type="button" class="btn btn-primary btn-lg center-block" value="Submit" onclick="infoConfirm()"> 
					<input type="reset" class="btn btn-primary btn-lg center-block" value="Reset">
				</div>
			</div>
		</form>
	</div>
	<br>
</body>
<script>
function infoConfirm() {
	
	var id = document.getElementById("id").value;
	var pwd = document.getElementById("pwd").value;
	var email = document.getElementById("email").value;
	if (id == "" || id == null){
		alert("Please input the ID.");
		 document.getElementById("id").focus();
		return ;
	} 
	if (pwd == "" || pwd == null){
		alert("Please input the password.");
		document.getElementById("pwd").focus();
		return;	
	} 
	if (email == "" || email == null){
		alert("Please input the e-mail.");
		document.getElementById("email").focus();
		return;
	} 
	
	if (document.getElementById("ifManager").checked){
		document.getElementById("lv").value = 0;
	}
	document.reg_fm.submit();
}
</script>
</html>
