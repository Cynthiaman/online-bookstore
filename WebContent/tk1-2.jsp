<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/css1-1.css">
<script type="text/javascript" src="js/ScrollPicLeft.js"></script>
<script type="text/javascript">
function show(post){
		if(document.getElementById(post).style.display=='none'){
			document.getElementById(post).style.display='block';
			}else{
				document.getElementById(post).style.display='none';
			}
	}
	
	var picsArr=new Array();
		picsArr[0]="images/back1-2.png";
		picsArr[1]="images/back1-3.png";
		picsArr[2]="images/back1-4.png";
		picsArr[3]="images/back1-5.png";
		picsArr[4]="images/back1-6.png";	
	var timer,index=0;	
	function showPic(){
		document.getElementById("pic").src=picsArr[index];
		if(index<(picsArr.length-1))
			index++;
		else
			index=(index+1)%picsArr.length;
		timer=setTimeout("showPic()",2000);
	}
	
	function showPrepic()
	{		
		if(index>0)
			index--;
		else
			index=4;
		document.getElementById("pic").src=picsArr[index];
		timer=setTimeout("showPrepic()",2000);
	}
	
	window.onload= function(){
		showPic();
		
	}
</script>

</head>
<body>

<div id="fj1">
<div class="fj1-1">
<div class="box1"><h2>图书分类</h2></div>
<div class="box2">
<ul class="b5-2-1">
<li>
<a href="#">文艺</a>
<a href="#">小说</a>
<a href="#">传记</a>

</li>
</ul>
<ul class="b5-2-1">
<li>
<a href="#">教育</a>
<a href="#">考试</a>
<a href="#">外语</a>
</li>
</ul>

<ul class="b5-2-1">
<li>
<a href="#">人文</a>
<a href="#">历史</a>
<a href="#">心理学</a>
</li>
</ul>
<ul class="b5-2-1">
<li>

<a href="#">生活</a>
<a href="#">美食</a>
<a href="#">运动</a>
</li>
</ul>

<ul class="b5-2-1">
<li>

<a href="#">科技</a>
<a href="#">医学</a>
<a href="#">建筑</a>
</li>
</ul>


<ul class="b5-2-1">
<li>

<a href="#">经管</a>
<a href="#">经济</a>
<a href="#">管理</a>
</li>
</ul>
</div>

</div>
<div class="fj1-2">
<a href="#"><img src="images/back1-5.png" alt="" id="pic" width="690px" height="310px"></a>
</div>
<div class="fj1-3">
<div class="abox3">
<span>最新动态</span>
<ul class="abox3-1">
<li><a href="#">文学励志礼品书，限时抢购</a><br/></li></ul>

<ul class="abox3-1"><li><a href="#">生活礼品书，5折封顶</a><br/></li></ul>
<ul class="abox3-1"><li><a href="#">科技雷满100减50</a><br/>
</li></ul>
<ul class="abox3-1"><li><a href="#">科技雷满100减50</a><br/>
</li></ul>

</div>
<div class="abox4">
 <div class="zl_left" id="Left_Photo"><a href="javascript:void(0)"><img src="images/zl_tb1.jpg" width="24" height="32" /></a></div>
  <div class="zl_content">
    <ul id="ISL_Photo">
     <li><img src="images/40013.jpg" width="120" height="130" /></li>
      <li><img src="images/40015.jpg" width="120" height="130" /></li>
      <li><img src="images/40016.jpg" width="120" height="130" /></li>
      <li><img src="images/40017.jpg" width="120" height="130" /></li>
    </ul>
  </div>
<div class="zl_right" id="Right_Photo"><a href="javascript:void(0)">
<img src="images/zl_tb2.jpg" width="24" height="32" /></a>
</div>
</div>
</div>
</div>
<script type="text/javascript">
	var scrollPhoto = new ScrollPicleft();
	scrollPhoto.scrollContId   = "ISL_Photo"; // 内容容器ID""
	scrollPhoto.arrLeftId      = "Left_Photo";//左箭头ID
	scrollPhoto.arrRightId     = "Right_Photo"; //右箭头ID
	scrollPhoto.frameWidth     = 150;//显示框宽度
	scrollPhoto.pageWidth      = 150; //翻页宽度
	scrollPhoto.speed          = 10; //移动速度(单位毫秒，越小越快)
	scrollPhoto.space          = 10; //每次移动像素(单位px，越大越快)
	scrollPhoto.autoPlay       = false; //自动播放
	scrollPhoto.autoPlayTime   = 1; //自动播放间隔时间(秒)
	scrollPhoto.initialize(); //初始化	
</script>


</body>
</html>