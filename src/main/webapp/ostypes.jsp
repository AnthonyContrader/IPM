<%@page import="java.util.List"%>
<%@ page import="it.contrader.dto.OsTypeDTO" import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="OsType Management">
<meta name="author" content="Aleksandra Vysitska">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>OsType Manager</title>
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
			List<OsTypeDTO> list = (List<OsTypeDTO>) request.getSession().getAttribute("list");	
		%>
		
		<br>
		
		<table>
			<tr>
				<th>Os Type</th>
				<th>Command</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (OsTypeDTO o : list) {
			%>
			<tr>
				<td><a href="/ostype/read?id=<%=o.getId()%>"> <%=o.getOsType()%>
				</a></td>
				<td><%=o.getCommand()%></td>
				<td><a href="/ostype/preupdate?id=<%=o.getId()%>">Edit</a></td>
				<td><a href="/ostype/delete?id=<%=o.getId()%>">Delete</a></td>
			</tr>
			<%
				}
			%>
		</table>
		
		<form id="floatright" action="/ostype/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="ostypetName">OsType</label>
				</div>
				<div class="col-75">
					<input type="text" id="ostypetName" name="name"
						placeholder="Insert ostype name">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="ostypeComm">Command</label>
				</div>
				<div class="col-75">
					<input type="text" id="ostypeComm" name="command"
						placeholder="Insert command">
				</div>
			</div>

			<button type="submit">Insert packet!</button>
		</form>
		
	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>
</body>
</html>