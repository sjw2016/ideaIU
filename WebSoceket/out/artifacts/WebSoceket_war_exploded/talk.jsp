<%--
  Created by IntelliJ IDEA.
  User: 雷飞
  Date: 2018/9/27
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="static/js/jquery.js"></script>
  </head>
  <body>
  name:<input type="text" class="lei">
    <br><input id = "text" type="text"/>
  <button onclick="send()" >发送消息</button>
    <hr>
    <button onclick="aa()" class="aa">打开连接</button>
  <button onclick="closeWebSocket()">关闭webSocket连接</button>
  <hr/>
  <div id="message"></div>
  </body>
<script type="text/javascript">
  //判断当前浏览器是否支持websocket
  var websocket = null;
  function aa() {
      if($(".lei").val() != ""){
          if('WebSocket' in window){
              websocket = new WebSocket("ws://localhost:8080/Websocket/"+$(".lei").val());
              a(websocket);
          }else{
              alert('当前浏览器 Not support websocket');
          }
      }else{
          alert("请输入姓名")
      }
  }


function a(websocket){
    //连接发生错误的回调方法
    websocket.onerror = function () {
        setMessageInnerHTML("WebSocket连接发生错误");
    };
    //接收到消息的回调方法
    websocket.onmessage = function(event){
        setMessageInnerHTML(event.data);
    }
    //连接成功建立的回调方法
    websocket.onopen = function () {
        setMessageInnerHTML("WebSocket连接成功");
    };
    //连接关闭的回调方法
    websocket.onclose = function () {
        setMessageInnerHTML("WebSocket连接关闭");
    };
}



  //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，serber端会抛异常
  window.onbeforeunload = function () {
      closeWebSocket();
  };
  //将消息显示在网页上
  function setMessageInnerHTML(innerHTML) {
      document.getElementById('message').innerHTML += innerHTML+'<br/>'
  };
  //关闭websocker连接
  function closeWebSocket() {
      websocket.close();
  }
  //发送消息
  function send() {
      var message  = document.getElementById('text').value;
      websocket.send(message);
  }
</script>
</html>
