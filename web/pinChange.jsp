<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Pin Change Form</title>
        <link rel="icon" href="resources/logo.jpg">
        <link rel="stylesheet" href="stylesheet/withdraw.css">
    </head>
    <body style="margin-top: 50px;"> 

        <div class="row">
            <div class="column">
                <img src="resources/withdrawimage.jpg" alt="Forest" style="width:100%; height:454px;">
            </div>
            <div class="column text" style="height: 454px">
                <div class="insideDiv">
                    <img src="resources/loginlogo.png"><br><br>
                    <b>Pin Change Form</b><br><br>
                    <form action="PinChangeServlet" method="post">

                        <label for="opin">Old Pin Number</label>
                        <input type="password" id="opin" name="opin"onkeypress="return isNumberKey(event)" placeholder="Enter Old Pin..">

                        <label for="npin">New Pin Number</label>
                        <input type="password" id="npin" name="npin" placeholder="Enter New Pin..">

                        <input type="submit" value="Submit">
                        <button style="width: 49%;  background-color: red; padding: 14px 20px; margin: 8px 0;border: none;border-radius: 4px;cursor: pointer;"><a href="menu.jsp" style="text-decoration: none;color:white;">Back</button>

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
