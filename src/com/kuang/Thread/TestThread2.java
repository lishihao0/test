package com.kuang.Thread;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

//实现多线程同步下载图片
public class TestThread2 extends Thread{

    String url;
    String name;
    public TestThread2(String url,String name) {
        this.url=url;
        this.name=name;
    }

    //下载图片执行脚本
    @Override
    public void run() {
        DownLoad downLoad = new DownLoad();
        try {
            downLoad.download(url,name);
            System.out.println("下载了文件名为："+name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestThread2 t1 = new TestThread2("https://www.zhihuishu.com/assets/images/newschool-logo.png","1.jpg");
        TestThread2 t2 = new TestThread2("https://i2.hdslb.com/bfs/face/83bb511365da513c55aa3d1958524f3b7db40684.jpg@128w_128h_1o.webp","2.jpg");
        TestThread2 t3 = new TestThread2("https://image.zhihuishu.com/zhs/ablecommons/demo/201804/8bd7921d786148e0a990dc9bfa8ff9cc.jpg","3.jpg");
        t1.start();
        t2.start();
        t3.start();
    }
}


//下载器
class DownLoad{

    public void download(String url,String name) throws IOException {

        URL PhotoUrl = new URL(url);
        HttpURLConnection urlConnection = (HttpURLConnection) PhotoUrl.openConnection();

        InputStream inputStream = urlConnection.getInputStream();
        FileOutputStream fos = new FileOutputStream(name);
        byte[] buffer = new byte[1024];
        int len;
        while ((len=inputStream.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        fos.close();
        inputStream.close();
        urlConnection.disconnect();

    }
}
