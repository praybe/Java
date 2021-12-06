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

<!-- 테이블 구성할떄 px 잊지 말기 -->
	<table width="500px" border="1px">
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>제목</td>
			<td>날짜</td>
			<td>히트</td>
		</tr>
		
		<c:forEach var="dto" items="${list}">  <!-- 여기서 list는 BListCommand.java에서 갖고옴 -->
			<tr>
				<td>${dto.bid}</td>
				<td>${dto.bname}</td>
				
			<!-- 제목 줄 처리 -->
				<td>
					<c:forEach begin="1" end="${dto.bindent}">[Re]</c:forEach> <!-- indent가 하나라도 있으면 옆칸으로 가게 하는 코드 -->
						<a href="content_view.do?bid=${dto.bid}">${dto.btitle}</a>
				</td>
				
				
			<!-- 글 작성 부분 -->
				<td>${dto.bdate}</td>
				<td>${dto.bhit}</td>
			</tr>
		</c:forEach>
		
		<tr>
			<td colspan="5">
			<a href="write_view.do">글작성</a>
				
			</td>	
		</tr>
	

	</table>

</body>
</html>


<!-- 주소 끝에 /list.do 넣고 엔터

http://localhost:8282/jsp_board1/list.jsp 가 아니라 

http://localhost:8282/jsp_board1/list.do 주소가 되어야 함


list.do라고 치고 들어가면 BController객체가 처리하겠다. get방식임. 그러면 actionDo를 타게 됨-->

