<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" import="java.util.List"
import="it.contrader.dto.OsTypeDTO"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link href="../css/vittoriostyle.css" rel="stylesheet">
	<title>OS TYPE Manager</title>
</head>

<body>
	<%@ include file="../css/header.jsp" %>
	<div class="navbar">
  		<a  href="homeadmin.jsp">Home</a>
  		<a class="active" href="OsTypeServlet?mode=ostypelist">OS Types</a>
  		<a href="LogoutServlet" id="logout">Logout</a>
  	</div>
  	
  	<div class="main">
  		<%List<OsTypeDTO> list = (List <OsTypeDTO>) request.getAttribute("list");%>
  		<br>
  		<table>
  			<tr>
  				<th>Name</th>
  				<th>Command</th>
  				<th></th>
  				<th></th>
  			</tr>
  			<%for (OsTypeDTO u : list) { %>
  			<tr>
  			<td><a href=OsTypeServlet?mode=read&id=<%=u.getId()%>>
  			<%=u.getName()%>
			</a></td>
			<td><%=u.getCommand()%></td>
			<td><a href=OsTypeServlet?mode=read&update=true&id=<%=u.getId()%>>Edit</a></td>
			<td><a href=OsTypeServlet?mode=delete&id=<%=u.getId()%>>Delete</a></td>
			
		</tr>
		<%
			}
		%>
  		</table>
  		
  		<form id="floatright" action="OsTypeServlet?mode=insert" method="post">
  			 <div class="row">
	    		<div class="col-25">
	      			<label for="ostype">Name</label>
				</div>
				<div class="col-75"> <input type="text" id="ostype" name="name" placeholder="inserisci il nome"></div>
			</div>
  			<div class="row">
	    		<div class="col-25">
	      			<label for="ostype">Command</label>
				</div>
				<div class="col-75"> <input type="text" id="ostype" name="comm" placeholder="inserisci il comando"></div>
			</div>
			<button type="submit" >Insert</button>
  		</form>
  	</div>
  	<br>

<%@ include file="../css/footer.jsp" %>
</body>
</html>