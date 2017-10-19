<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <%@page import="java.sql.Connection"%>
 <%@page import="java.sql.*"%>  
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ page import="task2.GoodsInfo1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta content="telephone=no" name="format-detection">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/css2-2.css">

<script  type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript">
$(function(){
$(".box1 div img").addClass("alpha");
$(".box1 div img:eq(0)").removeClass("alpha");
$(".box1 div img").mouseover(function(){
var big_src = $(this).attr("src");
$("#test").attr("src",big_src);
$(this).removeClass("alpha").siblings().addClass("alpha");
});
});
</script>
</head>
<body>
<%@include file="atop.jsp" %>
<%@include file="atop1.jsp" %>
	
<div id="ff">
 
<div id="a3"><div class="a3-1"> <h2>图书信息</h2></div>
<div class="box">
<c:forEach var="goods" items="${requestScope.goodsList}" >
  <div class="box1">
    <img id="test" title="test" src="${goods.goodsImageAddress}" /><br />
    <div  class="box2">
      <img src="${goods.goodsImageAddress1}" />
      <img src="${goods.goodsImageAddress2}" />
      <img src="${goods.goodsImageAddress3}"/>
    </div>
   </div>  
 </c:forEach>
</div>

 <div class="abox">
     <c:forEach var="goods" items="${requestScope.goodsList}" >
 <div class="abox1">
 <h2>${goods.goodsName}</h2>
 <span>${goods.goodsBrief}</span>

<ul class="abox1-1">
 <li>
 <a href="#"><span>作者:</span>${goods.goodsAuthor}</a>
 <a href="#"><span>出版社:</span>${goods.goodsPublish}</a>
 <a href="#"><span>出版日期:</span>${goods.goodsDate}</a>
 </li></ul>
 </div>
 
 
 <div class="abox2">
<p>图书价格</p> 
  <a href="#">￥${goods.goodsPreferentialPrice}<em>￥${goods.goodsPrice}</em></a> 
  </div>
  
   <div class="abox3">
   <h2>促销</h2>
   <a href="#">登录</a> 
   <span>后是否享有此优惠</span> 
   </div>
  </c:forEach>
 
     
   <c:forEach var="goods" items="${requestScope.goodsList}" >    
   <div class="abox4">
  
   <a href="buy?action=add&code=${goods.goodsName }">
   <img src="images/buybutton.gif" width="71" height="21" border="0" />
   </a>
   

    </div>
    </c:forEach>
</div>
<div class="cbox">

<h2>WEIPINHUI自营</h2>
<ul class="cbox1">
<li>
<a href="#">正品保证</a><br/>
<a href="#">服务支持</a><br/>
<a href="#">15天换货</a><br/>
<a href="#">7天无理由退货</a><br/>
<a href="#">7天无理由退货</a><br/>

</li></ul>
</div> 
</div>
</div>
<%@include file="tk1-4.jsp" %>
</body>
</html>