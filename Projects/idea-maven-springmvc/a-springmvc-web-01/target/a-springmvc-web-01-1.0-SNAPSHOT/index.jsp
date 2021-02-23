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
    <P>SpringMVC的一个项目</P>
    <!--这里添加一个超链接，转到web中声明的接收.do结尾的中央调度器，
        然后调度器根据some.do和扫描@Controller中的值，调用与值对应控制器对象，完成处理-->
    <P><a href="some.do">发起some.do请求</a></P>
</body>
</html>
