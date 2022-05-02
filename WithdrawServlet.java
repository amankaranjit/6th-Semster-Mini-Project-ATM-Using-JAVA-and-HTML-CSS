package com.aadimcollege.servlet;

import com.aadimcollege.db.JDBCConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import static javafx.application.Platform.exit;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class WithdrawServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        Connection cn = JDBCConnection.getConnection();
        //form bata ako data lai string ma rakheko
        String pinNumber = request.getParameter("pinNumber");
        String amount = request.getParameter("cash");
        HttpSession session = request.getSession(false);
        String acnoo = (String) session.getAttribute("accountNo");
        if (pinNumber.isEmpty() || amount.isEmpty()) {
            RequestDispatcher rd = request.getRequestDispatcher("withdraw.jsp");
            rd.include(request, response);
            out.println("<h2>Please fill all the fields.<h2>");
            System.out.println("failed");
        } else {
            try {
                int Cash = Integer.parseInt(amount);
                System.out.println("Integer Cash " + Cash);
                Statement stmt = cn.createStatement();
                ResultSet rs = stmt.executeQuery("select * from users where accountNo =" + acnoo);
                while (rs.next()) {
                    int Dbcash = rs.getInt("cash");
                    System.out.println(Dbcash);
                    String pinnumber = rs.getString("pinNumber");
                    if (pinNumber.isEmpty() || amount.isEmpty()) {
                        RequestDispatcher rd = request.getRequestDispatcher("withdraw.jsp");
                        rd.include(request, response);
                        out.print("<h1>Please Fill All The Fields.</h1>");
                    } else if (pinnumber.equals(pinNumber)) {
                        if (Cash <= Dbcash) {
                            String Name = "";
                            Statement stm = cn.createStatement();
                            ResultSet resultset = stm.executeQuery("select * from users where accountNo = " + acnoo);
                            while (resultset.next()) {
                                Name = rs.getString("name");
                            }
                            System.out.println(acnoo);
                            System.out.println(Name);
                            System.out.println(Cash);

                            String updateQuery = "UPDATE users SET cash = cash-'" + Cash + "' WHERE accountNo = '" + acnoo + "'";
                            cn.prepareStatement(updateQuery).execute();
//                            String insert = "INSERT INTO transactions (accountNo, amount, depositorName, remarks, status) VALUES(?, ?,?,?, ?)";
//                            PreparedStatement pstm = cn.prepareStatement(insert);
//                            pstm.setString(1, acnoo);
//                            pstm.setInt(2, Cash);
//                            pstm.setString(3, Name);
//                            pstm.setString(4, "Debited");
//                            pstm.setString(5, "Debited");
//                            pstm.executeUpdate();

                            RequestDispatcher rd = request.getRequestDispatcher("withdraw.jsp");
                            rd.include(request, response);
                            out.print("<h1>Please recieve you cash Rs." + Cash + "</h1>");
                            System.out.print("Succesfull");
                        } else {
                            RequestDispatcher rd = request.getRequestDispatcher("withdraw.jsp");
                            rd.include(request, response);
                            out.print("<h1>Insufficient Balance.</h1>");
                            System.out.print("false");

                        }
                    } else {
                        RequestDispatcher rd = request.getRequestDispatcher("withdraw.jsp");
                        rd.include(request, response);
                        System.out.println("false");
                        out.print("<h1>Incorrect Pin.</h1>");
                    }
                }

            } catch (Exception e) {
            }

        }
    }
}
