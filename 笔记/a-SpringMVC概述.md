### 概述

```sql
--SpringMVC：
	是一个基于Spring的框架，就是Spring框架的一个子框架，或者说模块，主要是用来做web开发的
	可以理解为Servlet的升级，就像mybatis一样帮助我们简化了使用Servlet的步骤
	web开发底层是Servlet，框架是在Servlet基础上面加入一些功能，更加便捷的做Web开发
	
--SpringMVC是基于Spring的，所以SpringMVC就是一个Spring，因为该框架用到的所有东西都是Spring的，所以和Spring一样，可以使用IOC来管理创建对象，也有容器存储对象，使用<bean>,@Component,@Repository,@Service,@Controller
	SpringMVC能够创建对象，放入到SpringMVC容器中，但是区别是该容器只存放控制器对象。
	
--使用SpringMVC框架：
	要做的是使用@Controller注解创建控制器对象，把对象放入到SpringMVC容器中，把创建的对象作为控制器使用。需要明白的是：
		这个控制器对象可以间接接收用户的请求，然后显示处理结果，我们可以把它当做一个Servlet对象使用，但实质上	   并不是Servlet对象，没有继承HttpServlet类，就是一个普通类，但是@Controller通过SpringMVC框架给这个类赋予
	 了Servlet对象的一些功能，这样的对象称之为控制器对象，简称控制器。
	 
--web开发底层直接接收用户请求的对象：
	SpringMVC中有一个对象是Servlet：DispatcherServlet（中央调度器对象，简称中央调度器）。
	作用是负责接收用户的所有请求。用户把请求给了DispatcherServlet，DispatherServlet把请求转发给我们的
	Controller对象，即前面说的控制器，然后控制器对象处理请求
	
--原理：
index.jsp页面中的各种请求->DispatcherServlet(Servlet)接收->根据要求转发、分配给对应的->Controller对象（控制器）
```

