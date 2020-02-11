<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.PacketDTO"%>
	
<!DOCTYPE html>
<html>

	<head>
		<meta charset="ISO-8859-1">
		<link href="../css/vittoriostyle.css" rel="stylesheet">
		<title>Packet Manager</title>
	</head>

<body>
	<%@ include file="../css/header.jsp" %>
	
	<div class="main">
		<%
			List<PacketDTO> list = (List<PacketDTO>) request.getAttribute("list");
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
				<a href=PacketServlet?mode=read&id=<%=p.getId_pack()%>>
						<%=p.getName()%>
				</a>
				</td>
				
				<td><%=p.getDescription()%></td>
				
				<td>
				<a href=PacketServlet?mode=read&update=true&id=<%=p.getId_pack()%>>
					Edit
				</a>
				</td>
				
				<td>
				<a href=PacketServlet?mode=delete&id=<%=p.getId_pack()%>>
					Delete
				</a>
				</td>
			</tr>
			<%
				}
			%>
			
		</table>
	
	
	<form id="floatright" action="PacketServlet?mode=insert" method="post">
	  <div class="row">
	  	<div class="col-25">
	  		<label for="packet">Name</label>
	  	</div>
	    <div class="col-75">
	      <input type="text" id="packet" name="packetName" placeholder="Insert packet name . . .">
	    </div>
	  </div>
	  
	  <div class="row">
	  	 <div class="col-25">
	  		<label for="packet">Description</label>
	  	</div>
	    <div class="col-75">
	      <input type="text" id="desc" name="packetDescription" placeholder="Insert description . . ."> 
	    </div>
	  </div>
	  	  
	  <button type="submit" >Insert</button>
	</form>
	
	<form id="floatright" action="PacketServlet?mode=find" method="post">
	
	  <div class="row">
	    <div class="col-75">
	      <input type="text" id="packet" name="packetFind" placeholder="Insert packet name to search for. . .">
	    </div>
	  </div>
	  	  
	  <button type="submit" >Find</button>
	</form>
	</div>
	
	
	<br>
	<%@ include file="../css/footer.jsp" %>
	</body>
</html>