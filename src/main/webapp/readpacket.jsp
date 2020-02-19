<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.PacketDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Packet Read">
<meta name="author" content="Alessio Cellucci">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read Packet</title>
</head>
<body>
	<%@ include file="./css/header.jsp"%>
	
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a class="active"
			href="/user/getall">Users</a> <a href="/user/logout" id="logout">Logout</a>
	</div>
	<br>

	<div class="main">
		<%
			PacketDTO p = (PacketDTO) request.getSession().getAttribute("dto");
		%>


		<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Description</th>
				<th>OSType</th>
			</tr>
			<tr>
				<td><%=p.getId()%></td>
				<td><%=p.getName()%></td>
				<td><%=p.getDescription()%></td>
				<td><%=p.getPacketostype().getOsType()%>
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="./css/footer.jsp"%>
</body>
</html>