package com.accenture.lkm.empapp.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtility {

	private static String userName = "root";
	private static String password = "root";
	private static String connectionUrl = "jdbc:mysql://localhost:3306/jdbctest";
	private static Connection con;

	public static Connection getDBConnection() throws SQLException {
		con = DriverManager.getConnection(connectionUrl, userName, password);
		return con;
	}

}
