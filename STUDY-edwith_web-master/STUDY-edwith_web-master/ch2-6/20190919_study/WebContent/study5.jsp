<%@ page 
	language="java" 
	contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>Insert title here</title>
	</head>
	<body>
		<c:set var="list" scope="page" value="${[0,1,2,3,4]}"/>	
		<c:forEach items="${list}" var="num">
			${num}<br/>
		</c:forEach>
		<c:import url="/study.jsp" var="result"/>
		${result}
	</body>
</html>