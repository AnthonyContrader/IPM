<%@page import="it.contrader.dto.OsTypeDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read OS Type</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active" href="OsTypeServlet?mode=ostypelist">OS Types</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class = "main">
<%OsTypeDTO u = (OsTypeDTO) request.getAttribute("dto"); %>

<table>
	<tr> 
		<th>Name</th>
		<th>Command</th>
	</tr>
	<tr>
		<td><%=u.getName()%></td>
		<td> <%=u.getCommand()%></td>
	</tr>	
</table>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>

</div>

<%@ include file="../css/footer.jsp" %>
</body>
</html>