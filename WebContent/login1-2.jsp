<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/css1-2.css">

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="validate.js" ></script>
<script type="text/javascript">
 function fun_getVcode(){
	document.getElementById("vcodeimg1").src = "validatecode?"+Math.random(); 
} 
</script>
<!--省略的JavaScript代码如表5-所示-->
</head>
<body>






<script type="text/javascript">
function checkForm(){
  var retFlag = true;
  var email2 =  $("#email2").val();
  var password = $("#password").val();
  if(email2 == ""){
	retFlag = false;
  }
  if (password == null || password == "") {
	retFlag = false;
  }
  return retFlag;
}

function submitForm(){
  if(!checkNormalLogonId() || !checkNormalLogonPwd()) {
	return;
  }
  if(checkForm()){
  $("#formlogon").submit();
  return true;
  }else{
  return false;
  }
}

</script>

</head>
<body>
<div id="ff">
<div id="a1">
     <div class="logo"><h1><a href="#">WEIPINHUI</a></h1></div>
     <div class="logo"><h4><a href="#">七天可退换</a></h4></div>
     <div class="logo"><h4><a href="#">正品保证</a></h4></div>
</div>
<div id="a2">
<div class="a2-1">
 <ul class="pages">
    <li> <a class="goback" href="javascript:history.back(1)">返回</a></li>
    <li> <div class="nav-title ">用户登录</div></li>
    <li><a href="#">注册</a></li>
 </ul>
</div>
<div class="a2-2">

 <form id="formlogon" name="formlogon" method="post" action="validateYZMServlet">
 <ul class="input1-1 " id="Login_Check">
 <li>
 <input type="text" class="input1-2" placeholder="用户名:手机/邮箱/昵称" name="logonName" id="logonName"> 
 </li>
 <li> 
<input type="password" class="input1-3" placeholder="密码：" name="password" id="password">
  </li>
  
   <li>
                 <input type="text" class="input1-4"  id="validate" name="verifyCode" maxlength="4"  placeholder="请输入验证码：">
            <!--  <input type="hidden" name="uuid" id="uuid" value="196f8850-5bda-4a68-b395-d0547549d4d1">--> 
              
              
              
              <img id="vcodeimg1" src="validatecode" width="63" height="29" alt="验证码" onclick="fun_getVcode();">
            
              <a class="a" href="javascript:void(0);" onclick="fun_getVcode();">换一张</a>
              <p class="err-tips mt5 hide" id="p_emailValCode_info">验证码输入不正确！</p>
            </li>
  
  </ul>   
 <div class="btn">
  <a href="javascript:void(0);" onClick="formlogon.submit();">
  <input class="deng" name="deng" type="button" value="登录"  /> </a> 
</div> 

 
 


  </form>

  </div>
</div>
<div id="a3">
<div class="a3-1">
 <a href="#"><img src="images/a3.jpg" alt=""></a>
</div>
</div>
</div>
<div id="ff2">
 <ul class="f1">
   <li>
      <a href="#">关于我们 |</a>
      <a href="#"> 了解更多 |</a>
      <a href="#"> 联系我们 |</a>
      <a href="#"> 爱心基金 </a>
 </li>
 </ul>  
   <p> copyright@2012-2018版权所有 使用本网站积接受WEIPINHUI用户协议 WEIPINHUI有限公司</p></div>


</body>
</html>
