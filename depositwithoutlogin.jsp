<%@page contentType="text/html" pageEncoding="UTF-8"%><html>
    <head>
        <title>Deposit Form</title>
        <link rel="icon" href="resources/logo.jpg">
        <link rel="stylesheet" href="stylesheet/depositwithoutlogin.css">
    </head>
    <body style="margin-top: 50px;"> 

        <div class="row">
            <div class="column">
                <img src="resources/loginpageimage.jpg" alt="Forest" style="width:100%; height:670px;">
            </div>
            <div class="column text" style="height: 670px">
                <div class="insideDiv">
                    <img src="resources/loginlogo.png"><br><br>
                    <b>Deposit Form</b><br><br>
                    <form action="DepositWithoutLoginServlet" method="post">
                        <label for="depositorname">Enter Depositor Name</label>
                        <input type="text" id="depositorname" name="depositorname" placeholder="Your Depositor Name...">
                        <label for="recivername">Enter Reciver Name</label>
                        <input type="text" id="recivername" name="recivername" placeholder="Your Reciver Name...">


                        <label for="accountNo">Reciver Account Number</label>
                        <input type="text" id="accountNo" name="accountNo"onkeypress="return isNumberKey(event)" placeholder="Enter Reciver  Account No..">

                        <label for="cash">Amount</label>
                        <input type="text" id="cash" name="cash"onkeypress="return isNumberKey(event)" placeholder="Enter Amount..">

                        <label for="remarks">Remarks</label>
                        <input type="text" id="remarks" name="remarks" placeholder="Enter Remarks..">   

                        <label for="contact">Contact</label>
                        <input type="text" id="contact" name="contact" placeholder="Enter Contact..">                          

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
