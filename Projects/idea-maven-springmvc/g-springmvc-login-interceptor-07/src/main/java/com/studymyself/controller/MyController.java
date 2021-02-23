package com.studymyself.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/myInterceptor")
public class MyController {


    @RequestMapping("/some.do")
    public ModelAndView doSome(String name,Integer age){

        System.out.println("==执行doSome方法==");

        ModelAndView mv = new ModelAndView();
        mv.addObject("myName",name);
        mv.addObject("myAge",age);

        mv.setViewName("show");

        return mv;

    }

}
