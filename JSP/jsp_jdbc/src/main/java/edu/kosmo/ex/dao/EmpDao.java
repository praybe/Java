package edu.kosmo.ex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import edu.kosmo.ex.dto.EmpDto;

public class EmpDao { //db에 access하기 위한 클래스 생성
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "scott";
	private String upw = "tiger";
	
	public EmpDao() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public ArrayList<EmpDto> empSelect(){//셋리큐맵 등장
		ArrayList<EmpDto> dtos = new ArrayList<EmpDto>(); //폴리몰피즘 적용해도 됨. 이건 적용 안한 거
		
		//함수 빨같밑줄 잡고 3종 세트 넣어 줌.
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			String query = "select *from emp";
			con = DriverManager.getConnection(url, uid, upw);
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int empno = rs.getInt("empno");
			
				EmpDto dto = new EmpDto(empno, ename, job);
				
				//ArrayList안에 해당 객체 집어 넣기
				
				dtos.add(dto);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				//순서 있음 !! close는 자원 반납이라 객체 생성 순서 거꾸로 입력
				if(rs != null) rs.close(); //제일 마지막에 온 것부터 close
				if(stmt != null) stmt.close(); 
				if(con != null) con.close(); 
						
			} catch (Exception e2) {
				// TODO: handle exception
			}
	
		}
				
		return dtos; //ArrayList에 12개 담아서 옴
		
	} 
		

}
