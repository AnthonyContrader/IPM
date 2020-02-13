<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.PacketDTO" import="it.contrader.dto.EnvironmentDTO" import="it.contrader.dto.CategoryDTO"%>
	
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
			List<PacketDTO> listp = (List<PacketDTO>) request.getAttribute("list");
			List<EnvironmentDTO> list = (List<EnvironmentDTO>) request.getAttribute("listos");
			List<CategoryDTO> listc = (List<CategoryDTO>) request.getAttribute("listc");

		%>
	<br>
	
		<table>
			<tr>
				<th>Name</th>
				<th>Description</th>
				<th>Packet</th>
				<th>Category</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (EnvironmentDTO p : list) {
			%>
			<tr>
				<td>
				<a href=EnvironmentServlet?mode=read&id=<%=p.getId_env()%>>
						<%=p.getName()%>
				</a>
				</td>
				
				<td><%=p.getDescription()%></td>
				
				<td><%=p.getPacketKey()%></td>
				<td><%=p.getCategoryKey()%></td>
				<td>
				<a href=EnvironmentServlet?mode=read&update=true&id=<%=p.getId_env()%>>
					Edit
				</a>
				</td>
				
				<td>
				<a href=EnvironmentServlet?mode=delete&id=<%=p.getId_env()%>>
					Delete
				</a>
				</td>
			</tr>
			<%
				}
			%>
			
		</table>
	
	
	<form id="floatright" action="EnvironmentServlet?mode=insert" method="post">
	  <div class="row">
	  	<div class="col-25">
	  		<label for="packet">Name</label>
	  	</div>
	    <div class="col-75">
	      <input type="text" id="environment" name="environmentName" placeholder="Insert environment name . . .">
	    </div>
	  </div>
	  
	  <div class="row">
	  	 <div class="col-25">
	  		<label for="packet">Description</label>
	  	</div>
	    <div class="col-75">
	      <input type="text" id="desc" name="environmentDescription" placeholder="Insert description . . ."> 
	    </div>
	  </div>
	  
	  <div class="row">
	  	 <div class="col-25">
	  		<label for="environment">Packet</label>
	  	</div>
		<select id="type" name="environmentPacket" required>
			<option value="" disabled selected>Choose your option</option>
			<%
				for (PacketDTO o : listp) {
			%>
  				<option value="<%=o.getName()%>"><%=o.getName()%></option> 
			<%
				}
			%>
		</select>

	  </div>
	  
	  <div class="row">
	  	 <div class="col-25">
	  		<label for="environment">Category</label>
	  	</div>
		<select id="type" name="environmentCategory" required>
			<option value="" disabled selected>Choose your option</option>
			<%
				for (CategoryDTO c : listc) {
			%>
  				<option value="<%=c.getName()%>"><%=c.getName()%></option> 
			<%
				}
			%>
		</select>

	  </div>
	  	  
	  <button type="submit" >Insert</button>
	</form>
	
	</div>
	
	
	<br>
	<%@ include file="../css/footer.jsp" %>
	</body>
</html>