package com.Ecommerce.Registraton_user;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UserRegistrationForm{

	public void registerform() throws ClassNotFoundException, SQLException {
		
		System.out.println("Welcome to our website. Please register yourself to use enjoy our service");
		
		//Driver loading & create connection & prepare Statement
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection Con= DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","1234");
		
		PreparedStatement P= Con.prepareStatement("insert into Userregistration values(?,?,?,?,?,?)");
		
		//Take input from user & register into database
		
		Scanner s=new Scanner(System.in);
		
		//System.out.println("Enter your registration id: ");
		
		//int reg = s.nextInt();
		
		//take firstname from user;
		
		//P.setInt(1, reg);
		
		System.out.println("Enter your name: ");
		
		String name = s.next();
		
		P.setString(1, name);
		
		//take lastname from user;
		
		System.out.println("Enter your Lastname: ");
		
		String Lname = s.next();
		
		P.setString(2, Lname);
		
		//take mobile number from user
		
		System.out.println("Enter your Mobile Number: ");
		
		String Mob = s.next();
		
		P.setString(3, Mob);
		
		//take email from user
		
		System.out.println("Enter your Email: ");
		
		String Email = s.next();
		
		P.setString(4, Email);
		
		//take username from user 
		
		System.out.println("Enter your Username: ");
		
		String Username = s.next();
		
		P.setString(5, Username);
		
		//take password from user
		
		System.out.println("Enter your Password: ");
		
		String Password = s.next();
		
		P.setString(6, Password);
		
		//execute query
		try {
		P.executeUpdate();
		
		System.out.println("Thank you for your registration, Please Login to  enjoy our services");
		}
		catch(Exception e) {
			System.err.println("you are already being registered with this:"+Email);
		}
		//close connection
		
		P.close();
		Con.close();

	}

}
