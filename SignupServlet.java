package com.aadimcollege.servlet;

import com.aadimcollege.db.JDBCConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignupServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Connection cn = JDBCConnection.getConnection();

        PrintWriter out = response.getWriter();
        String fname = request.getParameter("fname");
        String address = request.getParameter("address");
        String contactNo = request.getParameter("contact");
        String dob = request.getParameter("dob");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");

        if (fname.isEmpty() || address.isEmpty() || contactNo.isEmpty() || dob.isEmpty() || email.isEmpty() || gender.isEmpty()) {
            RequestDispatcher rd = request.getRequestDispatcher("signUp.html");
            rd.include(request, response);
            out.println("<h2>Please fill all the fields.<h2>");
            System.out.println(" Empty failed");
        } else {

            try {
                String insertQuery;
                insertQuery = "INSERT INTO newusers (fname, address, dob, email,gender,contactNo) VALUES(?, ?, ?, ?, ?,?)";
                PreparedStatement stm = cn.prepareStatement(insertQuery);
                stm.setString(1, fname);
                stm.setString(2, address);
                stm.setString(3, dob);
                stm.setString(4, email);
                stm.setString(5, gender);
                stm.setString(6, contactNo);
                stm.executeUpdate();

                //Generating random accountNo
                Integer minn = 0000000000;
                Integer maxx = 1000000000;

                Integer accountNoo = (int) Math.floor(Math.random() * (maxx - minn + 1) + minn);
                String accountNo = accountNoo.toString();
                //Generating random pin Number
                int min = 1000;
                int max = 10000;
                int cash = 0;
                Integer pinnumber = (int) Math.floor(Math.random() * (max - min + 1) + min);
                String updateQuery;
                String pinNumber = pinnumber.toString();
                updateQuery = "INSERT INTO users (accountNo,pinNumber,name,cash)  values(?,?,?,?)";
                PreparedStatement pstmt = cn.prepareStatement(updateQuery);
                pstmt.setString(1, accountNo);
                pstmt.setString(2, pinNumber);
                pstmt.setString(3, fname);
                pstmt.setInt(4, cash);
                pstmt.executeUpdate();


                RequestDispatcher rd = request.getRequestDispatcher("signUp.jsp");
                rd.include(request, response);
                out.println("<h2>Signup Successfull.<h2>");
                System.out.println("Insert Successfull");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Insert Failed");
            }
        }
    }
}
