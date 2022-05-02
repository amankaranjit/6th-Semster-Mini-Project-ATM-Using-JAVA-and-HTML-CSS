<%-- 
    Document   : forgotpin
    Created on : Feb 24, 2022, 9:35:31 AM
    Author     : Aman Karanjit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>WELCOME TO NIC ASIA BANK</title>       
        <link rel="icon" href="resources/logo.jpg">
        <link rel="stylesheet" href="stylesheet/style.css"> 
        <style>
            input[type=email]{
                width: 100%;
                padding: 12px 20px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
            }
        </style>
    </head>
    <body> 

        <table>
            <tr>
            <div class="row" style="margin-top: 50px;">
                <div class="column text" style="height: 585px">
                    <div class="insideDiv">
                        <img src="resources/loginlogo.png"><br><br>
                        <b>Forget Pin</b><br><br>
                        <form action="EmailSender" method="post">
                            <label for="email">Email</label>
                            <input type="email" id="email" name="email" placeholder="Your Email">
                            <input type="submit" value="Login">

                        </form>
                        <script>
                            function isNumberKey(evt)
                            {
                                var charCode = (evt.which) ? evt.which : event.keyCode
                                if (charCode > 31 && (charCode < 48 || charCode > 57))
                                    return false;

                                return true;
                            }
                        </script>
                    </div>
                </div>
                <div class="column">
                    <img src="resources/loginpageimage.jpg" alt="Forest" style="width:100%; height:581px;">
                </div>
            </div>
        </tr>
    </table>        
</body>
</html>

