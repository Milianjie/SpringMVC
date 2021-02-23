package com.studymyself.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

//拦截器类：拦截用户的请求
public class MyInterceptor implements HandlerInterceptor {

    long begin;

    /**
     *  preHandler叫做预处理方法：
     *      非常重要：是整个项目的入口、门户。
     *      当preHandle返回true，请求可以被处理；反之请求被拦截
     *  参数：
     *      Object handler：是被拦截的控制器对象，就是Controller对象，在配置文件中声明
     *                      拦截器的步骤中，框架会根据指定的信息自动给该参数赋值
     *  返回值boolean：
     *      true：说明请求通过了拦截器的验证，可以执行处理器方法
     *      输出如下：
     *      拦截器MyInterceptor的preHandle方法执行
     *      ==执行doSome方法==
     *      拦截器MyInterceptor的postHandle方法执行
     *      拦截器MyInterceptor的afterCompletion方法执行
     *
     *      false：说明请求无法通过了拦截器的验证，请求到达拦截器就截止了，请求没有被处理
     *      输出如下：
     *      拦截器MyInterceptor的preHandle方法执行
     *
     *  特点：
     *      1、在控制器方法执行之前执行
     *      用户的请求首先到达这里
     *      2、在该方法中我们可以获取请求的信息，然后验证是否符合要求。如
     *      验证用户是否是登入状态发送该请求，验证用户是否有该权限访问这个资源链接
     *      验证失败，返回false，即可截断请求，请求不能被处理
     *      验证成功，返回true，放行请求，执行对应的控制器方法
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        begin = System.currentTimeMillis();
        System.out.println("111拦截器MyInterceptor的preHandle方法执行111");
        boolean re = true;
        //在这里获取请求信息，计算业务逻辑，根据计算结果，返回true或是false
        if (!re){
            request.getRequestDispatcher("/view/tip.jsp").forward(request,response);
            return re;
        }
        return re;
    }

    /**
     *  postHandler方法:处理器方法执行完毕后，请求还未完成前执行
     *  参数：
     *      Object handler：是被拦截的控制器对象，就是Controller对象，在配置文件中声明
     *                      拦截器的步骤中，框架会根据指定的信息自动给该参数赋值
     *      ModelAndView mv：框架将处理器方法执行的返回值赋值给该参数mv
     *  特点：
     *      1、理器方法执行完毕后，请求还未完成前执行该方法
     *      2、在该方法中获取处理器方法的ModelAndView返回值mv，可以修改
     *      mv中的数据和视图，影响最后的执行结果
     *      作用：对原来执行结果进行二次修正
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("111拦截器MyInterceptor的postHandle方法执行111");

        //通过获取处理器方法中的返回值ModelAndView，通过
        //判断返回的数据视图是否符合预期结果，不符合就调整，或者是给
        //处理器方法的执行结果进行增添
        if (modelAndView!=null){
            //对返回值中的数据进行添加
            modelAndView.addObject("myDate",new Date());
            //不修改视图
        }
    }

    /**
     *  afterCompletion方法：在请求处理完成后执行
     *  参数：
     *      Object handler：被拦截的控制器对象，就是Controller对象
     *      Exception ex：处理器方法发生的异常
     *  特点：
     *      1、在请求被处理完成后执行该方法。
     *      框架中是规定在视图处理完成后，即底层对视图执行转发forward方法后认为请求处理完成
     *      2、一般做资源回收工作，程序请求过程中创建了一些对象，可以在该方法中进行回收，释放内存
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("111拦截器MyInterceptor的afterCompletion方法执行111");
        long end = System.currentTimeMillis();
        //这里计算从preHandle方法开始到请求处理完成的时间
        //System.out.println("计算preHandle方法开始执行到请求处理完成时间："+(end-begin));
    }
}
