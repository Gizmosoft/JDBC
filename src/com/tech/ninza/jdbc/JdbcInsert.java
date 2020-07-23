package com.tech.ninza.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.tech.ninza.jdbc.util.JdbcUtil;

public class JdbcInsert {

	public static String insertQuery = "insert into student values (5, 'Ankit')";
	public static String updateQuery = "update student set name='ANKIT' where rollno = 5";
	public static String deleteQuery = "delete from student where rollno = 5";
	
	public static void main(String[] args) {
		
		try {
			Connection conn = JdbcUtil.getConnection();
			updateProduct(conn);
//			deleteProduct(conn, 2);
			
			JdbcUtil.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	

	


	public static void updateProduct(Connection conn) throws Exception {
		Statement stmt = conn.createStatement();
		
		
//		PreparedStatement pstmt = conn.prepareStatement(insertQuery);
//		pstmt.setInt(1, 100);
//		pstmt.setFloat(2,(float) 100.11);
//		pstmt.setString(2, "added");
//		pstmt.setString(4, "Delete this");
//		pstmt.setString(5, "Delete this");
//		pstmt.setString(6, "Delete this");
//		pstmt.setString(7, "Delete this");
		
//		int rowsUpdated = stmt.executeUpdate(insertQuery);
		int rowsUpdated = stmt.executeUpdate(updateQuery);
		
		
		System.out.println(rowsUpdated + " Row(s) Affected");
	}

	private static void deleteProduct(Connection conn, int rollno) throws Exception {
		Statement stmt = conn.createStatement();
//		PreparedStatement pstmt = conn.prepareStatement(deleteQuery);
//		pstmt.setInt(1, rollno);
		int rowsUpdated = stmt.executeUpdate(deleteQuery);
		
		System.out.println(rowsUpdated + " Row(s) Deleted");
	}
	
}

/*
CREATE 		--> INSERT	dml
RETRIEVE 	--> SELECT	dql
UPDATE		--> UPDATE 	dml
DELETE		--> DELETE  dml
*/