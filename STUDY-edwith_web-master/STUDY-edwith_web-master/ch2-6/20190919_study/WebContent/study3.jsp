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
		<c:set scope="page" var="var1" value="JSTL"/>
		<c:set scope="page" var="var2" value="JSTL"/>
		var1 : ${var1}<br>
		var2 : ${var2}<br>
		<c:remove var="var1"/>
		<c:set scope="page" var="var2" value=""/>
		var1 : ${var1}<br>
		var2 : ${var2}<br>
		var1 : <%= pageContext.getAttribute("var1") %><br>
		var2 : <%= pageContext.getAttribute("var2") %><br>
	</body>
</html>