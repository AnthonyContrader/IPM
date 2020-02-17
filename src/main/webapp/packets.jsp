<%@ page import="it.contrader.dto.PacketDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Packet Management">
<meta name="author" content="Alessio Cellucci">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Packet Manager</title>

</head>
<body>
	<%@ include file="./css/header.jsp"%>

	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> 
		<a href="/user/getall">Users</a>
		<a class="active" href="/packet/getall">Packets</a>
		<a href="/user/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			List<PacketDTO> list = (List<PacketDTO>) request.getSession().getAttribute("list");
		%>

		<br>

		<table>
			<tr>
				<th>Name</th>
				<th>Description</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (PacketDTO p : list) {
			%>
			<tr>
				<td>
					<a href="/packet/read?id=<%=p.getId()%>"> <%=p.getName()%> </a>
				</td>
				
				<td>
					<%=p.getDescription()%>
				</td>
				
				<td>
					<a href="/packet/preupdate?id=<%=p.getId()%>">Edit</a>
				</td>

				<td>
					<a href="/packet/delete?id=<%=p.getId()%>">Delete</a>
				</td>
			</tr>
			<%
				}
			%>
		</table>


		<form id="floatright" action="/packet/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="packetName">Name</label>
				</div>
				<div class="col-75">
					<input type="text" id="packetName" name="name"
						placeholder="Insert packet name">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="packetDesc">Description</label>
				</div>
				<div class="col-75">
					<input type="text" id="packetDesc" name="description"
						placeholder="Insert description">
				</div>
			</div>

			<button type="submit">Insert packet!</button>
		</form>

	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>
</body>
</html>