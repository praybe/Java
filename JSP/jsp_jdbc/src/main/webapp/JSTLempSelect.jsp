<%@page import="edu.kosmo.ex.dto.EmpDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="edu.kosmo.ex.dao.EmpDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- el안에 들어 가는 것은
1. 리턴 값이 있거나
2. 변수가 들어 온다. (메모리에 올라가 있는 놈이 와야 함)
${empList}가 오거나 ${1<10}이런게 와야 함  -->
<%
	EmpDao empDao = new EmpDao(); 
	ArrayList<EmpDto> dtos = empDao.empSelect(); //dtos는 4byte 주소
	
	pageContext.setAttribute("empList", empDao.empSelect()); 

	
%>
${empList } <!-- 실체를 가지고있는 결과값 첫번째 주소 -->
<c:forEach var="emp" items="${empList}">
	이름: ${emp.ename} 번호:${emp.empno}<br>
</c:forEach>


</body>
</html>