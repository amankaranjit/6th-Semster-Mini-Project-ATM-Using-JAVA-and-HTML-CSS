
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>WELCOME TO CHARUMATI BANK</title>       
        <link rel="icon" href="resources/logo.jpg">
        <link rel="stylesheet" href="stylesheet/style.css"> 

    </head>
    <body> 

        <table>
            <tr>
            <div class="row" style="margin-top: 50px;">
                <div class="column text" style="height: 585px">
                    <div class="insideDiv">
                        <img src="resources/loginlogo.png"><br><br>
                        <b>Login</b><br><br>
                        <form action="LoginServlet" method="post">
                            <label for="accountNo">Account Number</label>
                            <input type="text" id="accountNo" name="accountNo"onkeypress="return isNumberKey(event)" placeholder="Your Account No..">

                            <label for="pinNumber">Pin Number </label>
                            <input type="password" id="pinNumber" name="pinNumber" onkeypress="return isNumberKey(event)"  placeholder="Your Pin No..">


                            <button style="width: 49%;  background-color: red; padding: 14px 20px; margin: 8px 0;border: none;border-radius: 4px;cursor: pointer;"><a href="depositwithoutlogin.jsp" style="text-decoration: none;color:white;">Deposit</button>
                            <button style="width: 49%;  background-color: red; padding: 14px 20px; margin: 8px 0;border: none;border-radius: 4px;cursor: pointer;"><a href="signUp.jsp" style="text-decoration: none;color:white;">Signup</button>

                            <input type="submit" value="Login">
                            <!--<a href="forgotpin.jsp" style="text-decoration: none; color:red;">Forgot Pin?-->
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

