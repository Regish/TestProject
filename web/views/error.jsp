<%--
  Created by IntelliJ IDEA.
  User: sharvanih.s
  Date: 05/07/15
  Time: 11:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Leave Management System</title>
    <link href="../styles/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<header >Leave Management System</header>
<div id="container">
    <%
        Exception e=(Exception) request.getAttribute("exception");
        String msg=e.getClass().getSimpleName();
    %>
    <h3>Sorry guys!<br>There was an error</h3>
    <%=msg%>
</div>
</body>
</html>
