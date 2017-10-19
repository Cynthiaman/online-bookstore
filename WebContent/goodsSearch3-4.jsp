<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
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
String a=request.getParameter("keywords2").trim();
session.setAttribute("keywords2",a);

%>
 <c:redirect url="GoodsServlet2">
	   <c:param name="keywords2" value="${sessionScope.keywords2 }"/>
    	</c:redirect>  
    	

</body>
</html>