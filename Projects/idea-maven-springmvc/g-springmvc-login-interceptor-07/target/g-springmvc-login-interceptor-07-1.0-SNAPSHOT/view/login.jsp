<%--
  Created by IntelliJ IDEA.
  User: 钟荣杰
  Date: 2021/2/23
  Time: 1:14
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
    <title>登录</title>
    <base href="<%=basePath%>">
</head>
<body>
    模拟登录页面：已登录<br>
    <%
        session.setAttribute("name","deng");
    %>
    <a href="index.jsp">点击返回</a>
</body>
</html>
