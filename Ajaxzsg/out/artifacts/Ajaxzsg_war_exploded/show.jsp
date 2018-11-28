<%--
  Created by IntelliJ IDEA.
  User: 雷飞
  Date: 2018/9/26
  Time: 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="static/js/jquery.js"></script>
    <script>
      $(function () {
        /*增加*/
        $("input[name=insert]").click(function () {
            var data = {
                "name":$(".a").val(),
                "password":$(".b").val()
            }
            // $.get("AjaxServlet",data,function (result) {
            //   $("span").text(result)
            // })
            $.getJSON("AjaxServlet",data,function (result) {
                $(".insert").text(result.name)
            })
        });

        $("input[name=delete]").click(function () {
            $.getJSON("deServlet?dname="+$(".c").val(),function (result) {
                $(".delete").text(result.named)
            })
        });

        $(".g").click(function () {
            var data = {
                "xoldname":$(".e").val(),
                "xnewname":$(".f").val()
            }
            $.getJSON("xiuServlet",data,function (result) {
                $(".xiu").text(result.namex)
            })
        });

        $(".i").click(function () {
           $.getJSON("chaServlet?cname="+$(".h").val(),function (result) {
               $(".cha").text("id:"+result.id+"|用户名："+result.username+"|密码"+result.password)
           })
        });
      });
    </script>
  </head>
  <body>
  新增：<br>
    用户名：<input type="text" name="name" class="a"><br>
    密码：<input type="text" name="password" class="b"><br>
    <input type="button" value="新增" name="insert"><br>
    <span class="insert"></span><br>

  删除：<br>
  用户名：<input type="text" name="namec" class="c"><br>
  <input type="button" value="删除" name="delete"><br>
  <span class="delete"></span><br>

  修改：<br>
  旧用户名：<input type="text" class="e"><br>
  新用户名：<input type="text" class="f"><br>
           <input type="button" class="g"value="修改"><br>
            <span class="xiu"></span><br>

  查询：<br>
  用户名：<input type="text"class="h"><<br>
         <input type="button" class="i" value="查询"><br>
        <span class="cha"></span>
  </body>
</html>
