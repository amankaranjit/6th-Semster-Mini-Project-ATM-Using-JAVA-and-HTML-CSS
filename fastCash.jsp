
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Fast Cash</title>
        <link rel="icon" href="resources/logo.jpg">
        <link rel="stylesheet" href="stylesheet/fastcash.css">
    </head>
    <body> 

        <div class="row">
            <div class="column">
                <img src="resources/fastcashimage.jpg" alt="Forest" style="width:100%; height:660px;">
            </div>
            <div class="column text" style="height: 660px">
                <input type="text" id="currentDateTime" class="date">
                <div class="insideDiv">
                    <img src="resources/loginlogo.png"><br><br>
                    <p> Fast Cash</p>
                    <form action="FastCashServlet" method="post">
                        <table class="insidetable" border='2px' align='center'>
                            <tr>
                                <td><input type="submit" class="btn" name="fastcash" value="1000"></td>
                                <td><input type="submit" name="fastcash" value="2000"></td>                    
                            </tr>
                            <tr>
                                <td><input type="submit" name="fastcash" value="3000"></td>
                                <td><input type="submit" name="fastcash" value="4000"></td>  
                            </tr>
                            <tr>
                                <td><input type="submit" name="fastcash" value="5000"></td>
                                <td><input type="submit" name="fastcash" value="10000"></td>  
                            </tr>
                            <tr>
                                <td><input type="submit" name="fastcash" value="15000"></td>
                                <td><input type="submit" name="fastcash" value="20000"></td>  
                            </tr>
                        </table>
                        <button style="width: 49%;  background-color: red; padding: 14px 20px; margin: 8px 0;border: none;border-radius: 4px;cursor: pointer;"><a href="menu.jsp" style="text-decoration: none;color:white;">Back</button>
                    </form>
                </div>
            </div>   

            <script>
                var today = new Date();
                var date = today.getFullYear() + '-' + (today.getMonth() + 1) + '-' + today.getDate();
                var time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
                var dateTime = date + ' ' + time;
                document.getElementById("currentDateTime").value = dateTime;
            </script>
        </div>
    </body>
</html>
