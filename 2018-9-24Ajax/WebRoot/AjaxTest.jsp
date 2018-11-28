<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
  <script type="text/javascript" src="static/js/jquery.js"></script>
  <script type="text/javascript">
	$(function(){
	$("input[name=uname]").blur(function(){
	$.ajax({
		"url":"AjaxServlet",
		"type":"get",
		"data":"uname="+$(this).val(),
		"dataType":"text",
		"success": function(result){
			$("input[name=uname]").next().text(result);
		}
					});
		});
	});
	</script>
  </head>
  
  <body>
    用户名<input type="text" name="uname"><span></span>
  </body>
</html>
