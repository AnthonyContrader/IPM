<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.EnvironmentDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit User</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<br>
<div class="main">

<%EnvironmentDTO u = (EnvironmentDTO) request.getAttribute("dto");%>


<form id="floatleft" action="EnvironmentServlet?mode=update&id=<%=u.getId_env()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="environment">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="environment" name="environmentName" value=<%=u.getName()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">Description</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="description" name="environmentDescription" value=<%=u.getDescription()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="type">Usertype</label>
    </div>
   		 <div class="col-75">
 			
    	</div>
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>