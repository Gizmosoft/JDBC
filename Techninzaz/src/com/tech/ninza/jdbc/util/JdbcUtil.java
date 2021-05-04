package com.tech.ninza.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public  class JdbcUtil {

	public static Connection conn;
	public static PreparedStatement pstmt;
	
	public static Connection getConnection() throws Exception {
		// For MySQL Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb?useSSL=false","root","admin");
		
		return conn;
			
		// For Oracle Driver
		/*
			Class.forName("oracle.jdbc.OracleDriver");
			
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:SYSTEM/SYSTEM@localhost:1521:productcatal", "system", "Password123" );

			return conn;
		*/

	}
	
	public static void close() throws SQLException{
		if(conn != null)
			conn.close();
		if(pstmt != null)
			pstmt.close();
		
	}

}
