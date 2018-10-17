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
<title>资料下载-新增</title>
<link rel="stylesheet" href="../plugins/layui/css/layui2.css" media="all">
<script src="<%=basePath%>js/jquery-1.8.3.min.js"></script>
<script src="<%=basePath%>js/jquery.form.js"></script>
<script type="text/javascript" src="../plugins/layui/layui.js"></script>
<script type="text/javascript" src="/framework/js/wangEditor.min.js"></script>
</head>
<body>
	<button class="layui-btn" style="margin:15px 35px; width:120px;" onclick="javascript:history.back()">
	  <i class="layui-icon">&#xe603;</i> 返回
	</button>
</body>
<div class="layui-form-item">
    <label class="layui-form-label">标题</label>
    <div class="layui-input-block">
      <input id="title" type="text" name="title" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">选择文件</label>
    <input id="upfileurl" type="hidden"/>
    <div class="layui-input-block">
      <button type="button" class="layui-btn" id="test1">
		 <i class="layui-icon">&#xe621;</i>上传文件
	  </button>
	  <span id="textmes" style="color:#ff0000;"></span>
    </div>
</div>
<!-- div class="layui-form-item">
    <label class="layui-form-label">缩略图</label>
    <div id="imgbox" style="float:left;"></div>
    <div class="layui-input-block">
      <button type="button" class="layui-btn" id="test1">
		 <i class="layui-icon">&#xe64a;</i>上传图片
	  </button>
    </div>
</div -->
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
    size : 1048576,
    accept : "file",
    url: '<%=basePath%>framework/admin/addFile.action',
    done: function(res){
      	if(res.errno==0){
      		$("#upfileurl").val((res.data)[0]);
      		$("#textmes").text("上传成功，点击保存即可");
      	}
    },
    error: function(){
    	layer.msg('提醒出错，请联系管理员');
    }
  });
});

function submitsave(){
	var title = $("#title").val();
	var conne = $("#upfileurl").val();
	var fm = $("#imgbox img").attr("src");
	if(title==""||title==null){
		layer.msg('请输入标题');
		return false;
	}
	if(conne==""||conne==null){
		layer.msg('请输入内容');
		return false;
	}
	if($("#savtype").val()=="edit"){
		$.ajax({
			url:"/framework/admin/updZiLiaoXiaZai.action",
			type:"POST",
			data:{
				"title":title,
				"fileUrl":conne,
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
			url:"/framework/admin/addZiLiaoXiaZai.action",
			type:"POST",
			data:{
				"title":title,
				"fileUrl":conne
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
		url:"/framework/admin/getZiLiaoXiaZai.action",
		type:"POST",
		data:{
			"daid":ss
		},
		dataType:"json",
		success: function(res) {
			console.log(res);
			var dats = res.data;
			if(dats.length>0){
				$("#title").val(dats[0].title);
				$("#upfileurl").val(dats[0].fileUrl);
				$("#savtype").val("edit");
				$("#idhidden").val(ss);
			}
		},error:function(){
			alert("系统繁忙，请稍后再试...");
		}
	});
}
</script>
</html>