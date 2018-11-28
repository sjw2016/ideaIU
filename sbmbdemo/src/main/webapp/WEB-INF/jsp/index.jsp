<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>yayyay</title>
    <script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
    <script type="text/javascript">
        $(function () {
                $.getJSON("/user", function (result) {
                    var a = JSON.stringify(result)
                    $("span").text(a)
                }
            )
        })
    </script>
</head>

<body>
<p>lalalalalalalalalalalalalalal</p>
${test}3e42
<span></span>
</body>
</html>