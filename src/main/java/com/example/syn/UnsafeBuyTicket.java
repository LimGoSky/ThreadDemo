package com.example.syn;

import lombok.SneakyThrows;

import java.util.ArrayList;

//不安全的买票
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket bt = new BuyTicket();
        new Thread(bt, "我").start();
        new Thread(bt, "你").start();
        new Thread(bt, "黄牛党").start();
    }
}

class BuyTicket implements Runnable {
    //票
    private int ticketNums = 10;
    boolean flag = true;//外部停止方式

    @Override
    public void run() {
        //买票
        while (flag) {
            buy();
        }
    }


    public synchronized void buy() {//锁了方法，相当于this 把类给锁住

        //判断是否有票
        if (ticketNums <= 0) {
            System.out.println("票没了");
            flag = false;
            return;
        }
        //模拟延时
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //买票
        System.out.println(Thread.currentThread().getName() + "拿到" + ticketNums--);
    }
}

