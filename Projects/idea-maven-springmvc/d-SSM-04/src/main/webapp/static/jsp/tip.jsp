<%--
  Created by IntelliJ IDEA.
  User: 钟荣杰
  Date: 2021/2/19
  Time: 3:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()+"://"+
            request.getServerName()+":"+request.getServerPort()+
            request.getContextPath()+"/";
%>
<html>
<head>
    <title>提示</title>
    <base href="<%=basePath%>">
</head>
<body>
    <h3>505<br>${tips2}</h3>
    <a href="static/jsp/addUser.jsp">点击重新注册</a>
</body>
</html>
