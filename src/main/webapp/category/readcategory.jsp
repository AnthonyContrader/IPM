<%@ 
	page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.CategoryDTO"
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="../css/vittoriostyle.css" rel="stylesheet">
		<title>Read Category</title>
	</head>

	<body>
		<%@
			include file="../css/header.jsp"
		 %>
		 
		 <br>
		 
		<div class="main">
			<%
				CategoryDTO c = (CategoryDTO) request.getAttribute("dto");
			%>
			
			<table>
				<tr>
					<th>Name</th>
				</tr>
				
				<tr>
					<td>
						<%=c.getName()%>
					</td>
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
		
		<%@
			include file="../css/footer.jsp"
		 %>
	</body>
</html>