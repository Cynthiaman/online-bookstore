<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ page import="task3.GoodsInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
request.setCharacterEncoding("utf-8");
String bname=request.getParameter("keywords").trim();
session.setAttribute("keywords", bname);

String strVar=request.getParameter("selected");
session.setAttribute("slectedType", strVar);
%>
 <c:redirect url="GoodsServlet">
	   <c:param name="keywords" value="${sessionScope.keywords }"/>
	   <c:param name="keywords" value="${sessionScope.slectedType }"/>
    	</c:redirect>  
</body>
</html>