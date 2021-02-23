<%--
  Created by IntelliJ IDEA.
  User: 钟荣杰
  Date: 2021/2/22
  Time: 19:45
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
    tip.jsp提示展示页面<br>
    该用户无法访问该请求，该请求被拦截！！！<br>
    <a href="view/login.jsp">去登录</a>
</body>
</html>
