<%@
	page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="it.contrader.dto.FeedbackDTO"
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="Feedback Edit page">
		<meta name="author" content="Denis La Fauci">
		<link href="/css/vittoriostyle.css" rel="stylesheet">
		<title>Edit Feedback</title>
	</head>

	<body>
		<%@
			include file="./css/header.jsp" 
		%>
		<div class="navbar">
			<a href="/homeadmin.jsp">Home</a>
			<a class="active" href="/feedback/getall">Feedbacks</a>
			<a href="/feedback/logout" id="logout">Logout</a>
		</div>
	
		<br>
	
		<div class="main">
			<%FeedbackDTO f = (FeedbackDTO) request.getSession().getAttribute("dto");%>
			<form id="floatleft" action="/feedbacks/update" method="post">
				<div class="row">
					<div class="col-25">
						<label for="feedbackVote">Vote</label>
					</div>
					
					<div class="col-75">
						<input type="number" id="feedbackVote" name="vote" value=<%=f.getVote()%>>
					</div>
				</div>
      	
      			<div class="row">
					<div class="col-25">
						<label for="feedbackReview">Review</label>
					</div>
					
					<div class="col-75">
						<input type="text" id="feedbackReview" name="review" value=<%=f.getReview()%>>
					</div>
				</div>		
				
				<input type="hidden" name="id" value =<%=f.getId()%>>
				<button type="submit" >Edit</button>
			</form>
	
		</div>
		<br>

		<%@ include file="./css/footer.jsp" %>	
	</body>
</html>