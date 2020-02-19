<%@
	page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="it.contrader.dto.FeedbackDTO"
%>

<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="Feedback Read">
		<meta name="author" content="Denis La Fauci">
		<link href="/css/vittoriostyle.css" rel="stylesheet">
		<title>Read Feedback</title>
	</head>
	
	<body>
		<%@
			include file="./css/header.jsp"
		%>
		
		<div class="navbar">
			<a href="/homeadmin.jsp">Home</a> 
			<a class="active" href="/feedbacks/getall">Feedbacks</a> 
			<a href="/feedback/logout" id="logout">Logout</a>
		</div>
		
		<br>
		
		<div class="main">
			<%
				FeedbackDTO f = (FeedbackDTO) request.getSession().getAttribute("dto");
			%>

			<table>
				<tr>
					<th>ID</th>
					<th>Vote</th>
					<th>Review</th>
				</tr>
			
				<tr>
					<td><%=f.getId()%></td>
					<td><%=f.getVote()%></td>
					<td><%=f.getReview()%></td>
				</tr>
			</table>

			<br> <br> <br> <br> <br> <br> <br>
			<br><br> <br> <br> <br> <br> <br>
		</div>
		
		<%@
			include file="./css/footer.jsp"
		 %>
	</body>
</html>