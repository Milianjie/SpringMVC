<%--
  Created by IntelliJ IDEA.
  User: 钟荣杰
  Date: 2021/2/22
  Time: 19:42
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
    <title>正确结果展示</title>
    <base href="<%=basePath%>">
</head>
<body>
    show.jsp结果展示页面<br>
    myName数据：${myName}<br>
    myAge数据：${myAge}<br>
    <a href="view/logout.jsp">点击登出</a>
</body>
</html>
