<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.PacketDTO"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="../css/vittoriostyle.css" rel="stylesheet">
		<title>Edit Packet</title>
	</head>
		
	<body>
		<%@ include file="../css/header.jsp" %>
		
		<div class="navbar">
		  <a href="homeadmin.jsp">Home</a>
		  <a href="UserServlet?mode=userlist">Users</a>
		  <a class="active" href="PacketServlet?mode=packetlist">Packets</a>
		  <a href="LogoutServlet" id="logout">Logout</a>
		</div>
		
		<br>
		
		<div class="main">
		
		<%PacketDTO p = (PacketDTO) request.getAttribute("dto");%>
		
		
		<form id="floatleft" action="PacketServlet?mode=update&id=<%=p.getId_pack()%>" method="post">
		
		  <div class="row">
		    <div class="col-25">
		      <label for="packet">Name</label>
		    </div>
		    
		    <div class="col-75">
		      <input type="text" id="packet" name="packetName" value=<%=p.getName()%>>
		    </div>
		    
		  </div>
		  
		  <div class="row">
		    <div class="col-25">
		     <label for="description">Description</label>
		    </div>
		    
		    <div class="col-75">
		      <input
					type="text" id="description" name="packetDescription" value=<%=p.getDescription()%>> 
		    </div>
		  </div>
		  
		  <button type="submit" >Edit</button>
		  
		</form>
		
			
		</div>
		<br>
		<%@ include file="../css/footer.jsp" %>	
	</body>
</html>