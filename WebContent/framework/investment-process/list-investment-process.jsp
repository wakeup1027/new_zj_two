<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>投资流程-列表</title>
<link rel="stylesheet" href="../plugins/layui/css/layui2.css" media="all">
<script src="<%=basePath%>js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="../plugins/layui/layui.js"></script>
</head>
<body>
<div>
	<button class="layui-btn" style="margin-left:15px; width:120px;" onclick="new_date()">
	  <i class="layui-icon">&#xe608;</i> 添加
	</button>
	<table class="layui-hide" id="test" lay-filter="test"></table>
	<script type="text/html" id="barDemo">
  		<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</script>
</div>
<script>
layui.use(['table'], function(){
	var table = layui.table; //表格
	table.render({
	    elem: '#test',
	    height: $(window).height()-60,
	    limit: 20,
	    url: "/framework/admin/listTouZiLiuCheng.action", //数据接口
	    method:'post',
	    page: true, //开启分页
	    cols: [[ //表头
	        {field: 'title', title: '标题', width:'800'},
	   	 	{field: 'creatime', title: '新建时间', width:'230', templet:fotmateDateArray},
	        {fixed: 'right', title:'操作', toolbar: '#barDemo', width:'130'}
	    ]],
	    done:function(res){
			//console.log(res);
		}
	});
	
	//头工具栏事件
	table.on('tool(test)', function(obj){
		var data = obj.data;
	    if(obj.event === 'del'){
	      layer.confirm('真的删除行么', function(index){
	        $.ajax({
				url:"/framework/admin/delTouZiLiuCheng.action?id="+data.id,
				type:"POST",
				data:{},
				dataType:"json",
				success: function(res) {
					console.log(res);
					if(res){
						obj.del();
					}
				},error:function(){
					alert("系统繁忙，请稍后再试...");
				}
			});
	        layer.close(index);
	      });
	    } else if(obj.event === 'edit'){
	    	window.location= "/framework/investment-process/add-investment-process.jsp?id="+data.id;
	      /*layer.prompt({
	        formType: 2
	        ,value: data.email
	      }, function(value, index){
	        obj.update({
	        	title: value
	        });
	        layer.close(index);
	      });*/
	    }
	});
});

function new_date(){
	window.location= "/framework/investment-process/add-investment-process.jsp?id=0";
}

//格式化的方法（到账时间）
function fotmateDateArray(value){
	value = value.creatime;
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
		        "q+": Math.floor((this.getMonth() + 3) / 3), // quarter  
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