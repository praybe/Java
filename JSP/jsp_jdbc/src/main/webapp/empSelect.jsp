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
	EmpDao empDao = new EmpDao();

	ArrayList<EmpDto> dtos = empDao.empSelect();
	
	for(int i =0; i < dtos.size(); i++){
		EmpDto dto = dtos.get(i);
		out.print("이름: " + dto.getEname() +" || "+
				"사원 번호: " + dto.getEmpno() +" || "
				+ "직종: " + dto.getJob() + "<br>");
	}
	
	session.setAttribute("emplist", dtos);

%>

<br>
<a href="empSelect2.jsp">empSelect2.jsp로 이동 </a>

</body>
</html>