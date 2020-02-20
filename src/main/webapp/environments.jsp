<%@ page import="it.contrader.dto.PacketDTO" import="it.contrader.dto.EnvironmentDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Packet Management">
<meta name="author" content="Michele Bonanno">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Environment Manager</title>

</head>
<body>
	<%@ include file="./css/header.jsp"%>

	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> 
		<a href="/user/getall">Users</a>
		<a class="active" href="/packet/getall">Environment</a>
		<a href="/user/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			List<EnvironmentDTO> list = (List<EnvironmentDTO>) request.getSession().getAttribute("list");
			List<PacketDTO> listp = (List<PacketDTO>) request.getSession().getAttribute("listp");
		%>

		<br>

		<table>
			<tr>
				<th>Name</th>
				<th>Description</th>
				<th>Packet</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (EnvironmentDTO e : list) {
			%>
			<tr>
				<td>
					<a href="/environment/read?id=<%=e.getId()%>"> <%=e.getName()%> </a>
				</td>
				
				<td>
					<%=e.getDescription()%>
				</td>
				
				<td>
					<%=e.getEnvironmentpacket().getName()%>
				</td>
				
				<td>
					<a href="/environment/preupdate?id=<%=e.getId()%>">Edit</a>
				</td>

				<td>
					<a href="/environment/delete?id=<%=e.getId()%>">Delete</a>
				</td>
			</tr>
			<%
				}
			%>
		</table>


		<form id="floatright" action="/environment/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="environmentName">Name</label>
				</div>
				<div class="col-75">
					<input type="text" id="environmentName" name="name"
						placeholder="Insert environment name">
				</div>
			</div>
			
			<div class="row">
				<div class="col-25">
					<label for="environmentDesc">Description</label>
				</div>
				<div class="col-75">
					<input type="text" id="environmentDesc" name="description"
						placeholder="Insert description">
				</div>
			</div>
			
			<select id="type" name="environmentPacket" required>
				<option value="" disabled selected>Choose your option</option>
			<%
				for (PacketDTO p : listp) {
			%>
  				<option value="<%=p.getId()%>"><%=p.getName()%></option> 
			<%
				}
			%>
		</select>

			<button type="submit">Insert environment!</button>
		</form>
	
	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>
</body>
</html>