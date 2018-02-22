<!DOCTYPE html>
<%@page import="com.revature.dao.MemberDao"%>
<%@page import="com.revature.dao.MemberDaoImpl"%>
<html>
<head>
<meta charset="UTF-8">
<title>Validate Registration a new Employee</title>
<link rel="stylesheet" href="../styles/common.css" />
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="../scripts/login.js"></script>
</head>
<jsp:useBean id="memberVo" class="com.revature.vo.MemberVo" />

<body>
	<%
		memberVo.setId(request.getParameter("id"));
		memberVo.setEmail(request.getParameter("email"));
		memberVo.setPwd(request.getParameter("pwd"));
		memberVo.setLv(request.getParameter("lv"));
		out.println(memberVo.toString());
		
		MemberDao memberDao = new MemberDaoImpl();
		int cnt = memberDao.ifMemberExist(memberVo.getId());
		//int cnt = 0;
		if (cnt > 0 ){
			out.println("opps! already here.");
	%>
		<script>
			alert("this Id already exist.");
			history.back();
		</script>	
	<%		
		} else {
			int result = memberDao.insertMember(memberVo);
			%>
			<script>
				alert("Congratulation! You are now registered.");
				document.location.href="login.jsp"				
				</script>	
		<%
		} 
	%>

	
	<br>
</body>
</html>
