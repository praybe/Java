<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page isErrorPage="true" %>
    <% response.setStatus(200); %>
    

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	에러발생<br/>
	<%= exception.getMessage()	%>

</body>
</html>


<!-- exception도 내장객체 -->
<!-- error페이지도 딱 정해진거 -->