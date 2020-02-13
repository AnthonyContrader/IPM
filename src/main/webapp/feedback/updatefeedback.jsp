<%@
	page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.FeedbackDTO"
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="../vittoriostyle.css" rel="stylesheet">
		<title>Edit feedback</title>
	</head>
	
	<body>
		<%@
			include file="../css/header.jsp"
		%>
		
		<br>
		
		<div class="main">
			<%
				FeedbackDTO f = (FeedbackDTO) request.getAttribute("dto");
			%>
			
			<form id="floatLeft" action="FeedbackServlet?mode=update&id=<%=f.getId()%>" method="post">
				<div class="row">
					<div class="col-25">
						<label for="feedback">Vote</label>
					</div>
					
					<div class="col-75">
						<select name="vote" required>
						<option value="" disabled selected>Choose your option</option>
							<% for (int i=1; i<6; i++) { %>
							<option><%=i %></option>
							<% } %>
						</select>
					</div>
				</div>
				
				<div class="row">
					<div class="row">
						<div class="col-25">
							<label for="feedback">Review</label>
						</div>
						
						<div class="col-75">
							<input type="text" id="feedback" name="review" value=<%=f.getReview()%>>
						</div>
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