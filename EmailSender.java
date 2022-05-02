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
//import javax.servlet.RequestDispatcher;
//import javax.servlet.annotation.MultipartConfig;
//
///**
// *
// * @author Suprim Poudel
// */
//@MultipartConfig
//public class EmailSender extends HttpServlet {
//
//    private static String myAccountEmail = "javademo72@gmail.com";
//    private static String myAccountPassword = "Aman@1234";
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
//                RequestDispatcher rd = request.getRequestDispatcher("forgotpin.jsp");
//                rd.include(request, response);
//                out.print("<h1>Email Sending Failed.</h1>");                
//            }
//
//        }
//    }
//
//    private static Message prepareMessage(Session session, String email, String receipent, String name, String otpCode, String title, String body) {
//        try {
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(email));
//            message.setRecipient(Message.RecipientType.TO, new InternetAddress(receipent));
//            message.setSubject(title);
//            String htmlCode = "<img src=\"https://902558.smushcdn.com/2161880/wp-content/uploads/2020/08/man-forgot-his-password_173125-93-626x375.jpg?lossy=1&strip=1&webp=1\" alt=\"" + title + "\"><br/>"
//                    + "<h3>Hello, '" + name + "'</h3><p>" + body + "</p><h3 style=\"text-align:center;\">'" + otpCode + "'</h3><p>Use this code within 2 minutes or else it will expire</p><br/><p>Best Regards,</p><p>Aadim Bank</p>";
//            message.setContent(htmlCode, "text/html");
//            return message;
//        } catch (AddressException e) {
//            e.printStackTrace();
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}
