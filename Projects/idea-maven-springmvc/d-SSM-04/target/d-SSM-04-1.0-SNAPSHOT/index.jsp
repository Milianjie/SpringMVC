<%--
  Created by IntelliJ IDEA.
  User: 钟荣杰
  Date: 2021/2/19
  Time: 2:17
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
    <title>功能入口</title>
    <base href="<%=basePath%>">
</head>
<body>
    <div align="center"><!--使其中的内容都居中-->
        <p>SSM整合例子</p>
        <img src="static/images/2.gif"/>
        <table>
            <tr>
                <td><a href="static/jsp/addUser.jsp">注册用户</a></td>
            </tr>
            <tr>
                <td><a href="static/jsp/listUser.jsp">浏览用户</a> </td>
            </tr>
        </table>
    </div>
</body>
</html>
