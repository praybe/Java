package edu.kosmo.ex.dto;

import java.sql.Timestamp;

/* 오라클 sql엥서 desc 테이블명; 해서 긁어 옴
 데이터 타입 실수 안하기 위해서 보면서 적으면 효율적임
 
BID      NOT NULL NUMBER(4)     
BNAME             VARCHAR2(20)  
BTITLE            VARCHAR2(100) 
BCONTENT          VARCHAR2(300) 
BDATE             DATE          
BHIT              NUMBER(4)     
BGROUP            NUMBER(4)     
BSTEP             NUMBER(4)     
BINDENT           NUMBER(4)
*/

public class BDto {
	//순서대로 변수명 적어야함. 
	private int bid; //실무에서는 게시판 글이 많아서 long으로 줌
	private String bname;
	private String btitle;
	private String bcontent;
	private Timestamp bdate;
	private int bhit;
	private int bgroup;
	private int bstep;
	private int bindent;
	
	//그리고 게터세터 생성자 만들기
	
	public BDto() {}
	
	public BDto(int bid, String bname, String btitle, String bcontent, Timestamp bdate, int bhit, int bgroup, int bstep,
			int bindent) {
		this.bid = bid;
		this.bname = bname;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bdate = bdate;
		this.bhit = bhit;
		this.bgroup = bgroup;
		this.bstep = bstep;
		this.bindent = bindent;
	}
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public Timestamp getBdate() {
		return bdate;
	}
	public void setBdate(Timestamp bdate) {
		this.bdate = bdate;
	}
	public int getBhit() {
		return bhit;
	}
	public void setBhit(int bhit) {
		this.bhit = bhit;
	}
	public int getBgroup() {
		return bgroup;
	}
	public void setBgroup(int bgroup) {
		this.bgroup = bgroup;
	}
	public int getBstep() {
		return bstep;
	}
	public void setBstep(int bstep) {
		this.bstep = bstep;
	}
	public int getBindent() {
		return bindent;
	}
	public void setBindent(int bindent) {
		this.bindent = bindent;
	}

	
	
}
