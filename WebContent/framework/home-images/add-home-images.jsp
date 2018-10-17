<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String daid = request.getParameter("id");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图片设置-新增</title>
<link rel="stylesheet" href="../plugins/layui/css/layui2.css" media="all">
<link href="/framework/css/select2.min.css" rel="stylesheet" />
<script src="<%=basePath%>js/jquery-1.8.3.min.js"></script>
<script src="<%=basePath%>js/jquery.form.js"></script>
<script type="text/javascript" src="../plugins/layui/layui.js"></script>
<script type="text/javascript" src="/framework/js/wangEditor.min.js"></script>
<script src="/framework/js/select2.min.js"></script>
</head>
<body>
	<button class="layui-btn" style="margin:15px 35px; width:120px;" onclick="javascript:history.back()">
	  <i class="layui-icon">&#xe603;</i> 返回
	</button>
</body>
<div class="layui-form-item">
    <label class="layui-form-label">归属模块</label>
    <div class="layui-input-inline">
      <select id="modeltype" class="select2" style="width:180px">
		<option value="1">首页轮播图</option>
		<option value="2">官方微博二维码</option>
		<option value="3">官方微信二维码</option>
	  </select>
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">选择图片</label>
    <div id="imgbox" style="float:left;"></div>
    <div class="layui-input-block">
      <button type="button" class="layui-btn" id="test1">
		 <i class="layui-icon">&#xe64a;</i>上传图片
	  </button>
    </div>
</div>
<div class="layui-form-item">
	<input id="savtype" type="hidden"/>
	<input id="idhidden" type="hidden"/>
	<button class="layui-btn" style="margin:15px 35px; width:120px;" onclick="javascript:submitsave()">
	  <i class="layui-icon">&#xe605;</i> 保存
	</button>
</div>
<script>

//初始化上传控件
layui.use('upload', function(){
  var upload = layui.upload;
  //执行实例
  var uploadInst = upload.render({
    elem: '#test1', //绑定元素
    field: 'fenMian',
    size : 3072,
    accept : "images",
    exts : 'jpg|png|gif|bmp|jpeg',
    url: '<%=basePath%>framework/admin/addImages.action',
    done: function(res){
      	if(res.errno==0){
      		$("#imgbox").html('<img src="'+(res.data)[0]+'" style="width:38px; height:38px; margin-right:10px;"/>');
      	}
    },
    error: function(){
    	layer.msg('提醒出错，请联系管理员');
    }
  });
});

function submitsave(){
	var urlpath = $("#imgbox img").attr("src");
	var modeltype = $("#modeltype").val();
	if(urlpath==""||urlpath==null){
		layer.msg('请选择上传的图片');
		return false;
	}
	if($("#savtype").val()=="edit"){
		$.ajax({
			url:"/framework/admin/updShouYeImages.action",
			type:"POST",
			data:{
				"urlpath":urlpath,
				"type":modeltype,
				"id":$("#idhidden").val()
			},
			dataType:"json",
			success: function(res) {
				if(res){
					history.go(-1);
					location.reload();
				}else{
					alert("系统繁忙，请稍后再试...");
				}
			},error:function(){
				alert("系统繁忙，请稍后再试...");
			}
		});
	}else{
		$.ajax({
			url:"/framework/admin/addShouYeImages.action",
			type:"POST",
			data:{
				"urlpath":urlpath,
				"type":modeltype
			},
			dataType:"json",
			success: function(res) {
				if(res){
					history.go(-1);
					location.reload();
				}else{
					alert("系统繁忙，请稍后再试...");
				}
			},error:function(){
				alert("系统繁忙，请稍后再试...");
			}
		});
	}
}

var ss = "<%=daid%>";
if(ss!="0"){
	$.ajax({
		url:"/framework/admin/getShouYeImages.action",
		type:"POST",
		data:{
			"daid":ss
		},
		dataType:"json",
		success: function(res) {
			console.log(res);
			var dats = res.data;
			if(dats.length>0){
				$("#modeltype").val(dats[0].type).trigger("change");
				$("#imgbox").html('<img src="'+dats[0].urlpath+'" style="width:38px; height:38px; margin-right:10px;"/>');
				$("#savtype").val("edit");
				$("#idhidden").val(ss);
			}
		},error:function(){
			alert("系统繁忙，请稍后再试...");
		}
	});
}

$(function () {
    $("#modeltype").select2({
    	minimumResultsForSearch: -1
    });
});
</script>
</html>