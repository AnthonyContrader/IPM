<%@page import="it.contrader.dto.OsTypeDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="OsType Edit page">
<meta name="author" content="Aleksandra Vysitska">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>OsType Packet</title>
</head>
<body>

	<%@ include file="./css/header.jsp" %>
<div class="navbar">
  <a href="/homeadmin.jsp">Home</a>
  <a href="/user/getall">Users</a>
  <a class="active" href="/ostype/getall">OS Types</a>
  <a href="/user/logout" id="logout">Logout</a>
</div>
<br>

<div class="main">

<%OsTypeDTO o = (OsTypeDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/ostype/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="ostype">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="ostype" name="name" value=<%=o.getOsType()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="command">Description</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="command" name="command" value=<%=o.getCommand()%>> 
    </div>
  </div>
	  <input type="hidden" name="id" value =<%=o.getId()%>>
      <button type="submit" >Edit</button>
</form>

</body>
</html>