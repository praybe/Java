<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%! 
	//정해진 문구들. @ 하나라도 빠지면 골로 감ㅋㅋ 
	String driver ="oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String uid = "scott";
	String upw = "tiger";
	
	//jdbc 3종 세트 
	//반드시 sql에서 import할 것
	Connection connect; //커넥션 객체
	Statement stat;
	ResultSet rs;
	String query = "select *from dept";
	
%>

<% 

	try{
		
		Class.forName(driver);
		connect = DriverManager.getConnection(url,uid,upw);
		stat =connect.createStatement();
		rs = stat.executeQuery(query);
		
		while(rs.next()){ //12명을 차례로 돌리며 꺼내 옴
			String loc = rs.getString("loc");//컬럼명
			String dname = rs.getString("dname");
			int deptno =rs.getInt("deptno");
			
			//유저한테 보여주자
			out.print("부서번호: " + deptno +" || "+
					"부서 명: " + dname +" || "
					+ "근무지: " + loc + "<br>");		
		}
		
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		
		try{
			if(rs != null) rs.close();
			if(stat != null) stat.close();
			if(connect != null) connect.close();
		} catch(Exception e){
			
		}
		//오라클에 있는 것을 데려오는 것임
	}

%>

</body>
</html>