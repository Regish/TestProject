<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: sharvanih.s
  Date: 06/07/15
  Time: 1:15 AM
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
    <form action="../logout"><input type="submit" value=" Logout"></form>

</div>
<h2>View your Leave History</h2>

<div id="form-container" >
    <form action="../view" method="post">
        <div id="from" >From
            <br><input type="date" name="fromDate" >
        </div>
        <div id="to">To
            <br><input type="date" name="toDate">
        </div>
        <input type="submit" value="View History" >
    </form>
</div>

<div id="report-container">
    <%!List<String> data; %>
    <%String e=(String)request.getAttribute("error");
        if(e!=null){
        %><p><%=e%></p><%
    }else
    { if(request.getAttribute("leaves")!=null)
    {
        data=(List<String>)request.getAttribute("leaves");
        //entry|leave_from|leave_to|leave_status|applied_on|days

    %>
    <table border="1">
        <tr>
            <td>From</td>
            <td>To</td>
            <td>Number of days</td>
            <td>Status</td>
            <td>Applied On</td>
            <td>Cancel?</td>
        </tr>
        <%for(String i:data)  { %>
        <tr>
            <% String[] entry=i.split("_");%>
            <td><%= entry[1]%></td>
            <td><%= entry[2]%></td>
            <td><%= entry[5]%></td>
            <td><%= entry[3]%></td>
            <td><%= entry[4]%></td>
            <% if(entry[3].equals("A")){%>
            <td><a href="cancel?q=<%= entry[0] %>&n=<%=entry[5]%>"  >Cancel</a> </td>
            <% } %>
        </tr>
        <% }%>
    </table>

    <% }
    }%>

</div>

</body>
</html>
