package com.aptech.controllers.mail;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class JavaMailDemo {
    public static void main(String[] args) {
        final String username = "yourEmailAddress@gmail.com";//modify
        final String password = "yourPassword";//modify

        /* do not modify*/
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        /*-----------------------*/

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password); // modify
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("example@gmail.com"));//modify
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("toAddress@gmail.com")//modify
            );
            message.setSubject("Testing Gmail TLS");//modify
            message.setText("Dear Mail Crawler,"
                    + "\n\n Please do not spam my email!");//modify

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
