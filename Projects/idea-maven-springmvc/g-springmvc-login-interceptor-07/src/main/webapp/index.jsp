<%--
  Created by IntelliJ IDEA.
  User: 钟荣杰
  Date: 2021/2/22
  Time: 18:02
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
    <title>欢迎页面</title>
    <base href="<%=basePath%>">
</head>
<body>
<P>提交参数给Controller，接收请求参数</P>
<form action="myInterceptor/some.do" method="post">
    姓名:<input type="text" name="name"><br>
    年龄:<input type="text" name="age"><br>
    <input type="submit" value="提交参数">
</form><br>
<a href="view/login.jsp">去登录</a>
</body>
</html>
