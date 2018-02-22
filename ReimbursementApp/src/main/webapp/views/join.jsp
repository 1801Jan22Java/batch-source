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
					Name: <input type="text" name="id" class="form-control input-lg">
				</div>
				<div class="form-group">
					Password: <input type="password" name="pwd" class="form-control input-lg"> <input type="hidden" id="lv" name="lv" value="1">
				</div>
				<div class="form-group">
					email: <input type="email" name="email" class="form-control input-lg">
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
	if (document.reg_fm.id.value.length < 4) {
		alert("Id should be more than 4 letters.");
		reg_fm.id.focus();
		return;
	}
	
	if (document.getElementById("ifManager").checked){
		document.getElementById("lv").value = 0;
	}
	document.reg_fm.submit();
}
</script>
</html>
