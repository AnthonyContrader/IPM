<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.EnvironmentDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Environment Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="main">
	<%
		List<EnvironmentDTO> list = (List<EnvironmentDTO>) request.getAttribute("list");
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
			for (EnvironmentDTO e : list) {
		%>
		<tr>
			<td><a href=EnvironmentServlet?mode=read&id=<%=e.getId()%>>
					<%=e.getName()%>
			</a></td>
			<td><%=e.getDescription()%></td>
			<td><a href=EnvironmentServlet?mode=read&update=true&id=<%=e.getId()%>>Edit</a>
			</td>
			<td><a href=EnvironmentServlet?mode=delete&id=<%=e.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="EnvironmentServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for=environment>Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="packet" name="name" placeholder="inserisci name">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="environment">Description</label>
    </div>
    <div class="col-75">
      <input type="text" id="packet" name="description" placeholder="inserisci description"> 
    </div>
  </div>
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>