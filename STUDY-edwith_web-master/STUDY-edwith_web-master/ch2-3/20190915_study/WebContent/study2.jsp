<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%! 
	public void jspInit(){
		System.out.println("jspInit()");
	}
	public void jspDestroy(){
		System.out.println("jspDestroy()");
	}
	public void jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
	     throws java.io.IOException, javax.servlet.ServletException {
		System.out.println("Service2()");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>Insert title here</title>
	</head>
	<body>
		<% System.out.println("Service()"); %>
	</body>
</html>