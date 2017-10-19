<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Trans
<!DOCTYPE html>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta content="telephone=no" name="format-detection">
<link rel="apple-touch-icon-precomposed" href="images/appicon.png">
<link rel="apple-touch-startup-image" href="images/startup.png">
<title>WEIPINHUI</title>
<link rel="stylesheet" type="text/css" href="css/css1-1.css">
<link rel="stylesheet" type="text/css" href="css/acss.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>

<%@include file="atop.jsp" %>
<div id="ff">
<%@include file="atop1.jsp" %>

<div id="a6">
<div class="a6-1">
<ul class="pages">
    <li> <a class="goback" href="javascript:history.back(1)">返回</a></li>
    <li> <div class="nav-title ">图书搜索结果</div></li>
   
 </ul>
</div>
<div class="a6-2">
"<span class="ma3" id="searchKeyword">${requestScope.searchName}</span>"，共找到<span id="productAmount">（${requestScope.goodsCount}）条相关结果。</span>

</div>
<div class="a6-3">
 <ul class="details" >
     <c:forEach var="goods" items="${requestScope.goodsList}"   begin="${currentPage*2-2 }" end="${currentPage*2-1}" >	
      <li>
        <a href="gwc10014.jsp?keywords3=${goods.goodsName}">
          <div class="details-3">
            <div class="details-4">
            <img width="130" height="130" src="${goods.goodsImageAddress}" alt="${goods.goodsName}">
            </div>
              <p class="pro-name">${goods.goodsCode}</p>
              <p class="pro-name">${goods.goodsName}</p>
              <p class="pro-name">${goods.goodsAuthor}</p>
              <p class="mt5">
              <span class="snPrice" style="font-size:14px;">¥ ${goods.goodsPrice}</span>
              </p>
               <p class="pleft">
               
                   <img src="images/buybutton.gif" width="71" height="21" border="0" />
       
              </p>
          </div>
          </a>
          <span class="arrow"></span>
      </li>
    </c:forEach>	
    <p align="center">
       <!--  跳转到：<input type="text" name="page" size="3"/> -->当前页数：[${requestScope.currentPage }/${ requestScope.maxPage} ] 
       <c:if test="${currentPage >1}">
        <a href="GoodsServlet?page=1">第一页</a> 
        <a href="GoodsServlet?page=${currentPage-1 }">上一页</a> 
        </c:if>
            
        <c:if test="${currentPage < maxPage}">
        <a href="GoodsServlet?page=${currentPage+1 }">下一页</a> 
        <a href="GoodsServlet?page=${maxPage }">最后一页  </a> 
         </c:if>
        
    </p>	 	 
    </ul>
   
</div>

</div>
<%@include file="tk1-4.jsp" %>
 </div>

</body>
</html>
    