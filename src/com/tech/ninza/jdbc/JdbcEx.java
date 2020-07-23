package com.tech.ninza.jdbc;

import java.sql.*;



public class JdbcEx {

	public static void main(String[] args) throws Exception{
		
		try {
			//Class.forName("oracle.jdbc.OracleDriver");
			Class.forName("com.mysql.cj.jdbc.Driver");			//new driver
			
			Connection conn = DriverManager.getConnection(
					//Oracle Connector
					//"jdbc:oracle:thin:SYSTEM/SYSTEM@localhost:1521:productcatal", "system", 					  "Password123" );
					//"jdbc:oracle:thin:SYSTEM/SYSTEM@localhost:1521:admin", "system", "admin");

					//MySQL connector
					"jdbc:mysql://localhost:3306/testdb","root","admin"		//	can be added after testdb-> ?useSSL=false
			);
			

			Statement stmt=conn.createStatement(); 
			
			ResultSet rs=stmt.executeQuery("select * from student");
//			ResultSet rs=stmt.executeQuery("select * from student where rollno='2'");
			while(rs.next())
//				System.out.println(rs.getString(2));
				System.out.println(rs.getInt(1)+"  "+rs.getString(2));
			  
			stmt.close();
			conn.close();  
			  
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
