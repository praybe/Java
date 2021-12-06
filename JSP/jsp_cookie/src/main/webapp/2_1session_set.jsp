<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% 
	
	session.setAttribute("sessionName", "sessionValue");
	session.setAttribute("myNum", 12345);

%>

	<a href="2_2session_get.jsp">session get</a>

</body>
</html>

<!-- 세션은 내장객체라서 new할 필요가 없음 -->