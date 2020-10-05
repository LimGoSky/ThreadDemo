package com.example.state;

public class TestJoin implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("VIP线程来插队了！！！" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new TestJoin());
        thread.start();

        for (int i = 0; i < 400; i++) {
            System.out.println("主线程在排队！！！" + i);
            if (i == 100) {
                thread.join();

            }
        }
    }
}
