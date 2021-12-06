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
	
	//Ŀ�ؼ�Ǯ�̶�� ��ü�� DataSource
	private DataSource dataSource; //import ��ġ ����
	
	public BDao() {
		try {
			
			//context�� Server�� context.xml�� �ִ� �޸𸮿� �ø� ���� ������ ������
			Context context = new InitialContext();
			
			//Ŀ�ؼ� ��ü�� �� ���� ������ oracle jdbc�� �ִ� �ֵ��� �� ���� �Ͷ� 
			//server�� context.xml�� name="jdbc/oracle" �κ� �ݵ�� ���߱�
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
			
			
		}catch (Exception e) {
			e.printStackTrace();//Ȥ�� ������ �߸� ȭ�鿡 ���
		}
		
	}
	
	
	
	//(BList)
	public ArrayList<BDto> list(){
		//�Խ��� �۵��� �ϳ��ϳ� ��ƾ� ��
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		
		//3����Ʈ
		Connection connection = null;
		PreparedStatement preparedStatement = null; //State ������ �� ��ȭ�Ѱ� prepared...
		ResultSet rs = null;
		
		//�̷��� try catch �����ֱ�
		try {
			
			//������ ����� �߿��ϴ� �ϱ� ��
			String query = "select * from mvc_board order by bgroup desc, bstep asc";
			
			
			//connection��ü�� Ŀ���� Ǯ���� ������
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
	
	
	
	
	//�Խñ� �����(BWrite)
	public void write(String bname, String btitle, String bcontent){
		Connection connection = null;
		PreparedStatement preparedStatement = null; 
	
		try {					
			String query = "insert into mvc_board"
																									//nextval ���������� �ڵ������� �ϳ��� ����, currval���� ��ȣ  				
					+"(bid, bname, btitle, bcontent, bhit, bgroup, bstep, bindent) values "
					+ "(mvc_board_seq.nextval, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0 )";
			
			connection = dataSource.getConnection();		
			preparedStatement = connection.prepareStatement(query);			
			
			// ?, ?, ? �� ���ʷ� ����
			preparedStatement.setString(1, bname);
			preparedStatement.setString(2, btitle);
			preparedStatement.setString(3, bcontent);
			
			//executeUpdate �Լ��� ����ϴ� ���
			// -> Insert / Delete / Update ���� ���������� �ݿ��� ���ڵ��� �Ǽ��� ��ȯ
			// -> Create / Drop ���� ���������� -1�� ��ȯ
						
			int rn = preparedStatement.executeUpdate();
			System.out.println("������Ʈ ����: " + rn);
			
		
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
	
	
	
	//�� ���� ����(BContent)
	public void content(String bname, String btitle, String bcontent){
		Connection connection = null;
		PreparedStatement preparedStatement = null; 
	
		try {					
			String query = "insert into mvc_board"
																									//nextval ���������� �ڵ������� �ϳ��� ����, currval���� ��ȣ  				
					+"(bid, bname, btitle, bcontent, bhit, bgroup, bstep, bindent) values "
					+ "(mvc_board_seq.nextval, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0 )";
			
			connection = dataSource.getConnection();		
			preparedStatement = connection.prepareStatement(query);			
			
			// ?, ?, ? �� ���ʷ� ����
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











