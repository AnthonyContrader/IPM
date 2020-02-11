<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/vittoriostyle.css" rel="stylesheet">
</head>
<body>

<div class="header">SAMPLE Project
</div>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a href="UserServlet?mode=userlist">Users</a>
  <a href="EnvironmentServlet?mode=environmentlist">Environment</a>
  <a href="PacketServlet?mode=packetlist">Packet</a>
  <a href="CategoryServlet?mode=categorylist">Category</a>
  <a href="OsTypeServlet?mode=ostypelist">OS Type</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>


</body>
</html>