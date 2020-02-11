<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.OsTypeDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit OS</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active" href="OsTypeServlet?mode=ostypelist">OS Types</a>
  <a href="LogoutServlet" id="logout">Logout</a>
  
  
  <br>
  <div class="main">

<%OsTypeDTO u = (OsTypeDTO) request.getAttribute("dto");%>


<form id="floatleft" action="OsTypeServlet?mode=update&id=<%=u.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="ostype">OS Types</label>
    </div>
    <div class="col-75">
      <input type="text" id="ostype" name="name" value=<%=u.getName()%>>
    </div>
  </div>
  
  
  <div class="row">
    <div class="col-25">
     <label for="ostype">Command</label>
    </div>
    <div class="col-75">
    <input type="text" id="ostype" name="comm" value=<%=u.getCommand()%>>
  </div>
  </div>
  
  
      <button type="submit">Edit</button>
</form>

	
</div>


</div>
</body>

<br>
<%@ include file="../css/footer.jsp" %>	
</html>