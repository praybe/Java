package edu.kosmo.bean;

public class Student {
	private String name; 
	private int kor, eng, math, total;
	private double avg;
	
	public Student() {}
	
	public Student(String name, int kor, int eng, int math){
		this.name = name;
		this.kor= kor;
		this.eng = eng;
		this.math = math;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}
	
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotal() {
		return kor+math+eng;
	}
	
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public double getAvg() {
		return getTotal() / 3.0 ;
	}



}
