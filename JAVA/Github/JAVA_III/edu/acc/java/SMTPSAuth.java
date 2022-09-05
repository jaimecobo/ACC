package edu.acc.java;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * For MailServletA SMTPS authentication
 * @author pi
 *
 */
public class SMTPSAuth extends Authenticator {
    public PasswordAuthentication getPasswordAuthentication() {
       String username = "smtp";
       String password = "VictorAlpha83";
       return new PasswordAuthentication(username, password);
    }
}