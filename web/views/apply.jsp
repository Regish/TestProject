<%--
  Created by IntelliJ IDEA.
  User: sharvanih.s
  Date: 06/07/15
  Time: 1:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="../styles/style.css" rel="stylesheet" type="text/css" >
    <title>Leave Management System</title>
</head>
<body>
<header>Leave Management System</header>
<div id="session-container" >
    <h3><%=(String)session.getAttribute("username")%></h3>
    <form action="logout"><input type="submit" value=" Logout"></form>

</div>

</body>
</html>
