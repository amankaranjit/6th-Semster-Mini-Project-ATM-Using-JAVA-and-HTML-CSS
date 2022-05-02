<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Deposit Form</title>
        <link rel="icon" href="resources/logo.jpg">
        <link rel="stylesheet" href="stylesheet/deposit.css">
    </head>
    <body style="margin-top: 50px;"> 

            <div class="row">
                 <div class="column">
                    <img src="resources/loginpageimage.jpg" alt="Forest" style="width:100%; height:566px;">
                </div>
                <div class="column text" style="height: 570px">
                    <div class="insideDiv">
                        <img src="resources/loginlogo.png"><br><br>
                        <b>Deposit Form</b><br><br>
                        <form action="DepositServlet" method="post">
                           
                             <label for="cash">Amount</label>
                            <input type="text" id="cash" name="cash"onkeypress="return isNumberKey(event)" placeholder="Enter Amount..">

                            <label for="remarks">Remarks</label>
                            <input type="text" id="remarks" name="remarks" placeholder="Enter Remarks..">                          
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
