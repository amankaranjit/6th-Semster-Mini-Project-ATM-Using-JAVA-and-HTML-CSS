//package com.aadimcollege.servlet;
//
//import com.aadimcollege.db.JDBCConnection;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.Properties;
//import java.util.Random;
//
//import javax.mail.Authenticator;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.AddressException;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import javax.activation.DataHandler;
//import javax.servlet.annotation.MultipartConfig;
//
///**
// *
// * @author Suprim Poudel
// */
//@MultipartConfig
//public class EmailSenderr extends HttpServlet {
//
//    private static String myAccountEmail = "aadimprojectbank@gmail.com";
//    private static String myAccountPassword = "!@#$qwer";
//
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            boolean status;
//
//            String receipent = request.getParameter("email");
//            String name = request.getParameter("first_name");
//            String mailTitle = request.getParameter("mail_title");
//            String mailContent = request.getParameter("mail_content");
//
//            Connection cn = JDBCConnection.getConnection();
//
//            Properties properties = new Properties();
//
//            properties.put("mail.smtp.auth", "true");
//            properties.put("mail.smtp.starttls.enable", "true");
//            properties.put("mail.smtp.host", "smtp.gmail.com");
//            properties.put("mail.smtp.port", "587");
//
//            Session session = Session.getInstance(properties, new Authenticator() {
//                @Override
//                protected PasswordAuthentication getPasswordAuthentication() {
//                    return new PasswordAuthentication(myAccountEmail, myAccountPassword);
//                }
//            });
//            Random rand = new Random();
//            String defCode = "";
//            for (int i = 0; i < 6; i++) {
//                int n = rand.nextInt(10) + 0;
//                defCode += Integer.toString(n);
//            }
//            Message message = prepareMessage(session, myAccountEmail, receipent, name, defCode, mailTitle, mailContent);
//
//            try {
//                Transport.send(message);
//                out.println(defCode);
//            } catch (MessagingException e) {
//                e.printStackTrace();
//                out.println("Error");
//            }
//        }
//
//    }
//
//    private Message prepareMessage(Session session, String myAccountEmail, String receipent, String name, String defCode, String mailTitle, String mailContent) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    
//}
//
//
