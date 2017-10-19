<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <%@ page import="task2.GoodsInfo1" %>
 <%@page import="java.sql.Connection"%>
 <%@page import="java.sql.*"%>  
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta content="telephone=no" name="format-detection">
<link rel="stylesheet" type="text/css" href="css/css1-1.css">
<link rel="stylesheet" type="text/css" href="css/acss.css">
<title>Insert title here</title>
</head>
<body>
<%@include file="atop.jsp" %>
<%@include file="atop1.jsp" %>


<div id="ff">
 <!--<c:forEach var="goods" items="${requestScope.goodsList}" >
<div id="c3-0">
<img src="${goods.goodsImageAddress4}" width="1200px" height="157px"/> 
</div> 
 </c:forEach>
  -->
<div id="c3-0">
 <img src="images/o1-1.jpg" width="1200px" height="157px"/> 
 </div> 


<div id="c3">
<c:forEach var="goods" items="${requestScope.goodsList}" >
<div class="c3-1">
<img src="${goods.goodsImageAddress}" width="120" height="150" />
          <h3><a href="gwc10014.jsp?keywords3=${goods.goodsName}">${goods.goodsName}</a></h3>
          <p class="details1">发表于<a href="#">${goods.goodsDate}</a> 作者:<a href="#">${goods.goodsAuthor}</a></p>
          <p> ${goods.goodsBrief}<a href="details.jsp">查看更多>></a> </p> 
  
</div>
   </c:forEach>   
</div>
</div>

<%@include file="tk1-4.jsp" %>
</body>
</html>