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
