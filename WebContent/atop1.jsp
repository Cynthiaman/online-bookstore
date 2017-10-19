<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ page import="task3.GoodsInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>导航栏</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
  $(function(){
  pHolder();
  });
  //顶部搜索框获取焦点后文本变空
  function pHolder(){
	var elem = $("#keywordsTop");
	var dValue = $("#keywordsTop").val();
	elem.focus(function(){
	  if(elem.val() == dValue){
	     elem.val("");
	    }
	  });
	  elem.blur(function(){
		if(elem.val() == ""){
		   elem.val(dValue);
	  }
	});
  }
</script>
</head>
<body>
<div id="a1">
<div class="a1-1">
  <h1><a href="#">WEIPINHUI</a></h1>
</div>
<div class="a1-4">
<form  action="goodsSearch3-3.jsp" method="post" name="formSearch">
 <select name="selected" class="selected" > 
       <option selected>请选择</option>
       <option value="图书名称">图书名称</option>
       <option value="作者">作者</option>
       <option value="类型">类型</option>
   </select>
   <input type="search" name="keywords" id="keywordsTop" class="search-input" value="可按书名/作者/类型查询">
    <!-- 选择列表 -->
    
   <input type="submit" class="search-btn" value="检索" >
</form>
</div>
</div>
<div id="a2">
<div class="a2-1">
  <ul class="a2-3">
    <li><a href="#">特别关注</a></li>
           <li><a href="#">苏宁易购</a></li>
           <li><a href="#">天猫国际</a></li>
           <li><a href="#">精彩活动</a></li>
           <li><a href="#">文学小说</a></li>
           <li><a href="#">少儿家教</a></li>
</ul>
  <ul class="a2-2">
    <li><a href="#">图书销量榜</a></li>
    <li><a href="#">新品排行榜</a></li>
    <li><a href="#">销量排行榜</a></li>
    <li><a href="#">新书店</a></li>
    <li><a href="goodsSearch3-4.jsp?keywords2=教材辅导">教材辅导</a></li>
    <li><a href="goodsSearch3-4.jsp?keywords2=少儿">少儿</a></li>
    <li><a href="goodsSearch3-4.jsp?keywords2=文学">文学</a></li>
    <li><a href="goodsSearch3-4.jsp?keywords2=小说">小说</a></li>
  </ul>
</div>
</div>
</body>
</html>