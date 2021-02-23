<%--
  Created by IntelliJ IDEA.
  User: 钟荣杰
  Date: 2021/2/19
  Time: 21:47
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
    <title>浏览用户：查询用户Ajax</title>
    <base href="<%=basePath%>">
    <!--导入jQuery库-->
    <script type="application/javascript" src="static/js/jquery-3.4.1.js"></script>
    <script type="application/javascript">
        $(function (){
            $("#btnLoader").click(function (){
                $.ajax({
                    url:"user/browserUser",
                    type:"get",
                    dataType:"json",
                    success:function (data){
                        //这里表示每一次进行该方法执行都清除之前html中的数据
                        $("#info").html();
                        //下面就是添加新的数据
                        <!--通过将获取到的json数组进行遍历，将数组中的每一个json对象
                        的数据放到下面table标签的tbody对象中-->
                       $.each(data,function (i,n){
                           $("#info").append("<tr>")
                           .append("<td>"+n.id+"/td")
                           .append("<td>"+n.login+"/td")
                           .append("<td>"+n.real+"/td")
                           .append("</tr>")
                       })
                    }
                })
            })
        })
    </script>
</head>
<body>
    <div align="center">
        <table>
            <thead>
            <tr>
                <td>主键id</td>
                <td>登录名</td>
                <td>真实姓名</td>
            </tr>
            </thead>
            <!--下面是table的tbody对象-->
            <tbody id="info">

            </tbody>
        </table>
        <input type="button" id="btnLoader" value="查询数据">
    </div>
</body>
</html>
