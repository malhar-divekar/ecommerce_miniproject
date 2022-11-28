package com.Ecommerce.Productpurchase;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Purchase {
	private String userName;
	
	
	
	


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		System.out.println("setting user name "+userName);
		this.userName = userName;
	}


	void productview()throws ClassNotFoundException, SQLException {
		
		//load driver 
	
	Class.forName("com.mysql.cj.jdbc.Driver");

	// create connection
	Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "1234");

	//create statement
	
	Statement P = Con.createStatement();
	
	//executequery

	ResultSet rs = P.executeQuery("select * from product");
	
	//show all products from Ecommerence
	System.out.println("productid\tproductname\t\tDescription\t\tprice");
	while(rs.next()) {
		
		System.out.println( rs.getInt(1)+"\t\t"  + rs.getString(2)+"\t\t" + rs.getString(3)+"\t\t" + rs.getInt(5));
			
	}
	
	}
	
	
	//Add to cart method
	
	public void AddToCart()throws ClassNotFoundException, SQLException, IOException {
		Purchase purchase = new Purchase();
		
		purchase.productview();
		
	while(true) {	
	
	Scanner S = new Scanner(System.in);
	
    //Load driver & Get connection & prepareStatement
	
	Class.forName("com.mysql.cj.jdbc.Driver");

	Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "1234");
	
	//PreparedStatement p = Con.prepareStatement("insert into cart(productid,name,description,Price) select productid,name,description,Price from product where name = ?");
	
	//UserData user=new UserData();
	System.out.println("for checking "+purchase.getUserName());
	PreparedStatement p = Con.prepareStatement("insert into user_cart(product_id,user_no)  from product where name = ? ");
    
	System.out.println("Enter Productname to add to cart" + "   >>  "+ "To calculate Bill,Please relogin :"  );
	
	System.out.println();
	
	String H =S.nextLine();
	
	p.setString(1, H);
	

	p.executeUpdate();
	 
	System.out.println("Product added to cart");
	
	Con.close();
	p.close();
	 
	
	
	}
	
}
}
