package com.aadimcollege.servlet;

import com.aadimcollege.db.JDBCConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FastCashServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        Connection cn = JDBCConnection.getConnection();
        try {
            String amountToWithdraw = request.getParameter("fastcash");         
            HttpSession session = request.getSession(false);
            String acnoo = (String) session.getAttribute("accountNo");

            int dbcash = 0;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from users where accountNo ="+acnoo);
            while (rs.next()) {
                dbcash = rs.getInt("cash");                
            }
            System.out.println(dbcash);          
            System.out.println(amountToWithdraw);
            if (amountToWithdraw.equals("1000")) {
                int amount = 1000;
                if (amount <= dbcash) {
                    String withdrawQuery = "UPDATE users SET cash = cash-'" + amount + "' WHERE accountNo = '" + acnoo + "'";
                    cn.prepareStatement(withdrawQuery).execute();
                    RequestDispatcher rd = request.getRequestDispatcher("fastCash.jsp");
                    rd.include(request, response);
                    out.print("<h1>Please recieve your amount Rs." + amount + "</h1>");
                    System.out.println("success");
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("fastCash.jsp");
                    rd.include(request, response);
                    out.print("<h1>Insufficient balance</h1>");
                    System.out.println("failed");
                }

            } else if (amountToWithdraw.equals("2000")) {
                int amount = 2000;
                if (amount <= dbcash) {
                    String withdrawQuery = "UPDATE users SET cash = cash-'" + amount + "' WHERE accountNo = '" + acnoo + "'";
                    cn.prepareStatement(withdrawQuery).execute();
                    RequestDispatcher rd = request.getRequestDispatcher("fastCash.jsp");
                    rd.include(request, response);
                    out.print("<h1>Please recieve your amount Rs." + amount + "</h1>");
                    System.out.println("success");
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("fastCash.jsp");
                    rd.include(request, response);
                    out.print("<h1>Insufficient balance</h1>");
                    System.out.println("failed");
                }

            } else if (amountToWithdraw.equals("3000")) {
                int amount = 3000;
                if (amount <= dbcash) {
                    String withdrawQuery = "UPDATE users SET cash = cash-'" + amount + "' WHERE accountNo = '" + acnoo + "'";
                    cn.prepareStatement(withdrawQuery).execute();
                    RequestDispatcher rd = request.getRequestDispatcher("fastCash.jsp");
                    rd.include(request, response);
                    out.print("<h1>Please recieve your amount Rs." + amount + "</h1>");
                    System.out.println("success");
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("fastCash.jsp");
                    rd.include(request, response);
                    out.print("<h1>Insufficient balance</h1>");
                    System.out.println("failed");
                }

            } else if (amountToWithdraw.equals("4000")) {
                int amount = 4000;
                if (amount <= dbcash) {
                    String withdrawQuery = "UPDATE users SET cash = cash-'" + amount + "' WHERE accountNo = '" + acnoo + "'";
                    cn.prepareStatement(withdrawQuery).execute();
                    RequestDispatcher rd = request.getRequestDispatcher("fastCash.jsp");
                    rd.include(request, response);
                    out.print("<h1>Please recieve your amount Rs." + amount + "</h1>");
                    System.out.println("success");
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("fastCash.jsp");
                    rd.include(request, response);
                    out.print("<h1>Insufficient balance</h1>");
                    System.out.println("failed");
                }

            } else if (amountToWithdraw.equals("5000")) {
                int amount = 2000;
                if (amount <= dbcash) {
                    String withdrawQuery = "UPDATE users SET cash = cash-'" + amount + "' WHERE accountNo = '" + acnoo + "'";
                    cn.prepareStatement(withdrawQuery).execute();
                    RequestDispatcher rd = request.getRequestDispatcher("fastCash.jsp");
                    rd.include(request, response);
                    out.print("<h1>Please recieve your amount Rs." + amount + "</h1>");
                    System.out.println("success");
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("fastCash.jsp");
                    rd.include(request, response);
                    out.print("<h1>Insufficient balance</h1>");
                    System.out.println("failed");
                }

            } else if (amountToWithdraw.equals("10000")) {
                int amount = 10000;
                if (amount <= dbcash) {
                    String withdrawQuery = "UPDATE users SET cash = cash-'" + amount + "' WHERE accountNo = '" + acnoo + "'";
                    cn.prepareStatement(withdrawQuery).execute();
                    RequestDispatcher rd = request.getRequestDispatcher("fastCash.jsp");
                    rd.include(request, response);
                    out.print("<h1>Please recieve your amount Rs." + amount + "</h1>");
                    System.out.println("success");
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("fastCash.jsp");
                    rd.include(request, response);
                    out.print("<h1>Insufficient balance</h1>");
                    System.out.println("failed");
                }

            } else if (amountToWithdraw.equals("15000")) {
                int amount = 15000;
                if (amount <= dbcash) {
                    String withdrawQuery = "UPDATE users SET cash = cash-'" + amount + "' WHERE accountNo = '" + acnoo + "'";
                    cn.prepareStatement(withdrawQuery).execute();
                    RequestDispatcher rd = request.getRequestDispatcher("fastCash.jsp");
                    rd.include(request, response);
                    out.print("<h1>Please recieve your amount Rs." + amount + "</h1>");
                    System.out.println("success");
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("fastCash.jsp");
                    rd.include(request, response);
                    out.print("<h1>Insufficient balance</h1>");
                    System.out.println("failed");
                }

            } else if (amountToWithdraw.equals("20000")) {
                int amount = 20000;
                if (amount <= dbcash) {
                    String withdrawQuery = "UPDATE users SET cash = cash-'" + amount + "' WHERE accountNo = '" + acnoo + "'";
                    cn.prepareStatement(withdrawQuery).execute();
                    RequestDispatcher rd = request.getRequestDispatcher("fastCash.jsp");
                    rd.include(request, response);
                    out.print("<h1>Please recieve your amount Rs." + amount + "</h1>");
                    System.out.println("success");
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("fastCash.jsp");
                    rd.include(request, response);
                    out.print("<h1>Insufficient balance</h1>");
                    System.out.println("failed");
                }

            } else {
                RequestDispatcher rd = request.getRequestDispatcher("fastCash.jsp");
                rd.include(request, response);
            }
        } catch (Exception e) {
        }

    }
}
