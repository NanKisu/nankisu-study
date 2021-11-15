<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>home</h1>
	<form action="/webapp/study/beansandvalidation" method="POST">
		<h2>input: <input type="text" name="text" /></h2>
	</form>
	<form action="/webapp/study2/requestbody" method="POST">
		<h2>input: <input type="text" name="text" /></h2>
	</form>
	<h2>[message: ${message}]</h2>
	<h2>[message2: ${message2}]</h2>
	<h2>[param message: ${param.message}]</h2>
</body>
</html>