<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<html>
<head>
<link href="css/vittoriostyle.css" rel="stylesheet">

<title>Login SAMPLE</title>
</head>
<body>
		<form class="login" name="loginName" action="LoginServlet" method="post" onsubmit="return validate();">

				<label for="user">Username: </label>
			
				<input type="text" id="user" name="username" placeholder="Insert username">
		
				<label for="pass">Password: </label>
			
				 <input type="password" id="pass" name="password" placeholder="Insert password">
		
			<button type="submit" value="Login" name="pulsante">Login</button>
		</form>

		<script type="text/javascript">
            function validate() {
                var user = document.getElementById("user");
                var pass = document.getElementById("pass");

                if ( user.value.length <= 0 ) {
                	alert("Insert a valid username!");
                	return false;
                }
                else if ( pass.value.length <=0 ){
                	alert("Insert a valid password!");
                	return false;
                }

                return true;
            };
        </script>
</body>
</html>