<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.PacketDTO"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="../css/vittoriostyle.css" rel="stylesheet">
		<title>Read Packet</title>
	</head>
	
	<body>
		<%@ include file="../css/header.jsp" %>
		
		<div class="main">
		<%PacketDTO p = (PacketDTO) request.getAttribute("dto");%>
		
		<br>
		<br>
		
		<table>
			<tr> 
				<th>Name</th>
				<th>Description</th>
				<th>Os Type</th>
			</tr>
			<tr>
				<td><%=p.getName()%></td>
				<td> <%=p.getDescription()%></td>
				<td> <%=p.getOsKey()%></td>
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