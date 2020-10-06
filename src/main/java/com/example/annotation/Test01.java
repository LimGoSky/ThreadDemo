package com.example.annotation;

import java.util.ArrayList;
import java.util.List;

public class Test01 extends Object {

    @Override
    public String toString() {
        return super.toString();
    }

    //不推荐使用注解，可以使用但是又风险或者有更好的方式
    @Deprecated
    public static void test01(){
        System.out.println("123");
    }

    @SuppressWarnings("all")
    public void test02(){
        List list = new ArrayList();
    }

    public static void main(String[] args) {
        test01();
    }
}
