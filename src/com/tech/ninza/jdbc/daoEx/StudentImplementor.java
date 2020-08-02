package com.tech.ninza.jdbc.daoEx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.tech.ninza.jdbc.daoEx.ConnectionConfig;

public class StudentImplementor implements StudentDao{
	private static final Scanner sc = new Scanner(System.in);
	Student stud = new Student();
	
	@Override
	public void insertStudent() {
		System.out.print("Please enter the Roll no. : ");
		stud.setRollno(sc.nextInt());
		sc.nextLine();
		System.out.print("Please enter the Name : ");
		stud.setName(sc.nextLine());
		System.out.print("Please enter the GPA : ");
		stud.setGpa(sc.nextInt());
		
		Connection connection;
		try {
			connection = ConnectionConfig.getConnection();
			PreparedStatement pstmt = connection.prepareStatement("insert into student values (?,?,?)");
			pstmt.setInt(1, stud.getRollno());
			pstmt.setString(2, stud.getName());
			pstmt.setInt(3, stud.getGpa());
			int rowsUpdated = pstmt.executeUpdate();
			System.out.println(rowsUpdated + " row(s) updated.");
			ConnectionConfig.close();
		} catch (ClassNotFoundException | SQLException e1) {
			System.out.printf("Error connecting to the database.", e1);
		} 
	}

	@Override
	public void showStudent() {
		System.out.print("Please enter the Roll no. : ");
		stud.setRollno(sc.nextInt());
		
		Connection connection;
		try {
			connection = ConnectionConfig.getConnection();
			Statement stmt = connection.createStatement(); 
			ResultSet rs = stmt.executeQuery("select * from student where rollno="+ stud.getRollno());
			
			System.out.println("Result of your query: ");
			while(rs.next())
				System.out.println(rs.getInt(1) + " - " + rs.getString(2) + " - " + rs.getInt(3));
			ConnectionConfig.close();
		} catch (ClassNotFoundException | SQLException e1) {
			System.out.printf("Error connecting to the database.", e1);
		}
		
	}

	@Override
	public void updateStudent() {
		System.out.print("Please enter the Roll no. : ");
		stud.setRollno(sc.nextInt());
		sc.nextLine();
		System.out.print("Please enter the updated Name : ");
		stud.setName(sc.nextLine());
		System.out.print("Please enter the updated GPA : ");
		stud.setGpa(sc.nextInt());
//		System.out.println(stud.getName()+" "+stud.getGpa()+" "+stud.getRollno());
		Connection connection;
		try {
			connection = ConnectionConfig.getConnection();
			PreparedStatement pstmt = connection.prepareStatement("update student set name=?, gpa=? where rollno=?");
			pstmt.setString(1, stud.getName());
			pstmt.setInt(2, stud.getGpa());
			pstmt.setInt(3, stud.getRollno());
			int rowsUpdated = pstmt.executeUpdate();
			System.out.println(rowsUpdated + " row(s) updated.");
			ConnectionConfig.close();
		} catch (ClassNotFoundException | SQLException e1) {
			System.out.print(e1);
			System.out.printf("Error connecting to the database.", e1);
		}
	}

	@Override
	public void deleteStudent() {
		System.out.print("Please enter the Roll no. to delete : ");
		stud.setRollno(sc.nextInt());
		sc.nextLine();
		
		Connection connection;
		try {
			connection = ConnectionConfig.getConnection();
			PreparedStatement pstmt = connection.prepareStatement("delete from student where rollno=?");
			pstmt.setInt(1, stud.getRollno());
			int rowsUpdated = pstmt.executeUpdate();
			System.out.println(rowsUpdated + " row(s) updated.");
			ConnectionConfig.close();
		} catch (ClassNotFoundException | SQLException e1) {
			System.out.print(e1);
			System.out.printf("Error connecting to the database.", e1);
		}
	}

	@Override
	public void showAllStudent() {
		Connection connection;
		try {
			connection = ConnectionConfig.getConnection();
			Statement stmt = connection.createStatement(); 
			ResultSet rs = stmt.executeQuery("select * from student");
			
			System.out.println("Result of your query: ");
			while(rs.next())
				System.out.println(rs.getInt(1) + " - " + rs.getString(2) + " - " + rs.getInt(3));
			ConnectionConfig.close();
		} catch (ClassNotFoundException | SQLException e1) {
			System.out.printf("Error connecting to the database.", e1);
		}
		
	}
	
}
