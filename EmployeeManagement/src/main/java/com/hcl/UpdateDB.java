package com.hcl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		String driver = "com.mysql.jdbc.Driver"; 
		String jdbcURL = "jdbc:mysql://localhost:3306/employees";
		String dbusername = "root"; 
		String password = "password"; 
		
		String EmpID = "3"; 
		String EmpName = "Carlito Vega"; 
		String DOB = "1980-05-02"; 
		String Salary = "25"; 
		String Age = "42"; 
		
		try { 
			Connection connection = DriverManager.getConnection(jdbcURL, dbusername, password); 
				String sql = "UPDATE employee SET EmpID=?, WHERE EmpName=?, DOB=?, Salary=?, Age=?"; 
			
			PreparedStatement statement = connection.prepareStatement(sql); 
			statement.setString(1, EmpID);
			statement.setString(2, EmpName);
			statement.setString(3, DOB);
			statement.setString(4, Salary);
			statement.setString(5, Age);
			
			int rows = statement.executeUpdate(); 
			
			if(rows > 0) { 
				System.out.println("The user has been updated succesfully");
			}
			connection.close(); 
			
			}  catch (SQLException ex) { 
				 ex.printStackTrace(); 
			}

	}

}
