<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 get</title>
</head>
<body>

	<% 
								
	Cookie[] cookies = request.getCookies();
	
	for(int i=0; i<cookies.length; i++){
		String str = cookies[i].getName();
		System.out.println(cookies[i].getName()+" : "+cookies[i].getValue());
		
		if(str.equals("CookieN")){
			out.println("cookies[" + i + "] name : " + cookies[i].getName() + "<br / >");
			out.println("cookies[" + i + "] value : " + cookies[i].getValue() + "<br / >");
			out.println("=====================<br />");
				
			cookies[i].setMaxAge(0);
			response.addCookie(cookies[i]);
			
		}
		
	}


%>

	<a href="1_2cookie_get.jsp">cookie get</a>
	
	
</body>
</html>


