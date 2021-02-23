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
    <P>处理器方法返回String，表示视图名称</P>
    <form action="test/returnString-view1.do" method="post">
        姓名:<input type="text" name="name"><br>
        年龄:<input type="text" name="age"><br>
        <input type="submit" value="提交参数">
    </form>
    <br>
    <P>处理器方法返回String，表示视图完整路径</P>
    <form action="test/returnString-view2.do" method="post">
        姓名:<input type="text" name="name"><br>
        年龄:<input type="text" name="age"><br>
        <input type="submit" value="提交参数">
    </form>
    <br>
    <P>处理器方法返回java对象，输出对象的json字符串到浏览器</P>
    <form action="test/returnJson.do" method="get">
        <input type="submit" value="提交参数">
    </form>
    <br>
    <P>处理器方法返回List</P>
    <form action="test/returnListJson.do" method="get">
        <input type="submit" value="提交参数">
    </form>
</body>
</html>
