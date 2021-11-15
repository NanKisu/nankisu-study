<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Home.jsp</h1>
	<form action="/RequestMapping/study1/datetimeformat">
		<input type="text" name="text" />
	</form>
	<form action="/RequestMapping/study1/numberformat">
		<input type="text" name="text" />
	</form>
	<h2>message: ${message}</h2>
</body>
</html>