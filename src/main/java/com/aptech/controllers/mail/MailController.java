package com.aptech.controllers.mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

@WebServlet("/admin/mail")
public class MailController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String toAddress = request.getParameter("to");
        String subject = request.getParameter("subject");
        String messageBody = request.getParameter("message");

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
                    InternetAddress.parse(toAddress)
            );
            message.setSubject(subject);
            message.setText(messageBody);

            Transport.send(message);

            System.out.println("Done");
            response.sendRedirect("/aptechonline/admin/mail");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("mail.jsp").forward(request, response);

    }
}
