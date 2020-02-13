<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.EnvironmentDTO"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="../css/vittoriostyle.css" rel="stylesheet">
		<title>Read Environment</title>
	</head>
	
	<body>
		<%@ include file="../css/header.jsp" %>
		
	
		<br>
		
		<div class="main">
		<%EnvironmentDTO e = (EnvironmentDTO) request.getAttribute("dto");%>
		
		<table>
			<tr> 
				<th>Name</th>
				<th>Description</th>
				<th>Packet</th>
				<th>Category</th>
			</tr>
			<tr>
				<td><%=e.getName()%></td>
				<td> <%=e.getDescription()%></td>
				<td> <%=e.getPacketKey()%></td>
				<td> <%=e.getCategoryKey()%></td>
			
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