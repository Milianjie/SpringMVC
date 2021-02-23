package com.studymyself.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
/**
 * @RequestMapping注解添加到类上面：
 * 作用是定义Controller类中的所有方法的公共映射路径，项目的模块名
 */
@RequestMapping(value = "/test")
public class OtherController {

    /**
     * @RequestMapping的method属性：
     *      表示的是设置请求的方式，一旦前端请求方式不符合，就无法调用该方法，报405错误
     *      值是RequestMethod枚举类，如要设置为GET请求访问，RequestMethod.GET,post就是
     *      RequestMethod.POST，具体的可以自己到该枚举类中查看
     *      不设置就可以是处理任意类型的请求
     */

    //指定doOtherOne()只能处理GET请求
    @RequestMapping(value = "/otherOne.do",method = RequestMethod.GET)
    public ModelAndView doOtherOne() {   //相当于doGet/doPost方法

        //这里语句相当于调用service中的方法

        ModelAndView modelAndView = new ModelAndView();
        //然后把返回结果存储到ModelAndView对象中,该对象是键值对的map集合
        modelAndView.addObject("msg", "SpringMVC的第一个实例项目");
        modelAndView.addObject("fun", "非常高兴认识您");

        modelAndView.setViewName("show");
        modelAndView.setViewName("other");

        return modelAndView;

    }

    //指定doOtherTwo()只能处理POST请求
    @RequestMapping(value = "/otherTwo.do",method = RequestMethod.POST)
    public ModelAndView doOtherTwo(){   //相当于doGet/doPost方法

        //这里语句相当于调用service中的方法

        ModelAndView modelAndView = new ModelAndView();
        //然后把返回结果存储到ModelAndView对象中,该对象是键值对的map集合
        modelAndView.addObject("msg","SpringMVC的第一个实例项目");
        modelAndView.addObject("fun","非常高兴认识您");

        modelAndView.setViewName("show");
        modelAndView.setViewName("other");

        return modelAndView;

    }

}
