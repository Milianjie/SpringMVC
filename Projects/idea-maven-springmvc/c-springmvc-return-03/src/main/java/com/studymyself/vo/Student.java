package com.studymyself.vo;

/**
 * 保存参数的一个普通类
 */
public class Student {

    //要求是属性名和参数名一致
    private String name;
    private Integer age;

    //无参构造中输出一句话，验证框架是否调用了无参构造创建Student对象
    public Student() {
        System.out.println("====Student无参构造执行====");
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    //在set方法中输出一句话，验证框架是否调用了set方法给该对象赋值
    public void setName(String name) {
        System.out.println("setName方法执行："+name);
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        System.out.println("setAge方法执行："+age);
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
