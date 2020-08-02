package com.tech.ninza.jdbc.daoEx;


public class StudentDriver {
	public static void main(String[] args) {
		StudentImplementor si = new StudentImplementor();
		System.out.println("Welcome to Student DAO Portal.");
		si.insertStudent();
		si.showStudent();
		si.updateStudent();
		si.deleteStudent();
		si.showAllStudent();
	}
}
