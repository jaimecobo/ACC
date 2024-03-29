package edu.acc.java;

//import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Java_Mailgun {
	
		private static final String MAILGUN_DOMAIN_NAME = "sandboxba654c3607224f489582c989d20d5dfe.mailgun.org";
		private static final String MAILGUN_API_KEY = "key-b223b5ff8347e127f711b64b70dc5de9";
		
		
		String recipient;
		String id_Reservation;
		String entry_Date;
		String departure_Date;
		String balance;

		
		protected Java_Mailgun() {
			super();
			// TODO Auto-generated constructor stub
		}

	
		protected void sendEmail(String id_Customer) {
			System.out.println("Starting sendEmail at Java_Mailgun");
		 
		 try {
				Class.forName("com.mysql.jdbc.Driver");
		        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotels360", "root", "sesame");
		        PreparedStatement pst = conn.prepareStatement("")
	
		 }
			catch (ClassNotFoundException | SQLException ex) {
		        	System.out.println("ERROR in Catch SELECT IN MAILGUN");
		        	ex.printStackTrace();
		    }
		}
	
}