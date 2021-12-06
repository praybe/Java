<%@page import="edu.kosmo.ex.dto.deptDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="edu.kosmo.ex.dao.deptDao"%>
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

	deptDao dptd = new deptDao();
	
	ArrayList<deptDto> dto = dptd.dept_select();
	
	for(int i = 0; i < dto.size(); i++){
		deptDto dtoo = dto.get(i);
		
		out.print("부서번호: " + dtoo.getDeptno() +" || "+
				"부서 명: " + dtoo.getDname() +" || "
				+ "근무지: " + dtoo.getLoc() + "<br>");	
	}

%>

</body>
</html>