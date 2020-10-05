package com.example.demo03;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;


public class TestCallable implements Callable<Boolean> {
    private String url;//保存网络图片地址
    private String name;//保存的文件名
    public TestCallable(String url, String name){
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() {
        WebDownLoader webDownLoader = new WebDownLoader();
        webDownLoader.downLoader(url,name);
        System.out.println("图片下载成功，名为："+name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("https://dss0.baidu.com/73t1bjeh1BF3odCf/it/u=1561546013,1259770086&fm=85&s=1A21EC02EE337FAF0854119903001062","4.jpg");
        TestCallable t2 = new TestCallable("https://dss0.baidu.com/73t1bjeh1BF3odCf/it/u=3506652242,2368086075&fm=85&s=8C9F875066675AAE078DE4D6030050F1","5.jpg");
        TestCallable t3 = new TestCallable("https://dss0.baidu.com/73t1bjeh1BF3odCf/it/u=2623032014,2137091052&fm=85&s=F4C2BE56F74162EE0E5EEC7C03004071","6.jpg");

        //创建执行服务：
        ExecutorService ser= Executors.newFixedThreadPool(3);

        //提交执行：
        Future<Boolean> r1=ser.submit(t1);
        Future<Boolean> r2=ser.submit(t2);
        Future<Boolean> r3=ser.submit(t3);

        //获取结果：
        boolean rs1=r1.get();
        boolean rs2=r2.get();
        boolean rs3=r3.get();

        //关闭服务：
        ser.shutdownNow();
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
