
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

public class DepositWithoutLoginServlet extends HttpServlet {

 protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Connection cn = JDBCConnection.getConnection();

        PrintWriter out = response.getWriter();
        String depositorName = request.getParameter("depositorname");
        String accountNoo = request.getParameter("accountNo");
        String cash = request.getParameter("cash");
        String remarks = request.getParameter("remarks");


        if (depositorName.isEmpty() || accountNoo.isEmpty() || cash.isEmpty() || remarks.isEmpty()) {
            RequestDispatcher rd = request.getRequestDispatcher("depsitwithoutlogin.html");
            rd.include(request, response);
            out.println("<h2>Please fill all the fields.<h2>");
            System.out.println("failed");
        } else {
            //converting into integer        
            int icash = Integer.parseInt(cash);
            try {
                String insertQuery;
                String updateQuery;
                insertQuery = "INSERT INTO transactions (accountNo, amount, depositorName, remarks, status) VALUES(?, ?,?,?, ?)";
                PreparedStatement pstm = cn.prepareStatement(insertQuery);
                pstm.setString(1, accountNoo);
                pstm.setInt(2, icash);
                pstm.setString(3, depositorName);
                pstm.setString(4, remarks);
                pstm.setString(5, "credit");
                pstm.executeUpdate();

                updateQuery = "UPDATE users SET cash = cash+'" + icash + "' WHERE accountNo = '" + accountNoo + "'";
                cn.prepareStatement(updateQuery).execute();
                RequestDispatcher rd = request.getRequestDispatcher("depositwithoutlogin.jsp");
                rd.include(request, response);
                out.println("<h2>Deposit Successfull.<h2>");
                System.out.println("success");
            } catch (Exception e) {
                System.out.println("False");
            }
        }
    }
}
