package edu.acc.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MailServletA
 */
@WebServlet("/MailServletA")
public class MailServletA extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MailServletA() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		try {
			// set some mail properties...
			Properties props = new Properties();
			props.put("mail.debug.auth", "true");
			props.put("mail.transport.protocol", "smtps");
			props.put("mail.smtps.host", "mail.eaglesrim.com");
			props.put("mail.smtps.port", "587");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.ssl.trust", "*");
			props.put("mail.smtp.starttls.enabled","true");
			// create session with MTA
			//Session session = Session.getDefaultInstance(props,new SMTPSAuth());
			Session session = Session.getInstance(props, new SMTPSAuth());
			session.setDebug(true);
			// create a message and address it
			Message message = new MimeMessage(session);
			message.setSubject("Dude!!");
			message.setText("Powered by JavaMail API");
			message.setFrom(new InternetAddress("peter@isburgh.com"));
			message.setRecipient(Message.RecipientType.TO, 
					             new InternetAddress("peter@isburgh.com"));
			// send
			//Transport transport = session.getTransport(); 
			//transport.connect("smtp", "VictorAlpha83");
			Transport.send(message, "smtp", "VictorAlpha83");
			out.println("sent message");
		}
		catch (MessagingException ex) {
			System.out.println(ex);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}