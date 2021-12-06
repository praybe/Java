package edu.kosmo.ex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import edu.kosmo.ex.dto.deptDto;

public class deptDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "scott";
	private String upw = "tiger";
	
	public deptDao() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<deptDto> dept_select(){
		
		ArrayList<deptDto> dto = new ArrayList<deptDto>();
		
		Connection con = null;
		Statement stat = null;
		ResultSet rs = null;
		
		try {
			String query = "select *from dept";
			con = DriverManager.getConnection(url,uid,upw);
			stat =con.createStatement();
			rs = stat.executeQuery(query);
			
			while(rs.next()) {
				String loc = rs.getString("loc");
				String dname = rs.getString("dname");
				int deptno =rs.getInt("deptno");
				
				deptDto dtoo = new deptDto(deptno, dname, loc);  
				
				dto.add(dtoo);
		
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(stat != null) stat.close();
				if(con != null) con.close();
							
			} catch (Exception e2) {

			}
		}
		
		return dto;
		
	} 
	
}
