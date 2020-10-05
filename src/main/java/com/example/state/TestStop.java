package com.example.state;

//测试stop
//1.建议线程正常停止-->利用次数，不建议死循环
//2.建议使用标识位-->设置一个标志位
//3.不要使用stop或者destory等果实或者jdk不建议使用的方法
public class TestStop implements Runnable {

    //1.设置一个标识位
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println("run...Thread" + i++);
        }
    }

    //2.设置一个公开的方法停止线程

    public void stop() {
        this.flag = false;
    }

    public static void main(String[] args) {
        TestStop testStop = new TestStop();

        new Thread(testStop).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("main" + i);
            if (i == 900) {
                //线程停止
                testStop.stop();
                System.out.println("该线程停止了");
            }
        }
    }
}
