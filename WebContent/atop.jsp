<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/acss.css">
</head>
<body>
<div id="atop">
<div class="atop1-1">
<div class="atop01">
<ul class="atop1-2">
<li>
<span>欢迎来到WEIPINHUI</span>
<a href="login1-2.jsp">请先登录</a>
<a href="task1-4.jsp">免费注册</a>
</li>
</ul>
<ul class="atop1-3">
<li>
<a href="#">签到有礼</a>
<a href="#">我的订单</a>
<a href="#">购物车</a>
<a href="#">商品分类</a>
<a href="#">联系客服</a>
<a hre="#">您是第<%=application.getAttribute("count") %>位访问者</a>
<a href="atask1-1.jsp">返回首页</a>
</li>
</ul>
</div>
</div>
</div>
</body>
</html>