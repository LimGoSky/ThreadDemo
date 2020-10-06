package com.example.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//获得类的信息
public class Test08 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class c1 = Class.forName("com.example.reflection.User");

        System.out.println(c1.getName()); //包名 + 类名
        System.out.println(c1.getSimpleName()); //获得类名

        //获得类的属性
        System.out.println("===============================");
        Field[] fields = c1.getFields(); //只能找到public属性

        fields = c1.getDeclaredFields();// 全部属性
        for (Field field : fields) {
            System.out.println(field);
        }

        //获得指定属性的值
        Field name = c1.getDeclaredField("name");
        System.out.println(name);


        System.out.println("===============================");
        Method[] methods = c1.getMethods();//获得本类和父类的所有方法
        for (Method method : methods) {
            System.out.println("正常的" + method);
        }

        methods = c1.getDeclaredMethods();//获得本类的所有方法
        for (Method method : methods) {
            System.out.println("getDeclaredMethods" + method);
        }

        //获得指定方法
        Method getname = c1.getMethod("getName", null);
        Method setname = c1.getMethod("setName", String.class);
        System.out.println(getname);
        System.out.println(setname);

        //获得指定构造器
        System.out.println("===============================");
        Constructor[] constructors = c1.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructors);
        }
        Constructor[] declaredConstructors = c1.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println("#" + declaredConstructor);
        }

        Constructor declaredConstructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        System.out.println(declaredConstructor);

    }
}
