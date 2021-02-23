<%--
  Created by IntelliJ IDEA.
  User: 钟荣杰
  Date: 2021/2/19
  Time: 2:26
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
    <title>注册用户</title>
    <base href="<%=basePath%>">
</head>
<body>
    <div align="center">
        <form action="user/addUser" method="post">
            <table>
                <tr>
                    <td>登录名：</td>
                    <td><input type="text" name="loginName"></td>
                </tr>
                <tr>
                    <td>密码：</td>
                    <td><input type="password" name="loginPwd"></td>
                </tr>
                <tr>
                    <td>真实姓名：</td>
                    <td><input type="text" name="realName"></td>
                </tr>
                <tr>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td><input type="submit" value="注册"></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
