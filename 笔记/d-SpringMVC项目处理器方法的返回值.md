## 处理器方法的返回值类型

### 使用注解@Controller的处理器的处理器方法返回值一共有四种：

```
第一种：ModelAndView
第二种：String
第三种：无返回值
第四种：返回自定义类型对象
```



### 1、返回值类型是ModelAndView

```
该类型在前面的项目实例中已经展示了。当我们的处理器方法完成处理后不仅要返回数据传递数据，还需要跳转到其他资源，就需要返回ModelAndView类型，但是要创建ModelAndView对象。
	当我们只需要跳转资源或者只需要返回数据传递数据时，ModelAndView就有点大材小用了，不适合。
```



### 2、返回值类型是String类型

```
当我们使返回值类型是字符串时，该字符串的名字是要跳转的视图的逻辑名（配置了视图解析器）或者是视图资源的根完整路径（不配置视图解析器），
```

### 创建项目模块c-springmvc-return-03，内容使用02中的所有代码及文件，具体修改的如下所示

1）、OtherController类的处理器方法如下：

```java
package com.studymyself.controller;

import com.studymyself.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/test")
public class OtherController {

    /**
     *  处理器方法的返回值为：String--表示逻辑视图的名称。需要配置视图解析器
     */
    @RequestMapping(value = "/returnString-view1.do",method = RequestMethod.POST)
    public String  doReturnView1(String name,int age,HttpServletRequest request) {

        System.out.println("name:"+name+"\nage:"+age);
        //EL表达式获取的值是在request作用域中的，现在不是ModelAndView
        //我们可以在方法的形参中自定义一个HttpServletRequest参数
        //让SpringMVC框架给其赋值，使用该参数的对象将请求参数的值
        //手工放到request作用域中
        request.setAttribute("myName",name);
        request.setAttribute("myAge",age);

        //other:视图的逻辑名称，前提是项目的spring.xml文件配置了视图解析器
        //返回后框架会对视图执行forward操作
        return "other";

    }


    /**
     *  处理器方法的返回值为：String--表示逻辑视图完整路径。不能配置视图解析器
     */
    @RequestMapping(value = "/returnString-view2.do",method = RequestMethod.POST)
    public String  doReturnView2(String name,int age,HttpServletRequest request) {

        System.out.println("name:"+name+"\nage:"+age);
        request.setAttribute("myName",name);
        request.setAttribute("myAge",age);

        //返回视图的完整路径，前提是项目的spring.xml文件不能配置视图解析器
        //如果配置了，会把这个字符串和视图解析器的前后缀拼接，最后的结果是
        //框架会转到/WEB-INF/view//WEB-INF/view/other.jsp.jsp的资源，这肯定是错误URL
        return "/WEB-INF/view/other.jsp";

    }


}

```

2）、index.jsp如下：

```jsp
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
</body>
</html>

```

3）、跳转的视图页面other.jsp如下：

```jsp
<%--
  Created by IntelliJ IDEA.
  User: 钟荣杰
  Date: 2021/2/15
  Time: 0:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>/WEB-INF/view/other.jsp从request作用域中获取数据</h3>
<!--把结果取出来，通过EL表达式${key值}来取值-->
<h3>name数据：${myName}</h3>
<h3>age数据：${myAge}</h3>
</body>
</html>

```

启动Tomcat服务器进行测试：

![](F:\Git_Repositories\SpringMVC\截图\web\8.png)

![](F:\Git_Repositories\SpringMVC\截图\web\9.png)

![](F:\Git_Repositories\SpringMVC\截图\web\10.png)

![](F:\Git_Repositories\SpringMVC\截图\web\11.png)