package com.Ecommerce.Productpurchase;

import java.awt.List;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.Ecommerce.Registraton_user.UserRegistrationForm;
import com.admin.ProductQuantity;
import com.admin.UserHistory;
import com.admin.UserList;



public class Login {
	
	

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		//UserRegistrationForm userRegistrationForm1 = new UserRegistrationForm();
		
		//userRegistrationForm1.registerform();
		

		System.out.println("Welcome to our ECommerece Website");
		

		Scanner S = new Scanner(System.in);
		
		//load driver class & get connection & create Statement 

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration", "root", "1234");

		Statement P = Con.createStatement();
		
		//select data of registered user

		//ResultSet rs = P.executeQuery("select * from userregistration where username=? and password=?");
		

		//while(rs.next()) {
			
			//String dataBaseUsername=rs.getNString(6);
			//String dataBasePassword=rs.getNString(7);
			//take username from user 
		
			
			System.out.println("Enter your Username: ");

			String username = S.nextLine();
			
			//take Password from user
			
			System.out.println("Enter your Password: ");

			String Password = S.nextLine();
			
			//ResultSet rs = P.executeQuery("select * from userregistration where username=? and password=?");
			//PreparedStatement ps=ps.setString(1, "Username");
			PreparedStatement ps= Con.prepareStatement("select UserNo,Username,Password from userregistration where Username=? and Password=?");
           
			ps.setString(1, username);
            ps.setString(2, Password);
           ResultSet rs=ps.executeQuery();
           boolean success=false;
           while(rs.next()) {
        	   success=true;
        	   Purchase purchase=new Purchase();
        	   System.out.println("in result set user value:"+rs.getString(2));
        	   purchase.setUserName(rs.getString(2));
        	   System.out.println("..............");
           //System.out.println(rs.getString(1));
          
           }
			//compare input & database data to verify user details 
			
			//if user information is verified , then allow user to use website
			
			//if ((username.equals(rs.getString(6))) && (Password.equals(rs.getString(7))))
			   if(success){                                                                   {

				System.out.println("Welcome to HomePage,Enjoy your Shopping");
				
				System.out.println("Press Enter to continue");
				
				System.in.read();
			
				//create option for selection of usage
				
				System.out.println("Select any option below to continue Shopping:");
				
				System.out.println("Enter 1: Select & add product to cart");
				
				System.out.println("Enter 2: Calculate your Bill amount");
				
				System.out.println("Enter 3: Admin Section");
				
				
				int Option = S.nextInt();
				
				switch(Option) {
				case 1:
					Purchase purchase = new Purchase();
					
					purchase.AddToCart();
				    
					break;
					
				case 2:
					
					CalculateTotal calculateTotal = new CalculateTotal();
					
					calculateTotal.TotalBill();
					break;
				
					//admin option for usage
				case 3:
					
					System.out.println("Select any option to get information");
					
					System.out.println("Enter 1: To see Product Quantity ");
					
					System.out.println("Enter 2: To see User Purchase History");
					
					System.out.println("Enter 3: To see UserRegistered List");
					
					int option = S.nextInt();
					
					switch(option) {
					
					case 1: 
						ProductQuantity productQuantity =new ProductQuantity();
						
						productQuantity.checkQuantity();
						
						break;
					
					case 2:
						
						UserHistory userhistroy = new UserHistory();
						
						userhistroy.userPurchaseData();
						
						break;
						
					case 3:
						UserList userList = new UserList();
						
						userList.userdata();
						
						break;
						
					default:
						
						System.out.println("Please Select Correct Option");
					}
					
				}
			    }
			    }
			//if user is not verified , then allow user to register	
				
			 else {
				System.out.println("Please check your UserName & Password or register yourself");
				
				System.out.println("Enter 1 : To register yourself ");
				
				int reg = S.nextInt();
				
				switch(reg) {
				case 1:
					UserRegistrationForm userRegistrationForm = new UserRegistrationForm();
					
					userRegistrationForm.registerform();
					
					break;
					
				default:
					
					System.exit(0);
					
				
				}
				
			}

		}

	}

	


	



