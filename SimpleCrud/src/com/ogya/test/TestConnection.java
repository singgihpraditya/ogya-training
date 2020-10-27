package com.ogya.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
	public static void main(String[] args){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = 
					DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", 
							"training", 
							"training");
			if(connection != null){
				System.out.println("Connected");
			}
			else{
				System.out.println("Failed to connect");
			}
			connection.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Error : "+e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error : "+e.getMessage());
			e.printStackTrace();
		}
	}
}
