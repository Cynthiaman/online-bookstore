<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="task2.GoodsInfo1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String b=request.getParameter("keywords3").trim();
session.setAttribute("keywords3",b);

%>
 <c:redirect url="GoodsServlet10013">
	   <c:param name="keywords3" value="${sessionScope.keywords3 }"/>
    	</c:redirect>  
    	

</body>
</html>