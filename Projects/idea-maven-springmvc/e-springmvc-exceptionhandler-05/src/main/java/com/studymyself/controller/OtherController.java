package com.studymyself.controller;

import com.studymyself.exception.AgeException;
import com.studymyself.exception.MyUserException;
import com.studymyself.exception.NameException;
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


    @RequestMapping(value = "/otherOne.do",method = RequestMethod.POST)
    public ModelAndView doOtherOne(String name,Integer age) throws MyUserException {

        System.out.println(name+"\n"+age);
        ModelAndView modelAndView = new ModelAndView();

        //根据请求参数抛出异常
        if (!"niu".equals(name)){
            throw new NameException("用户名不合法");
        }
        if ((age < 0 || age>130)){
            throw new AgeException("年龄不合法");
        }
        modelAndView.addObject("myName",name);
        modelAndView.addObject("myAge",age);
        modelAndView.setViewName("other");

        return modelAndView;

    }

}
