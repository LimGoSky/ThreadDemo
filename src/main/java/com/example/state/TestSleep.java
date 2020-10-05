package com.example.state;


import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSleep {
    public static void main(String[] args) {
        tenDown();
        //打印当前系统时间
        Date startTime=new Date(System.currentTimeMillis());//获取当前系统时间
        while (true){
            try {
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
                startTime=new Date(System.currentTimeMillis());//更新时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //模拟倒计时
    public static void tenDown(){
        int num=10;
        while (true){
            try {
                Thread.sleep(1000);
                if (num<=0){
                    break;
                }else{
                    System.out.println("倒计时！！！"+num--+"秒");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
