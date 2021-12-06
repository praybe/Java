<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 get</title>
</head>
<body>

	<% 

	Object obj1 = session.getAttribute("sessionName"); //변수 선언, 최고부모형태. 따라서 string 형변환 해야함
	String sessionName = (String)obj1;
	out.println(sessionName + "<br />");
	
	//==================================================
	int mynum =(int) session.getAttribute("myNum");
	out.println(mynum + "<br />");
	
	out.println("***********************<br>");
	
	String name;
	String value;
	
	Enumeration enumeration = session.getAttributeNames();
	
	while(enumeration.hasMoreElements()){
		name = enumeration.nextElement().toString();
		value = session.getAttribute(name).toString();
		
		out.println("name : " + name + "<br />");
		out.println("value : " + value+ "<br />");
		
	}
	
	out.println("***********************<br>");
	
	
	String sessionID = session.getId();
	out.println("sessionID : " + sessionID + "<br />");
	
	int sessionInter = session.getMaxInactiveInterval();
	out.println("sessionInter : " + sessionInter + "<br />");
	out.println("==============<br />");
	
	
	//==================================================
	session.removeAttribute("sessionName");
	
	Enumeration enumeration1 = session.getAttributeNames();
	
	while(enumeration1.hasMoreElements()){
		name = enumeration1.nextElement().toString();
		value = session.getAttribute(name).toString();
		
		out.println("name : " + name + "<br>");
		out.println("value : " + value + "<br>");		
		
	}
	
	out.println("*************************<br>");
	
	session.invalidate();
	
	if(request.isRequestedSessionIdValid()) {
		out.println("session valid");
	} else {
		out.println("session invalid");
	}
	
					
	%>

	<a href="2_2session_get.jsp">session get</a>


</body>
</html>
