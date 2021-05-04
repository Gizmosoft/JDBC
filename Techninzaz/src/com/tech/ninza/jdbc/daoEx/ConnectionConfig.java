package com.tech.ninza.jdbc.daoEx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionConfig {
	public static final String URL = "jdbc:mysql://localhost:3306/testdb";
    public static final String USER = "root";
    public static final String PASS = "admin";
    
    public static Connection conn;
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
    	Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(URL, USER, PASS);
		return conn;
    }
    
//	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		Connection connection = ConnectionConfig.getConnection();
//	}
    public static void close() throws SQLException{
    	if(conn != null)
			conn.close();
    }
}
