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

public class PinChangeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        Connection cn = JDBCConnection.getConnection();
        String oldPin = request.getParameter("opin");
        String newPin = request.getParameter("npin");

        if (oldPin.isEmpty() || newPin.isEmpty()) {
            RequestDispatcher rd = request.getRequestDispatcher("pinChange.jsp");
            rd.include(request, response);
            out.println("<h2>Please fill all the fields.<h2>");
            System.out.println("failed");
        } else {
            try {
                HttpSession session = request.getSession(false);
                String acnoo = (String) session.getAttribute("accountNo");

                Statement stmt = cn.createStatement();
                ResultSet rs = stmt.executeQuery("select * from users where accountNo = " + acnoo);
                while (rs.next()) {
                    String pinnumber = rs.getString("pinNumber");
                    if (oldPin.isEmpty() || newPin.isEmpty()) {
                        RequestDispatcher rd = request.getRequestDispatcher("pinChange.jsp");
                        rd.include(request, response);
                        out.print("<h1>Please fill all the fields.</h1>");

                    } else if (pinnumber.equals(oldPin)) {
                        String updateQuery = "UPDATE users SET pinNumber = '" + newPin + "' WHERE accountNo = '" + acnoo + "'";
                        cn.prepareStatement(updateQuery).execute();
                        RequestDispatcher rd = request.getRequestDispatcher("pinChange.jsp");
                        rd.include(request, response);
                        out.print("<h1>Pin Changed Successfully.</h1>");
                        System.out.println("True");
                    } else {
                        RequestDispatcher rd = request.getRequestDispatcher("pinChange.jsp");
                        rd.include(request, response);
                        System.out.println("false");
                        out.print("<h1>Incorrect Pin Number</h1>.");
                    }
                }

            } catch (Exception e) {
            }
        }
    }
}
