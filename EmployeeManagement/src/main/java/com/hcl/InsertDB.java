package com.hcl; 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException; 

public class InsertDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String driver = "com.mysql.jdbc.Driver"; 
		String jdbcURL = "jdbc:mysql://localhost:3306/employees";
		String dbusername = "root"; 
		String password = "password"; 
		
		String EmpID = "4"; 
		String EmpName = "Ruth Chris"; 
		String DOB = "1998-12-12"; 
		String Salary = "35"; 
		String Age = "30"; 
		
		try { 
			Connection connection = DriverManager.getConnection(jdbcURL, dbusername, password);
			
			String sql = "INSERT INTO employee (EmpID, EmpName, DOB, Salary, Age)" 
					+ " VALUES (?, ?, ?, ?, ?)"; 
			
			PreparedStatement statement = connection.prepareStatement(sql); 
			
			statement.setString(1, EmpID);
			statement.setString(2, EmpName);
			statement.setString(3, DOB);
			statement.setString(4, Salary);
			statement.setString(5, Age);
			
			int rows = statement.executeUpdate(); 
			
			if(rows > 0) { 
				System.out.println("A new user has been inserted succesfully");
			}
			connection.close(); 
			
			}  catch (SQLException ex) { 
				 ex.printStackTrace(); 
			}

	}

}
