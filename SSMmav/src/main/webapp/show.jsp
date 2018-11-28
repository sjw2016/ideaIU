<%--
  Created by IntelliJ IDEA.
  User: 石俊伟
  Date: 2018/10/27
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

    <title></title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <script type="text/javascript" src="statics/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
       /* var jsons = [];*/
       /* var json = {};
        json.id="1";
        json.Username="admin";*/
       /* var json1 = {};
        json1.id="1";
        json1.Username="admin";
        jsons.push(json);
        jsons.push(json1);*/
        $(function(){
            $("button").click(function(){
                //console.log(json)
                $.ajax({
                    url : "test/ddd",
                    //data : JSON.stringify(json),
                    contentType : "application/json",
                    type : "post",
                    success: function (result) {
                        console.log(result)
                        $("span").text(result)
                    }
                });
            });
        });
    </script>
</head>

<body>
<button>点击</button>
<span></span>
</body>
</html>
