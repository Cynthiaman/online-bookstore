<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <title>搜索商品列表</title>
  </head>  
  <body>
	<c:redirect url="GoodsServlet">
	   <c:param name="keywords" value=""/>
	</c:redirect>
  </body>
</html>
