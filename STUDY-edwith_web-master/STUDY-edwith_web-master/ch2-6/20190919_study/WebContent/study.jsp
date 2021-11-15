<%@ page 
	language="java" 
	contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
%>
<%
	pageContext.setAttribute("var1", "pageScope var1");
	request.setAttribute("var1", "requestScope var1");
	session.setAttribute("var2", "sessionScope var2");
	application.setAttribute("var3", "applicationScope var3");
	int var4 = 1994;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>Insert title here</title>
	</head>
	<body>
		${pageScope.var1}<br/>
		${requestScope.var1}<br/>
		${sessionScope.var2}<br/>
		${applicationScope.var3}<br/>
		${var1}<br/>
		v2
	</body>
</html>