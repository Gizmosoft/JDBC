package com.tech.ninza.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.tech.ninza.jdbc.util.JdbcUtil;


public class JdbcInsertUsingPreparedStatement {
	public static String insertQuery = "insert into student values (?,?)";

	public static void main(String[] args) {
		try {
			Connection conn = JdbcUtil.getConnection();
			insertStudent(conn);
			
			JdbcUtil.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

	public static void insertStudent(Connection conn) throws Exception {
		PreparedStatement pstmt = conn.prepareStatement(insertQuery);
		pstmt.setInt(1, 6);
		pstmt.setString(2, "RANDOM");
		int rowsUpdated = pstmt.executeUpdate();
		
		System.out.println(rowsUpdated + " row(s) updated.");
		
	}

}
