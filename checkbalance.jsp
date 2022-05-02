<%-- 
    Document   : checkbalance.jsp
    Created on : Feb 17, 2022, 7:16:54 AM
    Author     : Aman Karanjit
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.aadimcollege.db.JDBCConnection"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                height:400px;
            }
        </style>
    </head>
    <body>
        <div class="container" >           
            <input type="text" id="currentDateTime" >
            <img src="resources/loginlogo.png"><br>
            <%!
                int dbcash = 0;
                String name = null;
            %>
            <%
            	Connection cn = Connection.JDBCConnection.getConnection();
                            HttpSession s = request.getSession(false);
                            String acnoo = (String) s.getAttribute("accountNo");

                            try {
                                Statement stmt = cn.createStatement();
                                ResultSet rs = stmt.executeQuery("select * from users where accountNo="+acnoo);
                                while (rs.next()) {
                                    dbcash = rs.getInt("cash");
                                    name = rs.getString("name");
                                }
                            } catch (Exception e) {
                            }
            %>
            <%
                out.print("<h1>Welcome " + name + ".<h1>");
                out.print("<h1>Your total balance is Rs." + dbcash + " /-<h1>");
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

