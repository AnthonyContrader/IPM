<%@ page import="it.contrader.dto.PacketDTO" import="it.contrader.dto.OsTypeDTO" import="java.util.*"%>
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
			List<OsTypeDTO> listos = (List<OsTypeDTO>) request.getSession().getAttribute("listos");
		%>

		<br>

		<table>
			<tr>
				<th>Name</th>
				<th>Description</th>
				<th>OS</th>
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
					<%=p.getPacketostype().getOsType()%>
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
			
			<select id="type" name="packetOstype" required>
				<option value="" disabled selected>Choose your option</option>
			<%
				for (OsTypeDTO o : listos) {
			%>
  				<option value="<%=o.getId()%>"><%=o.getOsType()%></option> 
			<%
				}
			%>
		</select>

			<button type="submit">Insert packet!</button>
		</form>
		
		<form id="floatright" action="/packet/find" method="get">
			<div class="row">
				<div class="col-25">
					<label for="packetName">Name</label>
				</div>
				<div class="col-75">
					<input type="text" id="packetFindName" name="nameFind"
						placeholder="Insert packet name to search for">
				</div>
			</div>

			<button type="submit">Find packet!</button>
		</form>

	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>
</body>
</html>