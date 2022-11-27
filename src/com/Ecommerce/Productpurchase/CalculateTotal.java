package com.Ecommerce.Productpurchase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Calculate Total Bill
 

public class CalculateTotal {
	
	public void TotalBill()throws ClassNotFoundException, SQLException {
		
		//load Driver class & create connection 
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "1234");
         
		// create statement
		
		Statement S= Con.createStatement();
		
		//execute query
		
		ResultSet rs= S.executeQuery("select Sum(Price) from ecommerce.cart");
		
		//print total bill amount
		
		while(rs.next()) {
       
		System.out.println("Your total Bill Amount: " + rs.getInt(1));
		}
		
}
}