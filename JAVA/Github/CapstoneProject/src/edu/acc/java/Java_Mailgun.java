package edu.acc.java;

//import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		        PreparedStatement pst = conn.prepareStatement("Select email from customer where id_customer=?");
		        pst.setString(1, id_Customer);
		        ResultSet rs = pst.executeQuery();
		        if (rs.next()) {
		           recipient = rs.getString(1);
		           System.out.println("The Recipient is: " + recipient);
//		           sendSimpleMessage(recipient);
		           sendComplexMessage(recipient);
		           
		        	

		    }
		 }
			catch (ClassNotFoundException | SQLException ex) {
		        	System.out.println("ERROR in Catch SELECT IN MAILGUN");
		        	ex.printStackTrace();
		    }
		}
	      
	  
	  private ClientResponse sendSimpleMessage(String recipient) {

	    Client client = Client.create();
	    client.addFilter(new HTTPBasicAuthFilter("api", MAILGUN_API_KEY));
	    WebResource
	    return webResource.type(MediaType.APPLICATION_FORM_URLENCODED).post(ClientResponse.class,
	        formData);
	  }
	
}