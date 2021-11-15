<%@page import="sun.misc.Request"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	request.setAttribute("from", "study3.jsp");
	RequestDispatcher rd = request.getRequestDispatcher("/study4.jsp");
	rd.forward(request, response);
%>