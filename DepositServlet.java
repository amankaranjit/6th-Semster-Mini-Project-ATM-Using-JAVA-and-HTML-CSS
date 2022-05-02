package com.aadimcollege.servlet;

import com.aadimcollege.db.JDBCConnection;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DepositServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Connection cn = JDBCConnection.getConnection();

        PrintWriter out = response.getWriter();

        String cash = request.getParameter("cash");
        String remarks = request.getParameter("remarks");
        if (cash.isEmpty() || remarks.isEmpty()) {
            RequestDispatcher rd = request.getRequestDispatcher("deposit.jsp");
            rd.include(request, response);
            out.println("<h2>Please fill all the fields.<h2>");
            System.out.println("failed");
        } else {
            //converting into integer        
            int icash = Integer.parseInt(cash);
            try {
                String Name = "";
                HttpSession session = request.getSession(false);
                String acnoo = (String) session.getAttribute("accountNo");

                Statement stmt = cn.createStatement();
                ResultSet rs = stmt.executeQuery("select * from users where accountNo = " + acnoo);
                while (rs.next()) {
                    Name = rs.getString("name");
                }
                System.out.println(acnoo);
                System.out.println(Name);
                System.out.println(icash);
                System.out.println(remarks);

                String insertQuery;
                insertQuery = "INSERT INTO transactions (accountNo, amount, depositorName, remarks, status) VALUES(?, ?,?,?, ?)";
                PreparedStatement pstm = cn.prepareStatement(insertQuery);
                pstm.setString(1, acnoo);
                pstm.setInt(2, icash);
                pstm.setString(3, Name);
                pstm.setString(4, remarks);
                pstm.setString(5, "credit");
                pstm.executeUpdate();

                String updateQuery;
                updateQuery = "UPDATE users SET cash = cash+'" + icash + "' WHERE accountNo = '" + acnoo + "'";
                cn.prepareStatement(updateQuery).execute();
                RequestDispatcher rd = request.getRequestDispatcher("deposit.jsp");
                rd.include(request, response);
                out.println("<h2>Deposit Successfull.<h2>");
                System.out.println("success");
            } catch (Exception e) {
                System.out.println("False");
            }
        }
    }
}
