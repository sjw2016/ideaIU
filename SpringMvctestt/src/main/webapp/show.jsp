<%--
  Created by IntelliJ IDEA.
  User: 石俊伟
  Date: 2018/10/25
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="statics/js/jquery-1.8.3.min.js"></script>
    <script>
        $(function () {

            $(".aa").click(function () {
                var data = {
                    "username":$(".name").val(),
                    "userpwd":$(".pwd").val()
                }
                $.getJSON("asd",data,function (result) {
                    $(".cha").text("用户名："+result.username+"|密码"+ result.userpwd+result.sex + ssss.sex + result.ssss.id)
                })
            });
        });
    </script>
</head>
<body>
欢迎进入客户信息管理系统>>>>><br>
请输入用户名：<input type="text" class="name"><br>
请输入密码：<input type="text" class="pwd"><br>
<input type="button" class="aa">
<span></span>
</body>
</html>
