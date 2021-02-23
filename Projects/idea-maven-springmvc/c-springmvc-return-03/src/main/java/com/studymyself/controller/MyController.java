package com.studymyself.controller;

import com.studymyself.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/test")
public class MyController {

    /**
     * 处理方法返回一个Student对象，通过框架转为json，响应Ajax请求
     * @ResponseBody：
     *      作用：把处理器方法的返回对象转为的json字符串，通过HttpServletResponse
     *            输出给浏览器
     *      位置：写在方法的上面，与其他注解无先后顺序关系
     *
     *  返回对象时框架的处理流程：
     *      1、框架用返回的Student对象，调用框架中ArrayList<HttpMessageConverter>中的每个实现类的canWrite
     *      方法检测哪个实现类能够处理Student类型的数据-MappingJackson2HttpMessageConverter
     *      2、然后框架调用该MappingJackson2HttpMessageConverter的write方法，
     *      把返回的Student对象中各个属性的信息转为json字符串，用的是Jackson的ObjectMapper类
     *      中的方法，其中会设置 content=application/json;charset=utf-8
     *      3、最后框架调用@ResponseBody把2的结果数据输出到浏览器，请求完成
     * @return
     */

    @RequestMapping(value = "/returnJson.do",method = RequestMethod.GET)
    @ResponseBody
    public Student  doStudentJson() {
        Student student = new Student("离散",25);
        return student;

    }

    /**
     *  处理器方法返回值是List集合
     *  @ResponseBody：
     *      作用：把处理器方法的返回对象转为的json字符串，通过HttpServletResponse
     *           输出给浏览器
     *     位置：写在方法的上面，与其他注解无先后顺序关系
     *
     * 返回对象时框架的处理流程：
     *       1、框架用返回的List<Student>对象，调用框架中ArrayList<HttpMessageConverter>中的每个实现类的canWrite
     *          方法检测哪个实现类能够处理Student类型的数据-MappingJackson2HttpMessageConverter
     *       2、然后框架调用该MappingJackson2HttpMessageConverter的write方法，
     *          把返回的Student对象中各个属性的信息转为json字符串的ArrayJson数组，用的是Jackson的ObjectMapper类
     *          中的方法，其中会设置 content=application/json;charset=utf-8
     *       3、最后框架调用@ResponseBody把2的结果数据输出到浏览器，请求完成
     * @return
     */
    @RequestMapping(value = "/returnListJson.do",method = RequestMethod.GET)
    @ResponseBody
    public List<Student> doStudentListJson() {

        Student student1 = new Student("离散",25);
        Student student2 = new Student("李四",99);

        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);

        return studentList;

    }

    /**
     * 处理器方法返回的是String，这里的String表示数据，不是逻辑视图
     * 区分返回的是String是数据还是视图，就看方法上面有没有@ResponseBody注解
     * 有该注解，框架底层把返回的字符串输出到浏览器上，没有就会调用跳转资源的方法
     *
     *  默认使用 text/plain;charset=ISO-8859-1 作为contentType
     *  这样返回的数据会出现中文乱码，需要设置@ResponseMapping注解中的produces属性，
     *  指定新的contentType,此时注解中的value就不能省略了
     *
     * 返回对象时框架的处理流程：
     *       1、框架用返回的String对象，调用框架中ArrayList<HttpMessageConverter>中的每个实现类的canWrite
     *          方法检测哪个实现类能够处理String型的数据-StringHttpMessageConverter
     *       2、然后框架调用该StringHttpMessageConverter的write方法，
     *          把返回的字符串按照指定的编码方式进行处理：text/plain;charset=ISO-8859-1
     *       3、最后框架调用@ResponseBody把2的结果数据输出到浏览器，请求完成
     */
    @RequestMapping(value = "/returnStringData.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String doStringData(){
        return "SpringMVC的控制器方法返回String对象：表示数据";
    }

}
