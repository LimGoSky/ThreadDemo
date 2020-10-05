package com.example.syn;

import lombok.SneakyThrows;

import java.util.ArrayList;

//不安全取钱
//两个人去银行取钱，账户
public class UnsafeBank {
    public static void main(String[] args) {
        //账户
        Account account = new Account(100, "结婚基金");
        Drawing you = new Drawing(account, 50, "你");
        Drawing girlFriend = new Drawing(account, 100, "女朋友");
        you.start();
        girlFriend.start();
    }
}

//账户
class Account {
    int money;//余额
    String name;//卡名

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

//银行：模拟取款
class Drawing extends Thread {
    Account account;//账户
    //取了多少钱；
    int drawingMoney;
    //现在手里有多少钱
    int nowMoney;

    public Drawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;

    }

    //取钱
    @SneakyThrows
    @Override
    public void run() {
        synchronized (account) {//锁的对象是变化的量，锁需要增删改的对象
            //判断有没有钱
            if (account.money - drawingMoney <= 0) {
                System.out.println(Thread.currentThread().getName() + "钱不够");
                return;
            }

            //sleep方法放大问题发生
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //卡内余额
            account.money -= drawingMoney;
            //手里的钱
            nowMoney += drawingMoney;
            System.out.println(account.name + "余额为:" + account.money);
            System.out.println(this.getName() + "手里的钱:" + nowMoney);
        }
    }
}

class UnsafeList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                synchronized (list) {
                    list.add(Thread.currentThread().getName());
                }
            }).start();
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(list.size());
    }
}
