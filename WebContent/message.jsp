<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="task5.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>提示信息</title>
</head>
<body>
<%
 String info=(String)request.getAttribute("info");
 if(info !=null){
	out.println(info);
}
 //UserInfo user=(UserInfo)session.getAttribute("loginUser");
 //if(user!=null){
	// out.println("<script>alert('欢迎光临WINPINHUI');</script>"); 
	 
	// out.println("欢迎"+user.getName()+"光临易购网"); 
	 

// } 
 
 
  out.print("<script>location.href='atask2-1.jsp';</script>");
%>
 
	
</body>
</html>