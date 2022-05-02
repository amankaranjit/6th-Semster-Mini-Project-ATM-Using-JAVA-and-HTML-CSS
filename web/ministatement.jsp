
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.aadimcollege.db.JDBCConnection"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String accNo = (String) session.getAttribute("accountNo");
    if (accNo == null) {
        response.sendRedirect("index.html");
    }
%>
<%
	Connection conn = Connection.JDBCConnection.getConnection();
    Statement st = conn.createStatement();
    ResultSet rs = null;
%>
<html>
    <head>
        <title>Welcome to Aadim National Bank's ATM</title>
        <link rel="icon" href="resources/logo.jpg">
        <link rel="stylesheet" href="stylesheet/menustyle.css">
        <style>
            h1{

                margin-left: 300px;
                width: 50%;
                text-align: center;
                color: red;
            }
            .container{
                margin-top: 150px;
                height: auto;
            }
        </style>
    </head>
    <body>
        <div class="container" >           
            <input type="text" id="currentDateTime" >
            <img src="resources/loginlogo.png"><br>
            <h2>Recent Transactions</h2>
            <%
                rs = st.executeQuery("SELECT COUNT(*) as count FROM transactions WHERE accountNo = " + accNo + "");
                rs.next();
                int limitData = rs.getInt("count");
                if (limitData > 0) { %>
            <table border="1" width="90%" align="center">
                <tr>
                    <td>Name</td>
                    <td>Amount</td>
                    <td>Remarks</td>
                </tr>
                <div class="transactions-info">
                    <%
                        rs = st.executeQuery(
                                "SELECT * FROM transactions WHERE accountNo = " + accNo + " order by id desc");
                        while (rs.next()) {
                            String name = rs.getString("depositorName");
                            String amount = rs.getString("amount");
                            String status = rs.getString("status");
                            String remarks = rs.getString("remarks");
                    %>
                    <tr align="center">
                        <td><%= name%></td>
                        <td><%= amount%></td>
                        <td><%= remarks%></td>
                    </tr>
                    <%
                        }
                    %>
                </div>
            </table>
            <%
            } else {
            %>
            <p class="balance">No recent transactions found</p>
            <%
                }
            %>
        </div>        
        <script>
            var today = new Date();
            var date = today.getFullYear() + '-' + (today.getMonth() + 1) + '-' + today.getDate();
            var time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
            var dateTime = date + ' ' + time;
            document.getElementById("currentDateTime").value = dateTime;
        </script>
    </body>
</html>

