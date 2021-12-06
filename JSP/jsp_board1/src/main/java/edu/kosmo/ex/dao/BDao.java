package edu.kosmo.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import edu.kosmo.ex.dto.BDto;

public class BDao {
	
	//커넥션풀이라는 객체가 DataSource
	private DataSource dataSource; //import 위치 주의
	
	public BDao() {
		try {
			
			//context는 Server의 context.xml에 있는 메모리에 올린 세팅 설정을 가져옴
			Context context = new InitialContext();
			
			//커넥션 객체를 다 끌고 오려면 oracle jdbc에 있는 애들을 다 끌고 와라 
			//server의 context.xml의 name="jdbc/oracle" 부분 반드시 맞추기
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
			
			
		}catch (Exception e) {
			e.printStackTrace();//혹시 에러가 뜨면 화면에 출력
		}
		
	}
	
	
	
	//(BList)
	public ArrayList<BDto> list(){
		//게시판 글들을 하나하나 담아야 함
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		
		//3종세트
		Connection connection = null;
		PreparedStatement preparedStatement = null; //State 보안을 더 강화한게 prepared...
		ResultSet rs = null;
		
		//이러고 try catch 묶어주기
		try {
			
			//쿼리가 상당히 중요하니 암기 요
			String query = "select * from mvc_board order by bgroup desc, bstep asc";
			
			
			//connection객체를 커낵션 풀에서 꺼내기
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Timestamp bdate = rs.getTimestamp("bdate");
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				
				BDto dto = new BDto(bid, bname, btitle, bcontent, bdate,
						bhit, bgroup, bstep, bindent);
				dtos.add(dto);
				
				
			}
			
						
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			
		}
		
		
		return dtos;
		
		
	}
	
	
	
	
	//게시글 만들기(BWrite)
	public void write(String bname, String btitle, String bcontent){
		Connection connection = null;
		PreparedStatement preparedStatement = null; 
	
		try {					
			String query = "insert into mvc_board"
																									//nextval 기존값에서 자동적으로 하나씩 증가, currval지금 번호  				
					+"(bid, bname, btitle, bcontent, bhit, bgroup, bstep, bindent) values "
					+ "(mvc_board_seq.nextval, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0 )";
			
			connection = dataSource.getConnection();		
			preparedStatement = connection.prepareStatement(query);			
			
			// ?, ?, ? 에 차례로 세팅
			preparedStatement.setString(1, bname);
			preparedStatement.setString(2, btitle);
			preparedStatement.setString(3, bcontent);
			
			//executeUpdate 함수를 사용하는 방법
			// -> Insert / Delete / Update 관련 구문에서는 반영된 레코드의 건수를 반환
			// -> Create / Drop 관련 구문에서는 -1을 반환
						
			int rn = preparedStatement.executeUpdate();
			System.out.println("업데이트 갯수: " + rn);
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
		
	}
	
	
	
	//글 내용 보기(BContent)
	public void content(String bname, String btitle, String bcontent){
		Connection connection = null;
		PreparedStatement preparedStatement = null; 
	
		try {					
			String query = "insert into mvc_board"
																									//nextval 기존값에서 자동적으로 하나씩 증가, currval지금 번호  				
					+"(bid, bname, btitle, bcontent, bhit, bgroup, bstep, bindent) values "
					+ "(mvc_board_seq.nextval, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0 )";
			
			connection = dataSource.getConnection();		
			preparedStatement = connection.prepareStatement(query);			
			
			// ?, ?, ? 에 차례로 세팅
			preparedStatement.setString(1, bname);
			preparedStatement.setString(2, btitle);
			preparedStatement.setString(3, bcontent);

		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
		
	}

	
}











