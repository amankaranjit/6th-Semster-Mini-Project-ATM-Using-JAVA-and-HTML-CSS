<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Welcome to Charumati Bank's ATM</title>
        <link rel="icon" href="resources/logo.jpg">
        <link rel="stylesheet" href="stylesheet/menustyle.css">
    </head>
    <body>
        <div class="container" style="margin-top: 5px;" >
             <input type="text" id="currentDateTime" >
            <img src="resources/loginlogo.png"><br>
            <h2>Welcome To CHARUMATI Bank's ATM</h2>
            <table border='1px' align='center'>
                <tr>
                    <td><a href="deposit.jsp"> Deposit</td>
                    <td><a href="withdraw.jsp"> Withdraw</td>                    
                </tr>
                <tr>
                    <td><a href="fastCash.jsp"> Fast Cash</td>                   
                    <td><a href="pinChange.jsp"> Pin Change</td>  
                </tr>
                <tr>
                    <td><a href="ministatement.jsp"> Mini Statement</td>
                    <td><a href="checkbalance.jsp"> Check Balance</td>  
                </tr>
            </table>
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
