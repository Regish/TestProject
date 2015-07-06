<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Leave Management System</title>
    <link href="../styles/style.css" rel="stylesheet" type="text/css">
    <script type="text/javascript">

        function validateForm() {
            var unm = document.getElementById("username").value;
            var pwd = document.getElementById("password").value;
            alert(unm);

            if( unm == "" )
            {
                document.getElementById("p").innerHTML = "Please enter valid username";
                return false;
            }
            else if(pwd == "")
            {
                document.getElementById("p").innerHTML = "Please enter valid password";
                return false;
            }

            return true;
        }
    </script>

</head>
<body>
<header>Leave Management System</header>
<div id="login-container">
    <h2> Login </h2>
    <%String error=(String) request.getAttribute("error");
        if(error!=null){
            %><h3 id="pid" ><%=error%></h3><%
        }

    %>
    <form action="login" method="post" onsubmit="return validateForm()" >
        UserName<br><input type="text" name="username" id="usr">
        <br />
        Password<br><input type="password" name="password" id="pwd">
        <br />
        <input type="submit" value="Login" id="login">
    </form>
    <h2 id="p"> </h2>
</div>

</body>
</html>
