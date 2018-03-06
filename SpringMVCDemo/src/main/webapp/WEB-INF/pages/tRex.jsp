<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Simple T-Rex View</title>
</head>
<body>

	<p>Here is some data for T-Rex ${tRexId} :</p>
	<p>(this was rendered server-side)</p>
	
	<ul>
		<li>T-Rex name: ${tRexName}</li>
		<li>T-Rex feather color: ${tRexFeatherColor}</li>
	</ul>

</body>
</html>