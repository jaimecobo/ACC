package edu.acc.java;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.file.FileDataBodyPart;

import java.io.File;
//import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;

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
	    WebResource webResource = client.resource("https://api.mailgun.net/v3/" + MAILGUN_DOMAIN_NAME
	        + "/messages");
	    MultivaluedMapImpl formData = new MultivaluedMapImpl();
	    formData.add("from", "Mailgun User <mailgun@" + MAILGUN_DOMAIN_NAME + ">");
	    formData.add("to", recipient);
	    formData.add("subject", "Simple Mailgun Example");
	    formData.add("text", "Plaintext content");
	    return webResource.type(MediaType.APPLICATION_FORM_URLENCODED).post(ClientResponse.class,
	        formData);
	  }
	  

	 
	  private ClientResponse sendComplexMessage(String recipient) {
	    Client client = Client.create();
	    client.addFilter(new HTTPBasicAuthFilter("api", MAILGUN_API_KEY));
	    WebResource webResource = client.resource("https://api.mailgun.net/v3/" + MAILGUN_DOMAIN_NAME
	        + "/messages");
	    FormDataMultiPart formData = new FormDataMultiPart();
	    formData.field("from", "Mailgun User <mailgun@" + MAILGUN_DOMAIN_NAME + ">");
	    formData.field("to", recipient);
	    formData.field("subject", "Complex Mailgun Example");
	    formData.field("html", "<html><h2 style =\"color:blue\">Thank you for your reservation.</h2>"
	    				+ "<h4>To check the status of your reservation, visit our website: <a href=\"http://localhost:8084/Hotels360/01_index.jsp\">Apartments 365</a></h4></html>");
//	    ClassLoader classLoader = getClass().getClassLoader();
//	    File txtFile = new File(classLoader.getResource("example-attachment.txt").getFile());
//	    formData.bodyPart(new FileDataBodyPart("attachment", txtFile, MediaType.TEXT_PLAIN_TYPE));
	    return webResource.type(MediaType.MULTIPART_FORM_DATA_TYPE)
	        .post(ClientResponse.class, formData);
	  }
	
}