<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
<link href="css/vittoriostyle.css" rel="stylesheet">
</head>
<body>

<form id="floatright" action="SignupServlet?mode=signup" method="post">
	<div class="row">
		<div class="col-25">
	      <label for="user">Username</label>
	    </div>
	    <div class="col-75">
	      <input type="text" id="user" name="username" placeholder="inserisci username">
	    </div>
	</div>
  	<div class="row">
    	<div class="col-25">
     		<label for="pass">Password</label>
    	</div>
    	<div class="col-75">
      		<input type="text" id="pass" name="password" placeholder="inserisci password"> 
    	</div>
    	
  	</div>
    	<button type="submit" >Insert</button>
  </form>

</body>
</html>