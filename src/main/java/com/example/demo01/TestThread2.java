package com.example.demo01;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

//多线程下载图片
public class TestThread2 extends Thread{
    private String url;//保存网络图片地址
    private String name;//保存的文件名
    public TestThread2(String url, String name){
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownLoader webDownLoader = new WebDownLoader();
        webDownLoader.downLoader(url,name);
        System.out.println("图片下载成功，名为："+name);
    }

    public static void main(String[] args) {
        TestThread2 t1 = new TestThread2("https://dss0.baidu.com/73t1bjeh1BF3odCf/it/u=1561546013,1259770086&fm=85&s=1A21EC02EE337FAF0854119903001062","1.jpg");
        TestThread2 t2 = new TestThread2("https://dss0.baidu.com/73t1bjeh1BF3odCf/it/u=3506652242,2368086075&fm=85&s=8C9F875066675AAE078DE4D6030050F1","2.jpg");
        TestThread2 t3 = new TestThread2("https://dss0.baidu.com/73t1bjeh1BF3odCf/it/u=2623032014,2137091052&fm=85&s=F4C2BE56F74162EE0E5EEC7C03004071","3.jpg");
        t1.start();
        t2.start();
        t3.start();
    }
}

class WebDownLoader{
    public void downLoader(String url, String name){
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件下载失败，Io有问题");//文件下载失败
        }
    }
}