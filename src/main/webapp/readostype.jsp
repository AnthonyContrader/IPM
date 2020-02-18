<%@page import="it.contrader.dto.OsTypeDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="<OsType Read">
<meta name="author" content="Aleksandra Vysitska">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read OsType</title>
</head>
<body>

	<%@ include file="./css/header.jsp"%>
	
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a>
		<a href="/user/getall">Users</a>
		<a href="/packet/getall">Packets</a>
		<a href="/environment/getall">Environments</a>
		<a class="active" href="/ostype/getall">OS Types</a>
		<a href="/user/logout" id="logout">Logout</a>
	</div>
	
	<div class="main">
		<%
			OsTypeDTO o = (OsTypeDTO) request.getSession().getAttribute("dto");
		%>


		<table>
			<tr>
				<th>ID</th>
				<th>OsType</th>
				<th>Command</th>
			</tr>
			<tr>
				<td><%=o.getId()%></td>
				<td><%=o.getOsType()%></td>
				<td><%=o.getCommand()%></td>
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="./css/footer.jsp"%>

</body>
</html>