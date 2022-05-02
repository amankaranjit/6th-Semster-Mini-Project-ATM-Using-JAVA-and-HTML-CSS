<%-- 
    Document   : signUp
    Created on : Feb 24, 2022, 9:02:14 PM
    Author     : Aman Karanjit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Sign Up Form</title>
        <link rel="icon" href="resources/logo.jpg">
        <link rel="stylesheet" href="stylesheet/signup.css">
    </head>
    <body style="margin-top: 50px;"> 

        <div class="row">
            <div class="column">
                <img src="resources/loginpageimage.jpg" alt="Forest" style="width:100%; height:610px;">
            </div>
            <div class="column text" style="height: 610px">
                <div class="insideDiv">
                    <img src="resources/loginlogo.png"><br><br>
                    <b>Sign Up Form</b><br><br>
                    <form action="SignupServlet" method="post">
                        <label for="fname">Enter Full Name</label>
                        <input type="text" id="fname" name="fname" placeholder="Your Name...">
                        <label for="address">Enter Address</label>
                        <input type="text" id="address" name="address" placeholder="Your Address...">

                        <label for="dob">Date of Birth</label>
                        <input type="text" id="dob" name="dob" placeholder="YYYY / MM / DD">

                        <label for="email">Email</label>
                        <input type="email" id="email" name="email" placeholder="Enter Email..">   

                        <label for="contact">Contact</label>
                        <input type="text" id="contact" name="contact" onkeypress="return isNumberKey(event)" placeholder="Enter Contact..">                          


                        <label for="gender">Gender:</label>
                        <label for="male">Male</label>
                        <input type="radio" name="gender" id="male" value="male" checked>
                        <label for="female">Female</label>
                        <input type="radio" name="gender" id="female" value="female">

                        <input type="submit" value="Submit">
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
        </div>

    </body>
</html>
