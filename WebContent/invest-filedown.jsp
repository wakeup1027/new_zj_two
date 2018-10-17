<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/index.css">
    <link href="css/select2.min.css" rel="stylesheet" />
    <title>投资服务-资料下载</title>
</head>
<style type="text/css">
#downfilebox li{line-height: 35px; border-bottom: 1px dashed #ccc; text-indent: 17px; background: url(../images/hsjt.png) no-repeat 3px 15px; color: #666; cursor: pointer; position: relative;}
#downfilebox>li>span{position: absolute;right: 5px;}
/*分页*/
a{ text-decoration:none;}
a:hover{ text-decoration:none;}
.tcdPageCode{padding: 15px 0px;text-align: right;color: #ccc;}
.tcdPageCode a{display: inline-block;color: #428bca;display: inline-block;height: 25px;	line-height: 25px;	padding: 0 10px;border: 1px solid #ddd;	margin: 0 2px;border-radius: 4px;vertical-align: middle;}
.tcdPageCode a:hover{text-decoration: none;border: 1px solid #428bca;}
.tcdPageCode span.current{display: inline-block;height: 25px;line-height: 25px;padding: 0 10px;margin: 0 2px;color: #fff;background-color: #428bca;	border: 1px solid #428bca;border-radius: 4px;vertical-align: middle;}
.tcdPageCode span.disabled{	display: inline-block;height: 25px;line-height: 25px;padding: 0 10px;margin: 0 2px;	color: #bfbfbf;background: #f2f2f2;border: 1px solid #bfbfbf;border-radius: 4px;vertical-align: middle;}
</style>

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
      <a href="invest-service.jsp" class="active"><i><img src="images/icon4.png" alt=""></i><p>投资服务</p></a>
      <a href="profession-garden.jsp"><i><img src="images/icon5.png" alt=""></i><p>专业园区</p></a>
      <a href="contact-us.jsp"><i><img src="images/icon6.png" alt=""></i><p>联系我们</p></a>
    </div>
  </section>
  <section class="second-nav">
    <ul class="w">
      <li><a href="invest-service.jsp">投资流程</a></li>
      <li><a href="invest-zhineng.jsp">职能部门联系</a></li>
      <li><a href="invest-mulu.jsp">投资目录</a></li>
      <li class="active"><a href="javascript:;">资料下载</a></li>
      <li><a href="invest-answer.jsp">答疑解惑</a></li>
    </ul>
  </section>
  <section class="env-content w">
    <div class="left-nav">
      <div class="lf-t n-title">
        <p class="t-small">press</p>
        <p class="t-big">center</p>
        <h3 class="t-main">投资服务</h3>
      </div>
      <ul>
        <li><a href="invest-service.jsp">投资流程</a></li>
        <li><a href="invest-zhineng.jsp">职能部门联系</a></li>
        <li><a href="invest-mulu.jsp">投资目录</a></li>
        <li class="active"><a href="javascript:;">资料下载</a></li>
        <li><a href="invest-answer.jsp">答疑解惑</a></li>
      </ul>
    </div>
    <div class="right-container">
      <div class="right-con">
        <div class="r_navigator">
          <span class="locTip">您现在的位置是:</span>
          <span><a href="index.jsp">首页</a>&nbsp;>&nbsp;</span>
          <span><a href="invest-service.jsp">投资服务</a>&nbsp;>&nbsp;</span>
          <span class="cur"><a href="javascript:;">资料下载</a></span>
        </div>
        <div class="r_con">
          <ul id="downfilebox">
          </ul>
        </div>
        <!--分页-->
	    <div class="tcdPageCode"></div>
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
  <script src="js/pageGroup.js"></script>
  <script src="js/select2.min.js"></script>
  <script>
  $(function(){
		
		$("#select-model").select2({
			minimumResultsForSearch: -1
		});
	  
	  var X = $('#s_input').offset().top;
		var Y = $('#s_input').offset().left;
		$("#obsoluje").css({"top":(parseInt(X)-3)+"px","left":(parseInt(Y)+214)+"px"});
		
	  var limitpage = 20;
	  $.ajax({
			url:"/front/getListZiLiaoXiaZai.action",
			type:"POST",
			data:{
				"page":1,
				"limit":limitpage
			},
			dataType:"json",
			success: function(res) {
				var data = res.data;
				if(data.length==0){
					return false;
				}
				$("#downfilebox").empty();
				for(var i=0; i<data.length; i++){
					var li = '<li><a href="/front/downFile.action?idstr='+data[i].id+'" target ="_blank">'+data[i].title+'</a><span>'+fotmateDateArray(data[i].creatime)+'</span></li>';
					$("#downfilebox").append(li);
				}
				var totalPages = Math.ceil(res.count / limitpage);
				//初始化分页
				$(".tcdPageCode").createPage({
				    pageCount:totalPages,
				    current:1,
				    backFn:function(p){
				        $.ajax({
							url:"/front/getListZiLiaoXiaZai.action",
							type:"POST",
							data:{
								"page":p,
								"limit":limitpage
							},
							dataType:"json",
							success: function(res){
								var data = res.data;
								if(data.length==0){
									return false;
								}
								$("#downfilebox").empty();
								for(var i=0; i<data.length; i++){
									var li = '<li><a href="/front/downFile.action?idstr='+data[i].id+'">'+data[i].title+'</a><span>'+fotmateDateArray(data[i].creatime)+'</span></li>';
									$("#downfilebox").append(li);
								}
							},error:function(){
								alert("系统繁忙，请稍后再试...");
							}
					 });
				    }
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
  
  window.onbeforeunload = function(event) {
                ws.onclose =function(){};
                ws.close();
            }
  
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