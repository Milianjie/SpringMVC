### 在jsp、html文件中使用超链接的地址，都是在前端页面（浏览器URL地址栏上）中的地址，是相对地址

### 地址的分类：

1、绝对地址，带有协议名称的是绝对地址。http://www.baidu.com，ftp://202.122.23.1。绝对地址在网络中的唯一的，访问绝对地址具备访问一个网络资源的所有条件

2、相对地址，没有协议开头的。如 user/some.do  ，/user/some.do  相对地址不能独立使用，只是一个项目中的确定一个资源的地址，必须有一个参考地址。通过参考地址+相对地址才能指定资源

### 参考地址：

### 1、在页面中（如index.jsp的文件中的超链接地址前面不加 "/"）访问如下地址

http://localhost:8080/c_springmvc_return_03/index.jsp

路径是：http://localhost:8080/c_springmvc_return_03/

c_springmvc_return_03/项目的资源路径是：index.jsp

然后在index.jsp中发起请求 user/some.do 请求，访问地址变为：

http://localhost:8080/c_springmvc_return_03/user/some.do

参考地址就是：http://localhost:8080/c_springmvc_return_03/

结论：

当超链接中的地址没有斜杠开头，如 user/some.do，点击跳转该超链接时，访问的地址是当前页面的地址加上链接的地址

### 有一种情况就是，我们在控制器方法doSome中返回index.jsp，然后点击页面中的超链接，该链接仍然是请求doSome方法的。如下：

```java
我们直接访问doSome方法的URL：
http://localhost:8080/c_springmvc_return_03/user/some.do
资源是：some.do
展示的页面是：index.jsp，里面有超链接 user/some.do
参考地址是除去资源，即URL的最后部分，如果在该URL下的资源有跳转到其他资源的无斜杠链接，点击跳转访问的地址就是：
    除去本URL资源的地址+无斜杠链接  
所以此时的参考地址变为：http://localhost:8080/c_springmvc_return_03/user/ 因为你的资源是some.do
那我们点击超链接：user/some.do
访问地址为：http://localhost:8080/c_springmvc_return_03/user/user/some.do，肯定报404

解决方法1：
    在超链接中前面添加斜杠"/","/"前面添加本项目部署在Tomcat服务器中的项目名，可以用							pageContext.request.contextPath来获取页面中URL路径的部署项目名，然后用EL表达式放到斜杠前面
    ${pageContext.request.contextPath}/user/some.do
解决方法2：
    使用base标签：是html语言的标签。用该标签定义当前页面中的所以没有/开头的超链接的基地址
    即点击超链接是后的访问地址是 base标签的基地址+user/some.do
  	具体使用如下截图：
```

![](F:\Git_Repositories\SpringMVC\截图\web\18.png)

### 2、在页面中（如index.jsp的文件中的超链接地址前面加 "/"）访问如下地址

http://localhost:8080/c_springmvc_return_03/index.jsp

路径是：http://localhost:8080/c_springmvc_return_03/

c_springmvc_return_03/项目的资源路径是：index.jsp

然后在index.jsp中发起请求 /user/some.do 请求，访问地址变为：

http://localhost:8080/user/some.do 

参考地址：http://localhost:8080/

就是说如果超链接添加斜杠，你得在斜杠前面添加部署到服务器后的该项目的项目名，当要跳转的请求是访问index.jsp页面所在的项目的资源时，可以不加斜杠，当我们要访问的是另一个项目的资源时添加斜杠，斜杠天面添加另一个项目部署在服务器后的项目名。

