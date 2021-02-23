package com.studymyself.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Controller:创建处理器对象，然后放到SpringMVC容器中
 */
@Controller
public class MyController {

    /**
     * 里面的方法处理用户提交的请求
     * SpringMVC中的方法是自定义的，可以有多种返回值，多种参数，自定义名称
     */

    /**
     * 这里使用doSome方法处理xxx/some.do请求
     * 如何定位到这个方法呢？
     * @RequestMapping：请求映射，作用是吧一个请求的URL地址和一个方法绑定到一块
     *                  一个请求指定一个方法来处理请求
     *        属性：
     *        value：是String类型的数组，让多个请求共用一个处理方法
     *               填的值是请求的URL地址（这里是some.do）
     *               该值必须是唯一的，不能重复。使用时推荐以"/"开头的地址
     *        在方法上面使用，也可以在类上面使用
     *  使用@RequestMapping修饰的方法叫做处理器方法或者控制器方法，当于我们在doGet或者doPost方法
     *  中编写处理代码
     *
     *  返回值：ModelAndView类型，表示本次请求的处理结果，是Spring框架中的一个类
     *  Model：表示可以保存数据，请求处理完成后，显示给用户看的
     *  View：视图，如jsp等
     *
     */
    //@RequestMapping(value = {"/some.do","first.do"})
    @RequestMapping(value = "/some.do")
    public ModelAndView doSome(){   //相当于doGet/doPost方法

        //这里语句相当于调用service中的方法

        ModelAndView modelAndView = new ModelAndView();
        //然后把返回结果存储到ModelAndView对象中,该对象是键值对的map集合
        modelAndView.addObject("msg","SpringMVC的第一个实例项目");
        modelAndView.addObject("fun","非常高兴认识您");

        //下面指定视图。指定的是完整的路径，框架底层会对其进行forward的操作
//        modelAndView.setViewName("WEB-INF/view/show.jsp");
//        modelAndView.setViewName("WEB-INF/view/other.jsp");

        //当声明配置视图解析器后，直接使用文件逻辑名指定视图
        //原理是框架会使用配置的视图解析器的前缀属性值+逻辑名称+后缀属性值，字符串拼接组成路径
        //  /WEB-INF/view/+show+.jsp
        modelAndView.setViewName("show");
        //modelAndView.setViewName("other");

        return modelAndView;
        //这里执行 return modelAndView; 语句后，SpringMVC框架底层执行如下：
        /*
            把执行addObject方法中的得到的数据放入到Request作用域中
            request.setAttribute("msg","SpringMVC的第一个实例项目");
            request.setAttribute("fun","非常高兴认识您");

            把执行setViewName的方法在底层执行如下重定向语句：
            request.getRequestDispatcher("/show.jsp").forward(request,response);
         */

    }
}
