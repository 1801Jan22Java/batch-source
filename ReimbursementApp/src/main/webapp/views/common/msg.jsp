<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Message</title>
<link rel="stylesheet" href="styles/common.css" />
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="scripts/login.js"></script>
</head>
<body>
	<%
		String error_code = request.getParameter("error_code");
		int code = Integer.parseInt(error_code);

		if (code == 1) { // Join - id already exist. go back to login page.
	%>
	<script>
		alert("Same Id already exist. It goes back to the login page and try with different ID.");
		window.location.replace("/ReimbursementApp/login.do");
		</script>
	<%
		} else if (code == 2) { // registered as a memger.
	%>
	<script>
		alert("congratulation! You are now registered as a new member.");
		window.location.replace("/ReimbursementApp/login.do");
	</script>
	<%
		response.sendRedirect("/ReimbursementApp/login.do");
		} else if (code == 3){
			%>
			<script>
				alert("Wrong Password. please try again.");
				window.location.replace("/ReimbursementApp/login.do");
				</script>
			<%
		} else if (code==4){
			%>
			<script>
				alert("The ID doesen't exist. please try again.");
				window.location.replace("/ReimbursementApp/login.do");
			</script>
			<%
		} else if (code==5){
			%>
			<script>
				alert("Same e-mail already exist. please try with different e-mail address.");
				window.location.replace("/ReimbursementApp/empViewModifyForEmp.do");
			</script>
			<%
		}
	%>
 
	<br>
</body>
</html>
l>
