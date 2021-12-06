<%@page import="edu.kosmo.ex.dto.BDto"%>
<%@page import="edu.kosmo.ex.dao.BDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <!-- 반드시 태그 라이브러리 주의 -->    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Test</title>
</head>
<body>
<%
	BDao bdao = new BDao();
	ArrayList<BDto> dtos = bdao.list();
	
	for(BDto dto : dtos){
		out.print("번호: " + dto.getBid() + 
				"제목: " + dto.getBtitle() +"</br>"
				
				
				);
		
	}
	
%>

</body>
</html>