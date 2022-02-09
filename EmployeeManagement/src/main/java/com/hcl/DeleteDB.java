package com.hcl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String driver = "com.mysql.jdbc.Driver"; 
		String jdbcURL = "jdbc:mysql://localhost:3306/employees";
		String dbusername = "root"; 
		String password = "password"; 
		
		String EmpName = "John Doe"; 
		
		try { 
			Connection connection = DriverManager.getConnection(jdbcURL, dbusername, password); 
			
			String sql = "DELETE FROM employee WHERE EmpName=?"; 
			PreparedStatement statement = connection.prepareStatement(sql); 
			statement.setString(1, EmpName);
			
			int rows = statement.executeUpdate(); 
			
			if(rows > 0) { 
				System.out.println("The user has been deleted");
			}
			connection.close(); 
			
			}  catch (SQLException ex) { 
				 ex.printStackTrace(); 
			}
		

	}

}
