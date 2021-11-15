<%@ page 
	language="java" 
	contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	pageContext.setAttribute("var1", 10);
	pageContext.setAttribute("var2", "10");
	pageContext.setAttribute("var3", true);
	pageContext.setAttribute("var4", false);
	pageContext.setAttribute("var5", "true");
	pageContext.setAttribute("var6", "false");
	pageContext.setAttribute("var7", "test");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>Insert title here</title>
	</head>
	<body>
		<c:if test="true">
			if1 True<br/>
		</c:if>
		<c:if test="false">
			if2 True<br/>
		</c:if>
		<c:if test="0">
			if3 True<br/>
		</c:if>
		<c:if test="1">
			if4 True<br/>
		</c:if>
		<c:if test="${var3}">
			if5 True<br/>
		</c:if>
		<c:if test="${var4}">
			if6 True<br/>
		</c:if>
		<c:if test="${var5}">
			if7 True<br/>
		</c:if>
		<c:if test="${var6}">
			if8 True<br/>
		</c:if>
		<c:if test="${var7}">
			if9 True<br/>
		</c:if>
		<c:choose>
			<c:when test="${var2}">
				when1 True<br/>
			</c:when>
			<c:when test="${var5}">
				when2 True<br/>
			</c:when>
			<c:when test="${var6}">
				when3 True<br/>
			</c:when>
			<c:when test="${var7}">
				when4 True<br/>
			</c:when>
			<c:otherwise>
				otherwise
			</c:otherwise>
		</c:choose>
	</body>
</html>