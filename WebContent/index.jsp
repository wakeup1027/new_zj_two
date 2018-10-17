<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/swiper.min.css">
    <link href="css/select2.min.css" rel="stylesheet" />
    <title>首页</title>
</head>

<body>
	<header class="w">
		<div class="logo-con fl">
			<a href="index.jsp"><img src="images/logo.png" alt="" class="logo-ico"><img src="images/font.png" alt="" class="logo-font"></a>
		</div>
		<div class="search-con fr">
			<span class="search-input"><input id="s_input" type="text" class="s_input" placeholder="请输入您要查找的文件及信息" /></span>
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
	<div class="swiper-container main-banner">
	    <div class="swiper-wrapper">
	      	<!-- div class="swiper-slide"><a href="javascript:;"><img src="images/banner.png" alt=""></a></div>
	      	<div class="swiper-slide"><a href="javascript:;"><img src="images/banner.png" alt=""></a></div>
	      	<div class="swiper-slide"><a href="javascript:;"><img src="images/banner.png" alt=""></a></div -->
	    </div>
	    <!-- Add Pagination -->
	    <div class="swiper-pagination"></div>
	    <!-- Add Arrows -->
	    <div class="w main-banner-arrow">
	    	<div class="swiper-button-next"></div>
	    	<div class="swiper-button-prev"></div>
	    </div>
  	</div>
  	<section class="container-block clearfix">
  		<div class="cb-item">
  			<div class="cb-item-bg"></div>
  			<div class="cb-item-content" style="background-image: url(images/item1.png);">
  				<div class="n-title">
  					<p class="t-small">press</p>
  					<p class="t-big">center</p>
  					<h3 class="t-main">新闻中心</h3>
  				</div>
  				<div class="cb-item-list">
  					<div class="list-title">
  						<h4 class="t-sub">press center</h4>
  						<h3 class="t-main">新闻中心</h3>
  					</div>
  					<ul>
  						<li><a href="new-content.jsp">投资动态</a></li>
  						<li><a href="new-media.jsp">新闻媒体</a></li>
  					</ul>
  				</div>
  			</div>
  		</div>
  		<div class="cb-item">
  			<div class="cb-item-bg"></div>
  			<div class="cb-item-content" style="background-image: url(images/item2.png);">
  				<div class="n-title">
  					<p class="t-small">Investment</p>
  					<p class="t-big">environment</p>
  					<h3 class="t-main">投资环境</h3>
  				</div>
  				<div class="cb-item-list">
  					<div class="list-title">
  						<h4 class="t-sub">Investment environment</h4>
  						<h3 class="t-main">投资环境</h3>
  					</div>
  					<ul>
  						<li><a href="invest-environment.jsp">了解我们</a></li>
  						<li><a href="invest-project.jsp">投资项目</a></li>
  						<li><a href="invest-guidance.jsp">投资政策</a></li>
  						<li><a href="invest-cost.jsp">投资成本</a></li>
  						<li><a href="invest-importprise.jsp">重点企业</a></li>
  					</ul>
  				</div>
  			</div>
  		</div>
  		<div class="cb-item">
  			<div class="cb-item-bg"></div>
  			<div class="cb-item-content" style="background-image: url(images/item3.png);">
  				<div class="n-title">
  					<p class="t-small">Investment</p>
  					<p class="t-big">services</p>
  					<h3 class="t-main">投资服务</h3>
  				</div>
  				<div class="cb-item-list">
  					<div class="list-title">
  						<h4 class="t-sub">Investment  services</h4>
  						<h3 class="t-main">投资服务</h3>
  					</div>
  					<ul>
  						<li><a href="invest-service.jsp">投资流程</a></li>
  						<li><a href="invest-zhineng.jsp">职能部门联系</a></li>
  						<li><a href="invest-mulu.jsp">投资目录</a></li>
  						<li><a href="invest-filedown.jsp">资料下载</a></li>
  						<li><a href="invest-answer.jsp">答疑解惑</a></li>
  					</ul>
  				</div>
  			</div>
  		</div>
  		<div class="cb-item">
  			<div class="cb-item-bg"></div>
  			<div class="cb-item-content" style="background-image: url(images/item4.png);">
  				<div class="n-title">
  					<p class="t-small">Professional</p>
  					<p class="t-big">park</p>
  					<h3 class="t-main">专业园区</h3>
  				</div>
  				<div class="cb-item-list">
  					<div class="list-title">
  						<h4 class="t-sub">Professional park</h4>
  						<h3 class="t-main">专业园区</h3>
  					</div>
  					<ul>
  						<li><a href="profession-garden.jsp">石化园区</a></li>
  						<li><a href="profession-gangtie.jsp">钢铁配套园区</a></li>
  						<li><a href="profession-centern.jsp">中央商务区</a></li>
  					</ul>
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
  <script src="js/swiper.min.js"></script>
  <script src="js/select2.min.js"></script>
  <script>
    $(function(){
  		$("#select-model").select2({
  			minimumResultsForSearch: -1
  		});
  		
  		var X = $('#s_input').offset().top;
  		var Y = $('#s_input').offset().left;
  		$("#obsoluje").css({"top":(parseInt(X)-3)+"px","left":(parseInt(Y)+214)+"px"});
  		
  	  $.ajax({
  			url:"/front/getDataShouYeImages.action",
  			type:"POST",
  			dataType:"json",
  			success: function(res) {
  				var data = res.data;
  				for(var i=0; i<data.length; i++){
  					$(".swiper-wrapper").append("<div class='swiper-slide'><a href='javascript:;'><img src='"+data[i].urlpath+"' alt=''></a></div>");
  				}
  				//初始化轮播
  				var swiper = new Swiper('.swiper-container', {
  			      pagination: {
  			        el: '.swiper-pagination',
  			        clickable: true,
  			        bulletClass : 'my-bullet',
  			        bulletActiveClass: 'my-bullet-active',
  			      },
  			      navigation: {
  			        nextEl: '.main-banner-arrow .swiper-button-next',
  			        prevEl: '.main-banner-arrow .swiper-button-prev',
  			      },
  			    });
  			},error:function(){
  				alert("系统繁忙，请稍后再试...");
  			}
  		});
  	  
  		$.ajax({
			url:"/front/getDataErWeiMa.action",
			type:"POST",
			dataType:"json",
			success: function(res) {
				var map1 = res.map1.data;
				var map2 = res.map2.data;
				$("#gfwb").attr("src",map1[0].urlpath);
				$("#gfwx").attr("src",map2[0].urlpath);
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
    
    //item悬浮效果
    $('.container-block .cb-item').hover(function(){
    	var bg = $(this).find('.cb-item-content').css('background-image');
    	$(this).find('.cb-item-bg').css('background-image',bg);
	    },
	    function(){
	    	$(this).find('.cb-item-bg').css('background-image','');
	    }
    )
  </script>
</body>

</html>