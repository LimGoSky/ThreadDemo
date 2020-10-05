package com.example.demo01;

public class TestThread4 implements Runnable {

    private static String winner;//胜利者
    @Override
    public void run() {
        for (int i = 0; i <=100 ; i++) {
            //模拟兔子休息
            if(Thread.currentThread().getName().equals("兔子")&& i%20==0){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //判断是否结束比赛
            boolean flag=gameOver(i);
            //如果比赛结束了，停止程序
            if(flag){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"-->跑了"+i+"步");
        }
    }
    //判断是否完成比赛
    private boolean gameOver(int steps){
        //判断是否有胜利者
        if(winner!=null){
            return true;
        }  {
            if (steps>=100){
                winner=Thread.currentThread().getName();
                System.out.println("winner is:"+winner);
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        new Thread(new TestThread4(),"兔子").start();
        new Thread(new TestThread4(),"乌龟").start();
    }
}
