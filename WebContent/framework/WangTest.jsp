<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>测试wang富文本控件</title>
</head>
<body>
<div id="div1"></div>
<script src="<%=basePath%>js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/wangEditor.min.js"></script>
<script type="text/javascript">
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
    $('#div1>div').eq(1).css('height','500px');
</script>
</body>
</html>