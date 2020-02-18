<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.EnvironmentDTO"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta name="viewport" content = "width=device-width, initial-scale = 1, shring-to-fit = no">
<meta name = "description" content = "Environment Update page">
<meta name = "author" content = "Michele Bonanno">
<link href = "/css/vittoriostyle.css" rel = "stylesheet">
<title>Edit Environment</title>

</head>
<body>
<%@ include file = "./css/header.jsp" %>
<div class="navbar">
  <a href="/homeadmin.jsp">Home</a>
  <a class="active" href="/user/getall">Users</a>
  <a href="/user/logout" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%EnvironmentDTO e = (EnvironmentDTO) request.getSession().getAttribute("dto");%>

<form id="floatleft" action="/environment/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="environmentName">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="environmentName" name="name" value=<%=e.getName()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="environmentDescription">Description</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="environmentDescription" name="description" value=<%=e.getDescription()%>> 
    </div>
  </div>
	  <input type="hidden" name="id" value =<%=e.getId() %>>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="./css/footer.jsp" %>	
</body>
</html>