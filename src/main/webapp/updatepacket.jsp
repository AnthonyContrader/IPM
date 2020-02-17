<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.PacketDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Packet Edit page">
<meta name="author" content="Alessio Cellucci">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Packet</title>

</head>
<body>
<%@ include file="./css/header.jsp" %>
<div class="navbar">
  <a href="/homeadmin.jsp">Home</a>
  <a class="active" href="/user/getall">Users</a>
  <a href="/user/logout" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%PacketDTO p = (PacketDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/packet/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="packetName2">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="packetName2" name="name" value=<%=p.getName()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="packetDescription2">Description</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="packetDescription2" name="description" value=<%=p.getDescription()%>> 
    </div>
  </div>
	  <input type="hidden" name="id" value =<%=p.getId() %>>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="./css/footer.jsp" %>	
</body>
</html>