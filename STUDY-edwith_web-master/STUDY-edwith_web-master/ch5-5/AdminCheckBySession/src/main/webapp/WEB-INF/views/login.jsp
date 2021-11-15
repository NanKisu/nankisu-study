<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
	<head>
		<title>Login Page</title>
	</head>
	<body>
		<h1>Login Page</h1>
		<form action="login_submit" method="POST">
			<input type="password" name="password" autofocus required/> 
		</form>
	</body>
</html>
