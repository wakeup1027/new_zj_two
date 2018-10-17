<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String dataty = request.getParameter("dataty");
String fdid = request.getParameter("fdid");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/video-js.min.css">
    <link href="css/select2.min.css" rel="stylesheet" />
    <title>查看信息-详情界面</title>
</head>

<body>
	<header class="w">
		<div class="logo-con fl">
			<a href="index.jsp"><img src="images/logo.png" alt="" class="logo-ico"><img src="images/font.png" alt="" class="logo-font"></a>
		</div>
		<div class="search-con fr">
			<span class="search-input"><input type="text" id="s_input" class="s_input" placeholder="请输入您要查找的文件及信息" /></span>
			<span class="search-btn"><input type="button" class="s_btn"></span>
		</div>
		<div id="obsoluje" style="width:100px; position:absolute;">
			<select id="select-model" class="select2" style="width:120px;">
				<option value="0">全系统</option>
				<option value="1">投资动态</option>
				<option value="2">新闻媒介</option>
				<option value="3">了解我们</option>
				<option value="4">投资项目</option>
				<option value="5">投资政策</option>
				<option value="6">投资成本</option>
				<option value="7">重点企业</option>
				<option value="8">投资流程</option>
				<option value="9">职能部门联系</option>
				<option value="10">投资目录</option>
				<option value="11">资料下载</option>
				<option value="12">答疑解惑</option>
				<option value="13">石化园区</option>
				<option value="14">钢铁配套园区</option>
				<option value="15">中央商务区</option>
			</select>
		</div>
	</header>
  <section class="nav">
    <div class="w">
      <a href="index.jsp"><i><img src="images/icon1.png" alt=""></i><p>首页</p></a>
      <a href="new-content.jsp"><i><img src="images/icon2.png" alt=""></i><p>新闻中心</p></a>
      <a href="invest-environment.jsp"><i><img src="images/icon3.png" alt=""></i><p>投资环境</p></a>
      <a href="invest-service.jsp"><i><img src="images/icon4.png" alt=""></i><p>投资服务</p></a>
      <a href="profession-garden.jsp"><i><img src="images/icon5.png" alt=""></i><p>专业园区</p></a>
      <a href="contact-us.jsp"><i><img src="images/icon6.png" alt=""></i><p>联系我们</p></a>
    </div>
  </section>
  <section class="env-content w">
	  <div class="left-nav" style="background-color: #004b8b;">
	      <div class="lf-t n-title">
	        <p class="t-small">press</p>
	        <p class="t-big">center</p>
	        <h3 class="t-main">文章详情</h3>
	      </div>
	      <!-- ul>
	        <li><a href="invest-environment.jsp">了解我们</a></li>
	        <li><a href="invest-project.jsp">投资项目</a></li>
	        <li class="active"><a href="javascript:;">投资政策</a></li>
	        <li><a href="invest-cost.jsp">投资成本</a></li>
	        <li><a href="invest-importprise.jsp">重点企业</a></li>
	      </ul -->
	      <ul>
	        <li style="border:none;"></li>
	        <li style="border:none;"></li>
	        <li style="border:none;"></li>
	        <li style="border:none;"></li>
	        <li></li>
	      </ul>
	    </div>
	    <div class="right-container">
	      <div class="right-con">
	        <div class="r_navigator">
	          <span class="locTip">您现在的位置是:</span>
	          <span><a href="index.jsp">首页</a>&nbsp;>&nbsp;</span>
	          <span class="cur"><a href="javascript:;">文章详情</a></span>
	        </div>
	        <!-- div class="r_secNav">
	          <ul class="clearfix">
	            <li class="active"><a href="javascript:;">湛江开发区情况</a></li>
	            <li><a href="javascript:;">投资优势</a></li>
	            <li><a href="javascript:;">经济发展状况</a></li>
	            <li><a href="javascript:;">开发区规划</a></li>
	          </ul>
	        </div-->
	        <div class="r_con">
	          <div>
		    	<div id="lookdeta_title" style="font-size: 20px;text-align: center;line-height: 80px; font-weight:400;"></div>
		    	<div id="lookdeta_creatime" style="font-size: 12px;text-align: center;line-height: 30px; margin-top:-25px;"></div>
		    	<div id="lookdeta_connect"></div>
		      </div>
	        </div>
	      </div>
	    </div>
  </section>
	<footer>
		<section class="w tc">
			<ul>
				<li><a href="index.html">网站首页</a></li>
        <li><a href="javascript:;">加入收藏</a></li>
        <li><a href="javascript:;">网站地图</a></li>
        <li><a href="contact-us.html">联系我们</a></li>
        <li><a href="javascript:;">友情链接</a></li>
			</ul>
			<p>版权所有：湛江经济技术开发区管委会　地址：广东省湛江市湛江经济技术开发区东海岛中线公路中一号东海大厦。    邮编：524076</p>
			<p>未经书面授权任何单位、个人不得转载或建立镜像(建议使用1024×768分辨率 IE7.0以上版本浏览器) 粤ICP备040144</p>
		</section>
	</footer>
	<div class="rightNav">
    <ul>
      <li>
        <a href="javascript:;">
          <span class="r_show"><img src="images/wb.png" class="r_icon"><img src="images/wb_active.png" class="r_activeIcon"></span>
          <p>官方微博</p>
          <span class="r_code"><img id="gfwb" src="images/r_code.png" style="width:50px; height:50px;" alt=""></span>
        </a>
      </li>
      <li>
        <a href="javascript:;">
          <span class="r_show"><img src="images/wx.png" class="r_icon"><img src="images/wx_active.png" class="r_activeIcon"></span>
          <p>官方微信</p>
          <span class="r_code"><img id="gfwx" src="images/r_code.png" style="width:50px; height:50px;" alt=""></span>
        </a>
      </li>
      <li>
        <a href="javascript:;">
          <span class="r_show"><img src="images/zx.png" class="r_icon"><img src="images/zx_active.png" class="r_activeIcon"></span>
          <p>联系我们</p>
        </a>
      </li>
    </ul>
  </div>
  <script src="js/jquery-1.8.3.min.js"></script>
  <script src="js/video.min.js"></script>
  <script src="js/zh-CN.js"></script>
  <script src="js/select2.min.js"></script>
  <script>
  $(function(){ 
		
	  $("#select-model").select2({
		 minimumResultsForSearch: -1
	  });
	  var X = $('#s_input').offset().top;
	  var Y = $('#s_input').offset().left;
	  $("#obsoluje").css({"top":(parseInt(X)-3)+"px","left":(parseInt(Y)+214)+"px"});
	  
	  var dataty = "<%=dataty%>";
	  var fdid = "<%=fdid%>";
	  $.ajax({
			url:"/front/getdetails.action",
			type:"POST",
			data:{
				"dataty":dataty,
				"fdid":fdid
			},
			dataType:"json",
			success: function(res) {
				for(var item in res){ 
					var daysjo=res[item];
					var datajs = daysjo.data;
					if(item=="map2"){
						$("#lookdeta_title").text(datajs[3]);	
						$("#lookdeta_creatime").text("发布时间："+fotmateDateArray(datajs[2]));
						var videohtml = '<video id="my-video" class="video-js" controls preload="auto" width="880" height="400" poster="'+datajs[4]+'" data-setup="{}"><source src="'+datajs[1]+'" type="video/mp4"></video>';
						$("#lookdeta_connect").html(videohtml);
						var myPlayer = videojs('my-video');
						videojs("my-video").ready(function(){
							var myPlayer = this;
							myPlayer.play();
						});
					}else{
						$("#lookdeta_title").text(datajs[3]);	
						$("#lookdeta_creatime").text("发布时间："+fotmateDateArray(datajs[2]));
						$("#lookdeta_connect").html(datajs[1]);
					}
			    }
			},error:function(){
				alert("系统繁忙，请稍后再试...");
			}
		});
	  
	  $(".s_btn").click(function(){
			var keyVal = $("#s_input").val();
			var keyType = $("#select-model").val();
			if(keyVal==""||keyVal==null||keyVal==" "){
				alert("请输入关键字");
				return false;
			}
			window.open('/sreach-page.jsp?type='+keyType+'&keyVal='+keyVal);
	  });
  })
  //格式化的方法（到账时间）
function fotmateDateArray(value){
	var dateStr = "";
	if(value=="undefined"||value=="null"||value==null){}else{
		var date = new Date(value);
		dateStr = date.format("yyyy-MM-dd HH:mm:ss");
	}
    return dateStr;    
}
//js格式化日期插件代码
Date.prototype.format = function (format) {  
		 var o = {  
		        "M+": this.getMonth() + 1, // month  
		        "d+": this.getDate(), // day  
		        "H+": this.getHours(), // hour  
		        "m+": this.getMinutes(), // minute  
		        "s+": this.getSeconds(), // second  
		        "q+": Math.floor((this.getMonth() + 3) / 3),
		        "S": this.getMilliseconds()  
		        // millisecond  
		 }
		 if (/(y+)/.test(format)){
		        format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length)); 
		 } 
		 for (var k in o){  
		      if (new RegExp("(" + k + ")").test(format)){
		            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length)); 
		 	  }
		 } 
		 return format;  
}
  </script>
</body>

</html>