<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>湛江开发信息管理系统登录界面</title>
<link rel="stylesheet" media="screen" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/reset_login.css"/>
</head>
<body>
<div id="particles-js">
		<div class="login">
			<div class="login-top">
				登录
			</div>
			<div class="login-center clearfix">
				<div class="login-center-img"><img src="images/name.png"/></div>
				<div class="login-center-input">
					<input id="userna" type="text" name="" value="" placeholder="请输入您的用户名" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的用户名'"/>
					<div class="login-center-input-text">用户名</div>
				</div>
			</div>
			<div class="login-center clearfix">
				<div class="login-center-img"><img src="images/password.png"/></div>
				<div class="login-center-input">
					<input id="passwo" type="password" name=""value="" placeholder="请输入您的密码" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的密码'"/>
					<div class="login-center-input-text">密码</div>
				</div>
			</div>
			<div id="loginbtn" class="login-button">
				登陆
			</div>
		</div>
		<div class="sk-rotating-plane"></div>
</div>
<script src="js/jquery-1.8.3.min.js"></script>
<script src="js/particles.min.js"></script>
<script src="js/app.js"></script>
<script>
    $(function(){
    	$("#loginbtn").click(function(){
    		loginfunc();
    	});
    	
    	document.onkeydown = function(e){
            var ev = document.all ? window.event : e;
            if(ev.keyCode==13) {
            	loginfunc();
            }
        }
    });
    
    function loginfunc(){
    	var usern = $("#userna").val().trim();
		var passw = $("#passwo").val().trim();
		if(usern==""||usern==null){
			alert("请输入账号");
			return false;
		}
		if(passw==""||passw==null){
			alert("请输入密码");
			return false;
		}
		$.ajax({
  			url:"/front/login.action",
  			type:"POST",
  			data:{
  				"user":usern,
  				"pass":passw
  			},
  			dataType:"json",
  			success: function(res) {
  				if(res){
  					window.location.href='/framework/index.jsp';
  				}else{
  					alert("密码错误！");
  				}
  			},error:function(){
  				alert("系统繁忙，请稍后再试...");
  			}
  		});
    }
</script>
</body>
</html>