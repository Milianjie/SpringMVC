package com.studymyself.handler;

import com.studymyself.exception.AgeException;
import com.studymyself.exception.NameException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ControllerAdvice:
 *  该注解放在类上面，顾名思义，这个类就是一个控制器增强
 *  因为之前我们使用AOP技术给业务方法进行功能增强时，用的就是Advice通知注解
 *  Advice可以看做增强的意思，这里就是给控制器类进行功能增强，新功能就是
 *  给所有控制器的所有方法增加异常处理
 *  位置：定义类的上面
 *  特点：需要让框架知道这个注解所在的包名，在SpringMVC配置文件中声明组件扫描器指定包名
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    //在该类中定义方法，处理发生的异常
    /**
     * 处理异常的方法和定义控制器方法一样，方法中可以有多个参数，返回值
     * 可以是ModelAndView、String、void、对象类型
     *
     *  当参数是异常类型时，可以是Exception对象，
     *  方法之中可以通过该异常对象获取抛出的异常信息
     *
     *  注解@ExceptionHandler(XxxException.class)
     *    其中有个value属性，是Class类型的，填写某个异常，表示
     *    当我们的Controller类中的某个方法发生所填写的异常时
     *    就由当前方法处理
     *    value的值我们可以填写控制器方法中具体的某个异常类型，
     *    创建多个方法分别处理控制器方法发生的异常，但是我们一般
     *    都是定义一个方法，value的值填Exception.class，这样抛出
     *    的所有异常都交给这个方法处理
     */
    @ExceptionHandler(value = NameException.class)
    public ModelAndView doOtherOneNameException(Exception e){
        //处理NameException异常
        /**
         * 在该方法中异常发生的处理逻辑：
         * 1、需要把异常记入下来，记入到数据库，日志文件
         *  记入发生的时间、哪个方法、异常的错误内容到日志
         * 2、发送通知，把异常信息通过邮件，短信，微信等方式发送给相关人员
         * 3、给用户提供友好提示
         * 1和2实现比较复杂，这里只是实现3
         */
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","姓名必须是niu，其他输入无法访问");
        modelAndView.addObject("e",e);
        modelAndView.setViewName("nameError");
        return modelAndView;
    }

    @ExceptionHandler(value = AgeException.class)
    public ModelAndView doOtherOneAgeException(Exception e){
        //处理AgeException异常
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","年龄必须大于0小于130");
        modelAndView.addObject("e",e);
        modelAndView.setViewName("ageError");
        return modelAndView;
    }

    @ExceptionHandler(value = Exception.class)
    public ModelAndView doOtherOneException(Exception e){
        //处理非NameException和AgeException的其他异常
        //我们可以在整型的age属性填一个abc，这样的异常交给该方法进行处理
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","其他非法输入");
        modelAndView.addObject("e",e);
        modelAndView.setViewName("defaultError");
        return modelAndView;
    }

    /**
     * 处理流程：当我们的程序出现异常后，要么是向上抛，要么是
     *  而框架的异常处理就是将try/catch中catch语句块中内容和业务代码分开来，
     *  方法出现异常，框架将异常根据@Exceptionhandler中的值进行比较，符合哪一个
     *  就调用哪一个方法进行处理，这相当于是一个切面，只是增加在控制器Controller
     *  类中的，相当于运行在catch语句块中的内容
     */


}
