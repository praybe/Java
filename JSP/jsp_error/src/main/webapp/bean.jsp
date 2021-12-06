<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>16-1 빈 Bean</title>
</head>
<body>
	<!--Student student = new edu.kosmo.bean.Student(); 의 약자가  -->
	<!--Student student = new Student(); 이며 이거의 약자가 바로 아래거  -->
	<jsp:useBean id="student" class="edu.kosmo.bean.Student" />
	
	<!--student.setName(13); -->
	<jsp:setProperty property="name" name="student" value="개똥이"/>
	<jsp:setProperty property="kor" name="student" value="90"/>
	<jsp:setProperty property="eng" name="student" value="60"/>
	<jsp:setProperty property="math" name="student" value="70"/>
	<jsp:setProperty property="total" name="student"/>
	<jsp:setProperty property="avg" name="student"/>
	
	<!--student.geName();-->
	이름 : <jsp:getProperty property="name" name="student" /><br />
	국어 : <jsp:getProperty property="kor" name="student" /><br />
	영어 : <jsp:getProperty property="eng" name="student" /><br />
	수학 : <jsp:getProperty property="math" name="student" /><br />
	총점 : <jsp:getProperty property="total" name="student" /><br />
	평균 : <jsp:getProperty property="avg" name="student" /><br />


</body>
</html>