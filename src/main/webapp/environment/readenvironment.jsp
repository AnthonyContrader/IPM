<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.EnvironmentDTO"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="../css/vittoriostyle.css" rel="stylesheet">
		<title>Read Packet</title>
	</head>
	
	<body>
		<%@ include file="../css/header.jsp" %>
		
		<div class="navbar">
		  <a href="homeadmin.jsp">Home</a>
		  <a href="UserServlet?mode=userlist">Users</a>
		  <a class="active" href="EnvironmentServlet?mode=environmentlist">Environments</a>
		  <a href="LogoutServlet" id="logout">Logout</a>
		</div>
		<br>
		
		<div class="main">
		<%EnvironmentDTO e = (EnvironmentDTO) request.getAttribute("dto");%>
		
		<table>
			<tr> 
				<th>Name</th>
				<th>Description</th>
			</tr>
			<tr>
				<td><%=e.getName()%></td>
				<td> <%=e.getDescription()%></td>
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