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
     * 逐个接收参数：
     *      要求：处理器（控制器）方法的形参名和请求中的参数名一致
     *            这样同名的请求参数赋值给同名的形式参数
     *
     *     这种方式接收参数，其底层还是调用request对象中的方法实现的：
     *     1、底层使用request对象接收请求参数，获取处理器方法的形参名作为key
     *      String strName = request.getParameter("name");
     *      String strAge = request.getParameter("age");
     *
     *     2、当SpringMVC框架通过执行DispatcherServlet对象的方法来调用OtherController
     *     类的doOtherOne方法时按名称对应，把接收的参数赋值给方法的形参：
     *     doOtherOne(strName,Integer.valueOf(strAge));
     *
     *     上面request对象接收的参数都是字符串类型的
     *     所以框架给控制器方法中的形参赋值时会根据形参的类型将字符串自动转换为：
     *     int long float double等类型
     */

    @RequestMapping(value = "/otherOne.do",method = RequestMethod.POST)
    public ModelAndView doOtherOne(String name,int age) {
        //当age的输入参数是null或者非数字类型字符串，底层自动转换时会出现错误：400
        //我们数字类型的形参一般定义为Integer类型
        System.out.println("name:"+name+"\nage:"+age);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("myName",name);
        modelAndView.addObject("myAge",age);
        modelAndView.setViewName("other");

        return modelAndView;

    }

    /**
     * 请求中参数名和处理器方法中的形参名不一致
     * @RequestParam：解决请求中参数名和形参名不一样的问题
     *  属性：value：请求参数的名字
     *        required：是一个布尔类型，默认是true
     *                  true就表示请求中必须包含value的参数的值
     *                  就是相当于你直接访问http://localhost:8080//b_spring_webparam_02/test/othertwo.do
     *                  而注解@RequestParam中value的参数没有值，就会报错误400，如下面所示：
     *                  设置为required=false，就不需要参数myname和参数myage一定要有值
     *  位置：在处理器方法的形参定义的前面添加
     */
    @RequestMapping(value = "/othertwo.do",method = RequestMethod.POST)
    public ModelAndView doOtherTwo(@RequestParam(value = "myname",required = false) String name,
                                   @RequestParam(value = "myage",required = false) int age) {

        System.out.println("name:"+name+"\nage:"+age);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("myName",name);
        modelAndView.addObject("myAge",age);
        modelAndView.setViewName("other");

        return modelAndView;

    }

    /**
     * 处理器方法的形参是Java对象，该对象的属性名和请求参数名一样
     * 框架会使用反射机制自动帮我们创建该Java对象，给属性赋值。
     * 请求参数是name的值，框架会调用setName方法给Java对象的name属性赋值，set注入
     */
    @RequestMapping(value = "/otherthree.do",method = RequestMethod.POST)
    public ModelAndView doOtherThree(Student student) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("myName",student.getName());
        modelAndView.addObject("myAge",student.getAge());
        modelAndView.setViewName("other");

        return modelAndView;

    }

}
