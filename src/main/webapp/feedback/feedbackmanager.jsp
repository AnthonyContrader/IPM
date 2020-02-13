<%@
	page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"
    import="it.contrader.dto.FeedbackDTO"
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="../css/vittoriostyle.css" rel="stylesheet">
		<title>Feedback Manager</title>
	</head>
	
	<body>
		<%@ include file="../css/header.jsp" %>
		
		<div class = "main">
			<%
				List<FeedbackDTO> list=(List<FeedbackDTO>) request.getAttribute("list");
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
					for (FeedbackDTO f : list){
				%>
				
				<tr>
					<td>
						<a href=FeedbackServlet?mode=read&id=<%=f.getId()%>>
							<%=f.getVote()%>
						</a>
					</td>
					
					<td>
						<%=f.getReview()%>
					</td>
					
					<td>
						<a href=FeedbackServlet?mode=read&update=true&id=<%=f.getId()%>>
							Edit
						</a>
					</td>
										
					<td>
						<a href=FeedbackServlet?mode=delete&id=<%=f.getId()%>>
							Delete
						</a>
					</td>
				</tr>
				<%
					}
				%>
			</table>
			
			<form id="floatright" action="FeedbackServlet?mode=insert" method="post">
				<div class="row">
					<div class="col-25">
						<label for="feedback">
							Vote
						</label>
					</div>
					
			<!-- 	<div class="col-75">
						<input type="text" id="vote" name="vote" placeholder="Insert vote">
					</div>
				</div>
				-->
				
				<div class="col-75">
					<select name="vote">
					<option value="" disabled selected>Choose your option</option>
						<% for (int i=1; i<6; i++) { %>
						<option><%=i %></option>
						<% } %>
					</select>
				</div>
				
				<div class="row">
					<div class="col-25">
						<label for="feedback">
							Review
						</label>
					</div>
					
					<div class="col-75">
						<input type="text" id="feedback" name="review" placeholder="Insert review">
					</div>
				</div>
				
				<button type="submit">
					Insert
				</button>
			</form>
		</div>
		
		<br>
		
		<%@
			include file="../css/footer.jsp"
		%>
	</body>
</html>