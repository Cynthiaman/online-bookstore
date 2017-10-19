<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<title>购物车</title>
<link rel="stylesheet" type="text/css" href="css/gwc.css" />
<link rel="stylesheet" type="text/css" href="css/module.css" />
<link rel="stylesheet" type="text/css" href="css/cart.css" />
<link rel="stylesheet" type="text/css" href="css/css1-1.css">
<link rel="stylesheet" type="text/css" href="css/acss.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/snmwshopCart1.js"></script>
<script type="text/javascript" src="js/snmwshopCart1_v2.js"></script>

<script type="text/javascript">
  	function updateNum(code,num,price,flag){
  		var q=parseInt(num);
  		if(flag=="add"){
  		  q++;
    	}
  		else{
  			q--;
  		}
  		var num1=q.toString();
  		var url = "buy?action=update&code="+code+"&num="+num1+"&price="+price;
  		window.location = url;
  	}
  	function changeNum(code,num,price){
  		var url = "buy?action=update&code="+code+"&num="+num+"&price="+price;
  		window.location = url;
  	}
  	function deleteCartItem(a,code) {
  	    $(a).addClass("delete");
  	    if (confirm("确认删除吗？")) {
  	        var b = $(a).prev("input").val();
  	        var url = "buy?action=del&code="+code;
    		window.location = url;
  	    } else {
  	        $(a).removeClass("delete")
  	    }
  	} 
  	function clearCart(){
  		var url = "buy?action=clear";
  		window.location = url;
  	}
</script>  

</head>
<body>
<%@include file="atop.jsp" %>
<div id="ff">
<%@include file="atop1.jsp" %>
<div id="gwc">
<!--<div id="gwc1">
 <div class="gwc1-1">
<ul class="gwc1-2">
<li>
<a href="javascript:history.back(1)">返回</a>
<a href="#">购物车</a>
</li>
</ul>
</div>
</div> -->
  <c:forEach var="cart" items="${requestScope.cartList1}">	
<div id="gwc23">
        <div class="mr10" style="margin-top:32px;">
          <input type="checkbox" class="input-checkbox-a" name="checkbox_1" id="checkbox_1" checked="CHECKED">
        </div>
        
<div id="gwc2">
<a href="" title="${cart.goodsName}"><img src="${cart.goodsImageAddress}" alt="${cart.goodsName}" width="100px" height="120px" /></a>
</div>
<div id="gwc3">
 <p><span class="attr">名称：</span>${cart.goodsCode}</p>
<p class="pro-name">
 <span><a id="" href="" title="${cart.goodsName}">${cart.goodsName}</a><br /></span>
</p>
 <div class="gwc3-count">
<span class="attr">数量:</span>
  <div class="gwc3-countArea">
  <a href="javascript:void(0)" class="min" onclick="lesV2(this,&#39;1&#39;);updateNum('${cart.goodsCode}',${cart.goodsNumber},${cart.goodsPrice},'min');"></a>
  <input class="count-input" type="text" value="${cart.goodsNumber}" 
            onChange="javascript:changeNum('${cart.goodsCode}',this.value,${cart.goodsPrice});"
            name="quantity" id="quantity"            >
            <a href="javascript:void(0)" class="add" onclick="addV2(this,&#39;1&#39;);updateNum('${cart.goodsCode}',${cart.goodsNumber},${cart.goodsPrice},'add');"></a>
            </div>   
             </div>
<p>
<span class="attr">WINPINHUI价：</span>
<span class="price">￥${cart.goodsPreferentialPrice}</span>
</p>
<div class="trash" onclick="javascript:deleteCartItem(this);">
<span class="lid"></span><span class="can"></span></div>

</div>
   
</div>

  <div class="a5 mt5" name="error_message" id="error_message_1"></div>
     </c:forEach>   
 
 <c:forEach var="cart2" items="${requestScope.cartList2}">	   
<p class="gwc3-mt5">
<span >总计：<em id="userPayAllprice">￥${cart2.payAll}</em></span>
<span id="promotionAmountSpan">-优惠：<em id="totalPromotionAmount">￥${cart2.promotionAmount}</em></span>
</p>

<p class="gwc3-mt5"><span>应付总额（未含运费）：</span><span class="price">
<em id="userPayAllpriceList">￥${cart2.payAll}</em></span>
</p>
  </c:forEach>   

<div class="gwc-btn bta" id="checkOutbutton">
<a name="" title="去结算">去结算</a></div>
<div class="gwc-btn btb" id="checkOutbutton">
<a name="" title="继续购物">&lt;&lt;继续购物</a></div>
<div class="gwc-btn btc" id="checkOutbutton">
<a name="" title="清空购物车" href="javascript:;" onclick="clearCart();">清空购物车</a></div>

</div>
<%@include file="tk1-4.jsp" %>
</div>
 
</body>
</html>