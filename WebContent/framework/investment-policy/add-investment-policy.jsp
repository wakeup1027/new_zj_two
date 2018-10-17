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
<title>投资政策-新增</title>
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
    <label class="layui-form-label">文本内容</label>
    <div id="div1" class="layui-input-block"></div>
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
var E = window.wangEditor;
var editor = new E('#div1');
// 配置服务器端地址
editor.customConfig.uploadImgServer = '<%=basePath%>framework/admin/addImages.action';
//限制图片上传大小3M
editor.customConfig.uploadImgMaxSize = 3 * 1024 * 1024;
//自定义filename
editor.customConfig.uploadFileName = 'fenMian';
// 自定义菜单配置
editor.customConfig.menus = [
    'head',  // 标题
    'bold',  // 粗体
    'fontSize',  // 字号
    'fontName',  // 字体
    'italic',  // 斜体
    'underline',  // 下划线
    'strikeThrough',  // 删除线
    'foreColor',  // 文字颜色
    'backColor',  // 背景颜色
    'link',  // 插入链接
    'list',  // 列表
    'justify',  // 对齐方式
    'emoticon',  // 表情
    'image',  // 插入图片
    'table',  // 表格
    'undo',  // 撤销
    'redo'  // 重复
]
//创建编辑器
editor.create();

//初始化上传控件
layui.use('upload', function(){
  var upload = layui.upload;
  //执行实例
  var uploadInst = upload.render({
    elem: '#test1', //绑定元素
    field: 'fenMian',
    size : 1024,
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
	var title = $("#title").val();
	var conne = editor.txt.html();
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
			url:"/framework/admin/updTouZiZhengCe.action",
			type:"POST",
			data:{
				"title":title,
				"content":conne,
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
			url:"/framework/admin/addTouZiZhengCe.action",
			type:"POST",
			data:{
				"title":title,
				"content":conne
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
		url:"/framework/admin/getTouZiZhengCe.action",
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
				//$("#imgbox").html('<img src="'+dats[0].fmimg+'" style="width:38px; height:38px; margin-right:10px;"/>');
				editor.txt.html(dats[0].content);
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