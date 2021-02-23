package com.studymyself.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

//拦截器类：拦截用户的请求
public class MyInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Object attr = request.getSession().getAttribute("name");

        //判断是否是登录状态
        if (attr==null){

            request.getRequestDispatcher("/view/tip.jsp").forward(request,response);
            return false;

        }
        return true;

    }

}
