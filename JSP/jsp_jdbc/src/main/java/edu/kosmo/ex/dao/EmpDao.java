package edu.kosmo.ex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import edu.kosmo.ex.dto.EmpDto;

public class EmpDao { //db�� access�ϱ� ���� Ŭ���� ����
	
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
	
	public ArrayList<EmpDto> empSelect(){//�¸�ť�� ����
		ArrayList<EmpDto> dtos = new ArrayList<EmpDto>(); //���������� �����ص� ��. �̰� ���� ���� ��
		
		//�Լ� �������� ��� 3�� ��Ʈ �־� ��.
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
				
				//ArrayList�ȿ� �ش� ��ü ���� �ֱ�
				
				dtos.add(dto);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				//���� ���� !! close�� �ڿ� �ݳ��̶� ��ü ���� ���� �Ųٷ� �Է�
				if(rs != null) rs.close(); //���� �������� �� �ͺ��� close
				if(stmt != null) stmt.close(); 
				if(con != null) con.close(); 
						
			} catch (Exception e2) {
				// TODO: handle exception
			}
	
		}
				
		return dtos; //ArrayList�� 12�� ��Ƽ� ��
		
	} 
		

}
