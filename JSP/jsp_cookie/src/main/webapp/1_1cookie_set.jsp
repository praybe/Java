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
								//key value 형태
	Cookie cookie = new Cookie("CookieN", "CookieV"); //쿠키 객체 생성

	cookie.setMaxAge(60*60); //쿠키 시간 설정 
	
	
	response.addCookie(cookie); 
	

%>

	<a href="1_2cookie_get.jsp">cookie get</a>

</body>
</html>
<!-- 쿠키는 string만 가능 -->