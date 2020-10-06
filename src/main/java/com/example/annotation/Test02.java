package com.example.annotation;

import java.lang.annotation.*;

//测试元注解
@MyAnnotation
public class Test02 {

    @MyAnnotation
    public void test(){

    }
}

//定义一个注解
@Target(value = {ElementType.METHOD,ElementType.TYPE})

//Retention表示在什么地方有效
@Retention(value = RetentionPolicy.RUNTIME)

//Documented 说明该注解将被包含在javadoc中
@Documented

//Inherited  说明子类可以继承父类中的该注解
@Inherited
@interface MyAnnotation{

}