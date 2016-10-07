package com.arman.services;
// use to test connection, delete later @arman
import java.sql.Connection;
import java.sql.DriverManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.arman.entity.Menus;

public class JDBCTest {

	public static void main(String[] args) {

		String jdbcURL = "jdbc:mysql://localhost:3306/newschema?useSSL=false";
		String user = "arman";
		String password = "arman";
		
		
		try{
			System.out.println("connecting to database: "+jdbcURL);
			Connection conn = DriverManager.getConnection(jdbcURL,user,password);
			System.out.println("connection success!");
			
			Menus menu = new Menus();
			Menus tempMenu = new Menus();
			tempMenu.setMenu_id(2);
			tempMenu.setName("Gelen vagen");
		// create session factory
				SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Menus.class)
										.buildSessionFactory();
				
				// create session
				Session session = factory.getCurrentSession();
				
				try {			
					
					// start a transaction
					session.beginTransaction();
					
					
					// commit transaction
					session.getTransaction().commit();
					
					// MY NEW CODE
					
					// now get a new session and start transaction
					session = factory.getCurrentSession();
					session.beginTransaction();
					
					
					menu = session.get(Menus.class, 1);
//					session.save(tempMenu);
					
					// commit the transaction
					session.getTransaction().commit();
					System.out.println("Name is "+menu.getName());
					System.out.println("Done!");
				}
				finally {
					factory.close();
				}
			
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
