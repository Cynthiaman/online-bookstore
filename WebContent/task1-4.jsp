<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<title>注册</title>
<link rel="stylesheet" type="text/css" href="css/css1-4.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">

function submitForm(){	
  $("#formRegister").submit();
  return true;
}
</script>
<script type="text/javascript">
 function fun_getVcode(){
	document.getElementById("vcodeimg1").src = "validatecode?"+Math.random(); 
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
    <li> <div class="nav-title ">欢迎注册</div></li>
    <li><a href="login1-2.html">已注册可直接登录</a></li>
</ul>
</div>
<div class="a2-2">

 <form id="formRegister" name="formRegister" method="post" action="validateServlet">
 <ul class="input1-1 " id="Login_Check">
 <li>
 <input type="text" class="input1-2" placeholder="用户名:手机/邮箱/昵称" name="logonName" id="username" rel="email"> 
  <p class="err-tips mt5 hide" id="p_egoAccountOfEmail_info">邮箱格式不正确</p>
 </li>
 <li> 
<input type="password" class="input1-3" placeholder="密码由6-12位字母组成：" name="password" id="emailLogonPassword" rel="psw1">

    <p class="err-tips mt5 hide" id="p_egoAcctEmailPwd_info">请输入6-20位密码</p>
  </li>
  <li> 
<input type="password" class="input1-4" placeholder="请再次输入上面的密码：" name="PasswordVerify" id="emailLogonPasswordVerify" rel="psw2">

  <p class="err-tips mt5 hide" id="p_egoAcctEmailConfirmPwd_info">请再次输入密码</p>
  </li>
  
  
   <li>
  <input type="text" class="input1-5" rel="emailValCode" name="verifyCode" id="verifyCode" maxlength="4" value="" placeholder="请输入验证码：">
 <input type="hidden" name="uuid" id="uuid" value="196f8850-5bda-4a68-b395-d0547549d4d1">
 <img id="vcodeimg1" src="images/imageCode.htm" width="63" height="29" alt="验证码" onclick="fun_getVcode();">
  <a class="a" href="javascript:void(0);" onclick="fun_getVcode();">换一张</a>
   <p class="err-tips mt5 hide" id="p_emailValCode_info">验证码输入不正确！</p>
            </li>
  </ul>  
  
   
 <div class="btn">
  <a href="javascript:void(0);" onClick="formRegister.submit();">
  <input class="deng" name="deng" type="button" value="注册"  /> </a> 
 </div> 
 
 
 
  <div class="wbox a label-bind zhmm mt10">
            <label><input type="checkbox" class="input-checkbox-a f-les m-tops" id="epp_email_checked"></label>
            <div class="wbox-flex">
              <p>同意WINPINHUI触屏版会员章程</p>
             
              <p class="err-tips mt5 hide" id="epp_email_checked_error">请确认此协议！</p>
            </div>
          </div>
 
 
 
 
 
  </form>
  </div>
</div>
<div id="a3">
<div class="a3-1">
 <a href="#"><img src="images/a3(4).jpg" alt=""></a>
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
