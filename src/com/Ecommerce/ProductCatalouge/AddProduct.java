package com.Ecommerce.ProductCatalouge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddProduct {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
	
		
	for (int i=0; i<=10;i++) {
		
		Scanner S = new Scanner(System.in);
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection Con= DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "1234");
		
		PreparedStatement P= Con.prepareStatement("insert into product values(?,?,?,?,?)");
		
		System.out.println("Enter Product id: ");
		
		int id = S.nextInt();
		
		P.setInt(1, id);
		
		System.out.println("Enter Product name: ");
		
		String name = S.next();
		
		P.setString(2, name);
		
		System.out.println("Enter Product description: ");
		
		String des = S.next();
		
		P.setString(3, des);
		
		System.out.println("Enter Product quantity: ");
		
		int quantity = S.nextInt();
		
		P.setInt(4, quantity);
		
		System.out.println("Enter Product Price: ");
		
		int Price = S.nextInt();
		
		P.setInt(5, Price);
		
		int o = P.executeUpdate();
		
		System.out.println("Product Added........ " + o);
		
		P.close();
		Con.close();	
	}
		
		
	}

}
