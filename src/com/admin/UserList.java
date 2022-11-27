package com.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserList {

	public void userdata()throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration", "root", "1234");
	     
		Statement statement = Con.createStatement();
		
		ResultSet rs= statement.executeQuery("select * from userregistration");
		
		while (rs.next()) {
			
			System.out.println("FirstName =" + rs.getString(2)+" | " +  "Surname =" + rs.getString(3)+ " | " + "Mobile Number =" + rs.getString(4)+" | " + "Email id =" + rs.getString(5) +" | " + " Username =" + rs.getString(6)+ " | " +"Password =" + rs.getString(7) );
		
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		}
		
		Con.close();
		
		rs.close();
		
		statement.close();
			
		}

	}


