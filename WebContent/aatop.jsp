<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <%@ page import="task.CounterListener2_4"%>
 <%@ page import="task5.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/acss.css">
</head>
<body>
<%
   //String strName=request.getParameter("logonName").trim();
 //  session.setAttribute("username",strName);
 
  String info=(String)request.getAttribute("info");
 if(info !=null){
	out.println(info);
}
UserInfo user=(UserInfo)session.getAttribute("loginUser");
if(user!=null){
	 //out.println("<script>alert('欢迎光临WINPINHUI');</script>"); 
	 
	// out.println("欢迎"+user.getName()+"光临易购网"); 
	 

} 
 
 
%>

<%
  // String name=(String)session.getAttribute("username");
%>

<div id="atop">
<div class="atop1-1">
<div class="atop01">
<ul class="atop1-2">
<li>
<span>欢迎来到WEIPINHUI</span>
<a href="#">您好，<%=user.getName()%></a>
<a href="#">免费注册</a>
</li>
</ul>

<ul class="atop1-3">
<li>
<a href="#">签到有礼</a>
<a href="#">我的订单</a>
<a href="#">我的购物车</a>
<a href="#">商品分类</a>
<a href="#">联系客服</a>
 <a href="#">当前在线人数有<%=CounterListener2_4.getOnlineNumber()%>人</a> 
<a href="atask1-1.jsp">返回首页</a>
</li>
</ul>
</div>
</div>
</div>
</body>
</html>