<%--
  Created by IntelliJ IDEA.
  User: 钟荣杰
  Date: 2021/2/14
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>
    <P>提交参数给Controller，接收请求参数</P>
    <form action="test/otherOne.do" method="post">
        姓名:<input type="text" name="name"><br>
        年龄:<input type="text" name="age"><br>
        <input type="submit" value="提交参数">
    </form>
    <br>
    <P>请求参数名和方法形参名不一样</P>
    <form action="test/othertwo.do" method="post">
        姓名:<input type="text" name="myname"><br>
        年龄:<input type="text" name="myage"><br>
        <input type="submit" value="提交参数">
    </form>
    <br>
    <P>处理器方法的形参是java对象</P>
    <form action="test/otherthree.do" method="post">
        姓名:<input type="text" name="name"><br>
        年龄:<input type="text" name="age"><br>
        <input type="submit" value="提交参数">
    </form>
</body>
</html>
