<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<script src="statics/js/jquery-1.8.3.min.js"></script>
<script>
    var data = {
        "id": $(".aa").val(),
        "username": $(".ss").val(),
        "password": $(".dd").val()
    }
    $(function () {
        $("button").click(function () {
            $.ajax({
                url: 'test/sss',
                type: 'POST',
                contentType: 'application/json; charset=UTF-8',
                async: false,
                dataType: 'text',
                data: JSON.stringify(data),
                success: function (result) {
                    console.log(result)
                    $("span").text(result)
                }
            })
        });
    });
</script>
<body>
id: <input type="text" class="aa"><br>
账号： <input type="text" class="ss"><br>
密码： <input type="text" class="dd"><br>
<button>点击</button><br>
<span></span>
</body>
</html>
