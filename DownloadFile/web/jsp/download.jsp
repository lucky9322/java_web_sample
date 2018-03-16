<%--
  Created by IntelliJ IDEA.
  User: lucky
  Date: 2018/3/15
  Time: 上午11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
文件页
<%
    String fileName = request.getParameter("file");
//告诉客户端 出现下载框，并指定下载框中的文件名
    response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
//    指定文件类型
    response.setContentType("image/jpeg");
//    指定文件
    RequestDispatcher rd = request.getRequestDispatcher("/files/" + fileName);
    rd.forward(request,response);
%>
</body>
</html>
