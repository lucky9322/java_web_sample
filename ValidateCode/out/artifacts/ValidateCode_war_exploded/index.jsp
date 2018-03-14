<%--
  Created by IntelliJ IDEA.
  User: lucky
  Date: 2018/3/13
  Time: 下午4:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页</title>
</head>
<body>
<script type="text/javascript">
    function refresh() {
        var img = document.getElementById("imgValidate");
        img.src = "jsp/validate.jsp?tm="+Math.random();
    }
</script>
<form name="loginForm" method="post" action="servlets/ValidateServlet">
    欢迎登录本系统 <br>
    请输入您的账号： <input type="text" name="account"> <br>
    请输入您的密码： <input type="password" name="password"> <br>
    请输入验证码: <input type="text" name="code" size="10">

    <img src="jsp/validate.jsp" border="0" id="imgValidate" onclick="refresh()"> <br>
    <input type="submit" value="登录">
</form>
</body>
</html>
