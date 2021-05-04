package com.tech.ninza.jdbc.daoEx;

public class Student {
	private Integer rollno;
	private String name;
	private Integer gpa;
	
	public Student(){
	}
	
	public Student(Integer rollno){
		this.rollno = rollno;
	}

	public Student(Integer rollno, String name, Integer gpa) {
		this.rollno = rollno;
		this.name = name;
		this.gpa = gpa;
	}

	public Integer getRollno() {
		return rollno;
	}

	public void setRollno(Integer rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGpa() {
		return gpa;
	}

	public void setGpa(Integer gpa) {
		this.gpa = gpa;
	}
}
