package com.ogya.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String DB_USERNAME = "training";
	private final String DB_PASSWORD = "training";
	
	private Connection connection;
	
	public Connection getConnection() throws Exception {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriverX");
			connection =  DriverManager.getConnection(JDBC_URL, 
							DB_USERNAME, 
							DB_PASSWORD);
			if(connection != null){
				System.out.println("Connected");
			}
			else{
				throw new Exception("Failed to connect");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
