<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<c:forEach items="${guestBooks}" var="guestBook">
			${guestBook.id }<br>
			${guestBook.name }<br>
			${guestBook.content }<br>
			${guestBook.regdate }<br>
			<br/>
		</c:forEach>
		
		<c:forEach var="cnt" begin="1" end="${count}">
			<a href="list?start=${(cnt - 1) * 5}">${cnt}</a>&nbsp; &nbsp;
		</c:forEach>
		
		<form action="write" method="POST">
			name : <input type="text" name="name"><br>
			<textarea name="content" cols="60" rows="6"></textarea>
			<br> <input type="submit" value="등록">
		</form>
	</body>
</html>