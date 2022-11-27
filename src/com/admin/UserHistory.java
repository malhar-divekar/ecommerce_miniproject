package com.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserHistory{

	public void userPurchaseData()throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "1234");

		Connection C = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration", "root", "1234");

		Statement S = Con.createStatement();

		Statement stm = C.createStatement();

		ResultSet rs = S.executeQuery("select * from cart");

		ResultSet r = stm.executeQuery("select name,Lastname from userregistration where UserNo =2");

		while (r.next()) {

			System.out.println("Customer Name >> " + r.getString(1) + " " + r.getString(2));

			System.out.println("Customer Purchase details as below: ");

			System.out.println("----------------------------------------------------------");
		}

		while (rs.next()) {

			System.out.println("Productid" + " " + rs.getInt(1) + " " + "Product Name " + " " + rs.getString(2) + "  "
					+ "Price " + rs.getString(5));

		}

		Con.close();
		S.close();
		rs.close();

	}

}
