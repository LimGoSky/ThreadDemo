package com.example.demo01;

//创建多线程方式2：实现Runnable接口，重写run方法，执行线程需要丢入runnable接口实现类，调用start方法
public class TestThread3 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <200 ; i++) {
            System.out.println("多线程被执行了" + i);
        }
    }

    public static void main(String[] args) {
        new Thread(new TestThread3()).start();
        for (int i = 0; i <1000 ; i++) {
            System.out.println("每天都在学习java" + i);
        }
    }
}
