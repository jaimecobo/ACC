package edu.acc.java;

import java.io.UnsupportedEncodingException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.DatatypeConverter;

import org.jboss.resteasy.client.jaxrs.internal.ClientResponse;

//import org.glassfish.jersey.client.ClientResponse;
//import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

/**
 * Servlet implementation class ServletMailGun
 */
public class MailGunTest {
	
	private static final String MAILGUN_ID = "api";
	private static final String MAILGUN_KEY = "<mailgun key>";

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();

		Form reqData = new Form();
		reqData.param("from", "Dude <admin@bsaclimbing.org>");
		reqData.param("to", "pvi6744@gmail.com");
		reqData.param("subject", "Test Message X");
		reqData.param("text", "test!");

		WebTarget mailgun = client.target("https://api.mailgun.net/v3");
		mailgun.path("/{domain}/messages")
		       .resolveTemplate("domain", "bsaclimbing.org")
			   .request(MediaType.APPLICATION_FORM_URLENCODED)
			   .header("Authorization", getBasicAuthentication(MAILGUN_ID, MAILGUN_KEY))
			   .buildPost(Entity.entity(reqData, 
						MediaType.APPLICATION_FORM_URLENCODED))
			   .invoke();
//			   .invoke(ClientResponse.class);
		System.out.print("Dude, message sent!");
		client.close();
	}
	
	private static String getBasicAuthentication(String user, String password) {
        String token = user + ":" + password;
        try {
            return "Basic " +
                 DatatypeConverter.printBase64Binary(token.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            throw new IllegalStateException("Cannot encode with UTF-8", ex);
        }
    }

}