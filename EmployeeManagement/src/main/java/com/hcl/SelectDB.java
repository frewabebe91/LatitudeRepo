package com.hcl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String driver = "com.mysql.jdbc.Driver"; 
		String jdbcURL = "jdbc:mysql://localhost:3306/employees";
		String dbusername = "root"; 
		String password = "password"; 
		
	
		
		try { 
			Connection connection = DriverManager.getConnection(jdbcURL, dbusername, password);
			
			String sql = "SELECT * FROM employee";
			Statement statement = connection.createStatement(); 
			ResultSet result = statement.executeQuery(sql); 
			
			while (result.next()) {
				String EmpName = result.getString(2); 
				
				System.out.println(EmpName); 
			}
			
			
			connection.close(); 
			
			}  catch (SQLException ex) { 
				 ex.printStackTrace(); 
			}

	}

}