<%@
	page import="it.contrader.dto.FeedbackDTO" import="java.util.*"
%>

<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="Feedback Management">
		<meta name="author" content="Denis La Fauci">
		<link href="/css/vittoriostyle.css" rel="stylesheet">
		<title>Feedback Manager</title>
	</head>
	
	<body>
		<%@
			include file="./css/header.jsp"
		%>
		
		<div class="navbar">
			<a href="/homeadmin.jsp">Home</a>
			<a href="user/getall">Users</a>
			<a class="active" href="/feedback/getall">Feedbacks</a>
			<a href="/user/logout" id="logout">Logout</a>
		</div>
		
		<div class="main">
			<%
				List<FeedbackDTO> list = (List<FeedbackDTO>) request.getSession().getAttribute("list");
			%>
			
			<br>
			
			<table>
				<tr>
					<th>Vote</th>
					<th>Review</th>
					<th></th>
					<th></th>
				</tr>
				
				<%
					for (FeedbackDTO f : list) {
				%>
				
				<tr>
					<td>
						<a href="/feedback/read?id=<%=f.getId()%>">
							<%=f.getVote()%>
						</a>
					</td>
					
					<td>
						<%=f.getReview()%>
					</td>
					
					<td>
					<a href="/feedback/preupdate?id=<%=f.getId()%>"><img src="/css/edit.png" height="30" width = "30"></a>
				</td>

				<td>
					<a href="/feedback/delete?id=<%=f.getId()%>"><img src="/css/delete.png" height="30" width = "30"></a>
				</td>
				</tr>
				
				<%
					}
				%>
			</table>
			
			<form id="floatright" action="/feedbacks/insert" method="post">
				<div class="row">
					<div class="col-25">
						<label for="feedbackVote">Vote</label>
					</div>
					
					<div class="col-75">
						<!-- <input type="number" id="feedbackVote" name="vote" placeholder="Insert vote">-->
						<select name="vote" required>
						<option value="" disabled selected>Choose your option</option>
							<% for (int i=1; i<6; i++) { %>
							<option><%=i %></option>
							<% } %>
						</select>
					</div>
				</div>
				
				<div class="row">	
					<div class="col-25">
						<label for="feedbackReview">Review</label>
					</div>
					
					<div class="col-75">
						<input type="text" id="feedbackReview" name="review" placeholder="Insert review">
					</div>
				</div>
				
				<button type="submit">Insert Feedback!</button>
			</form>
		</div>
		
		<br>
		
		<%@
			include file="./css/footer.jsp"
		%>
	</body>
</html>