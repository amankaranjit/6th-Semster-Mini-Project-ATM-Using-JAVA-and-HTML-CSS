package com.aadimcollege.servlet;

import com.aadimcollege.db.JDBCConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        Connection cn = JDBCConnection.getConnection();
        PrintWriter out = response.getWriter();

        String accountNo = request.getParameter("accountNo");
        String pinNumber = request.getParameter("pinNumber");
        HttpSession session = request.getSession();
        session.setAttribute("accountNo", accountNo);
        try {
            if (pinNumber.isEmpty() || accountNo.isEmpty()) {
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.include(request, response);
                out.print("<h1>Please fill up all the fields.</h1>");
                System.out.println("false");
            } else {
                String anoo = (String) session.getValue("accountNo");
                System.out.println(anoo);
                Statement stmt = cn.createStatement();
                ResultSet rs = stmt.executeQuery("select * from users where accountNo =" + anoo);
                String pinnumber;
                while (rs.next()) {
                    pinnumber = rs.getString("pinNumber");
                    if (pinnumber.equals(pinNumber)) {
                        session.setAttribute("accountNo", accountNo);
                        RequestDispatcher rddd = request.getRequestDispatcher("menu.jsp");
                        rddd.include(request, response);
                        System.out.println("True");
                        out.print("<h1>Login Successfull</h1>");

//                    } else {
//                        RequestDispatcher rd = request.getRequestDispatcher("index.html");
//                        rd.forward(request, response);
//                        System.out.println("false");
//                        out.print("<h1>Login Failed</h1>");
//                    }
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
