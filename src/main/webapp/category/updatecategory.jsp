<%@
	page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.CategoryDTO"
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="../vittoriostyle.css" rel="stylesheet">
		<title>Edit Category</title>
	</head>
	
	<body>
		<%@
			include file="../css/header.jsp"
		%>
		
		<div class="navbar">
			<a href="homeadmin.jsp">Home</a>
			<a class="active" href="CategoryServlet?mode=categoryList">Categories</a>
			<a href="LogoutServlet" id="logout">Logout</a>
		</div>
		
		<br>
		
		<div class="main">
			<%
				CategoryDTO c = (CategoryDTO) request.getAttribute("dto");
			%>
		
			<form id="floatleft" action="CategoryServlet?mode=update&id_cat=<%=c.getIdCat()%>" method="post">
				<div class="row">
					<div class="col-25">
						<label for="category">Category</label>
					</div>
					
					<div class="col-75">
						<input type="text" id="category" name = "name" value=<%=c.getName()%>>>
					</div>
				</div>
				
				<button type="submit">Edit</button>
			</form>
		</div>
		
		<br>
		
		<%@
			include file="../css/footer.jsp"
		%>
	</body>
</html>