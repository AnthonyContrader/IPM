<%@
	page import="it.contrader.dto.CategoryDTO" import="java.util.*"
%>

<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="Category Management">
		<meta name="author" content="Denis La Fauci">
		<link href="/css/vittoriostyle.css" rel="stylesheet">
		<title>Category Manager</title>
	</head>
	
	<body>
		<%@
			include file="./css/header.jsp"
		%>
		
		<div class="navbar">
			<a href="/homeadmin.jsp">Home</a>
			<a href="user/getall">Users</a>
			<a class="active" href="/categories/getall">Categories</a>
			<a href="/user/logout" id="logout">Logout</a>
		</div>
		
		<div class="main">
			<%
				List<CategoryDTO> list = (List<CategoryDTO>) request.getSession().getAttribute("list");
			%>
			
			<br>
			
			<table>
				<tr>
					<th>Name</th>
					<th></th>
					<th></th>
				</tr>
				
				<%
					for (CategoryDTO c : list) {
				%>
				
				<tr>
					<td>
						<a href="/categories/read?id=<%=c.getId()%>">
							<%=c.getName()%>
						</a>
					</td>
					
					<td>
						<a href="/categories/preupdate?id=<%=c.getId()%>">Edit</a>
					</td>
					
					<td>
						<a href="/categories/delete?id=<%=c.getId()%>">Delete</a>
					</td>
				</tr>
				
				<%
					}
				%>
			</table>
			
			<form id="floatright" action="/categories/insert" method="post">
				<div class="row">
					<div class="col-25">
						<label for="categoryName">Name</label>
					</div>
					
					<div class="col-75">
						<input type="text" id="categoryName" name="name" placeholder="Insert category name">
					</div>
				</div>
				
				<button type="submit">Insert Category!</button>
			</form>
		</div>
		
		<br>
		
		<%@
			include file="./css/footer.jsp"
		%>
	</body>
</html>