<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!-- 반드시 태그 라이브러리 주의 -->    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
</head>
<body>

	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<form action="write.do" method="post">
			<tr>
				<td>이름 </td>
				<td> <input type="text" name="bname" size = "50"> </td>
			</tr>
			<tr>
				<td>제목 </td>
				<td> <input type="text" name="btitle" size = "50"> </td>
			</tr>
			<tr>
				<td>내용 </td>
				<td> <textarea name="bcontent" rows="10" ></textarea> </td>
			</tr>
			<tr >
			<!-- submit을 누르면 write.do로 가라 -->
				<td colspan="2"> <input type="submit" value="입력"> &nbsp;&nbsp; <a href="list.do">글작성</a></td>
			</tr>
		</form>
	</table>

</body>
</html>


<!-- 주소 끝에 /list.do 넣고 엔터

http://localhost:8282/jsp_board1/list.jsp 가 아니라 

http://localhost:8282/jsp_board1/list.do 주소가 되어야 함


list.do라고 치고 들어가면 BController객체가 처리하겠다. get방식임. 그러면 actionDo를 타게 됨-->

