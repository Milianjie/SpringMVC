package com.studymyself.controller;

import com.studymyself.entity.User;
import com.studymyself.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    /**
     * 用户注册
     * @param user
     * @return
     */
    @RequestMapping("/addUser")
    public ModelAndView register(User user){

        ModelAndView mav = new ModelAndView();

        //首先判断注册名是否重复，然后进行提示
        Object o = null;
        String tips1 = "注册失败";
        String tips2 = "用户名已存在，请重新输入";

        o = userService.queryByLoginName(user.getLoginName());

        if (o!=null){

            mav.addObject("tips2",tips2);
            mav.setViewName("tip");
            return mav;

        }else if (userService.addUser(user)>0){

            tips1 = "用户<br>【"+user+"】<br>注册成功";

        }
        mav.addObject("tips1",tips1);
        mav.setViewName("result");
        return mav;
    }

    /**
     * 处理查询，响应Ajax
     * @return
     */
    @RequestMapping("/browserUser")
    @ResponseBody
    public List<User> browserUser(){

        List<User> userList = userService.queryAll();
        return userList;

    }

}
