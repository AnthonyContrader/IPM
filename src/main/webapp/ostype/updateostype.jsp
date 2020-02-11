<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.OsTypeDTO"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="../css/vittoriostyle.css" rel="stylesheet">
		<title>Edit OsType</title>
	</head>
		
	<body>
		<%@ include file="../css/header.jsp" %>
		
		<div class="navbar">
		  <a href="homeadmin.jsp">Home</a>
		  <a href="UserServlet?mode=userlist">Users</a>
		  <a class="active" href="OsTypeServlet?mode=ostypelist">OsTypes</a>
		  <a href="LogoutServlet" id="logout">Logout</a>
		</div>
		
		<br>
		
		<div class="main">
		
		<%OsTypeDTO p = (OsTypeDTO) request.getAttribute("dto");%>
		
		
		<form id="floatleft" action="OsTypeServlet?mode=update&id=<%=p.getId()%>" method="post">
		
		  <div class="row">
		    <div class="col-25">
		      <label for="ostype">Name</label>
		    </div>
		    
		    <div class="col-75">
		      <input type="text" id="ostype" name="ostypeName" value=<%=p.getName()%>>
		    </div>
		    
		  </div>
		  
		  <div class="row">
		    <div class="col-25">
		     <label for="command">Command</label>
		    </div>
		    
		    <div class="col-75">
		      <input
					type="text" id="command" name="ostypeCommand" value=<%=p.getCommand()%>> 
		    </div>
		  </div>
		  
		  <button type="submit" >Edit</button>
		  
		</form>
		
			
		</div>
		<br>
		<%@ include file="../css/footer.jsp" %>	
	</body>
</html>