<%@page import="edu.kosmo.ex.dto.EmpDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="edu.kosmo.ex.dao.EmpDao"%>
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

	ArrayList<EmpDto> dtos =
	(ArrayList<EmpDto>) session.getAttribute("empList");
	
//inhenced for문
	for(EmpDto emp:dtos){
		out.print("이름: " + emp.getEname() +" || "+
				"사원 번호: " + emp.getEmpno() +" || "
				+ "직종: " + emp.getJob() + "<br>");
	
	}
	


%>

</body>
</html>