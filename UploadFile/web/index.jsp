<%--
  Created by IntelliJ IDEA.
  User: lucky
  Date: 2018/3/14
  Time: 下午6:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
文件上传
<hr>

<%--enctype属性 告诉servlet 表单提交的数据将会被编码并且备多个部分，此时method以定位post--%>
<form action="servlets/UploadServlet" method="post" enctype="multipart/form-data">
    请选择文件上传
    <input type="file" name="myFile">
    <input type="submit" value="上传">
</form>
${msg}
</body>
</html>
