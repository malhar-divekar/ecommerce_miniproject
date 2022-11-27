package com.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ProductQuantity {
	
	public void checkQuantity()throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "1234");

		PreparedStatement P =Con.prepareStatement("select Quantity from product where productid = ?");
		
		Scanner S = new Scanner(System.in);
		
		System.out.println("Enter ProductId to know Quantity of Product");
		
		int productId = S.nextInt();
		
		P.setInt(1, productId);
		
		ResultSet rs= P.executeQuery();
		
		while(rs.next()) {
			
			System.out.println("Product Quantity for " + productId + " is = "+ rs.getInt(1));
		}
		
		P.close();
		
		rs.close();
		
		Con.close();
		
		
	}

}
