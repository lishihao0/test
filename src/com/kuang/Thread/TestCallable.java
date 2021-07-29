package com.kuang.Thread;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.*;

public class TestCallable implements Callable<Boolean> {
    String url;
    String name;
    public TestCallable(String url,String name) {
        this.url=url;
        this.name=name;
    }

    @Override
    public Boolean call() {
        WebDownLoad downLoad = new WebDownLoad();
        try {
            downLoad.download(url,name);
            System.out.println("下载了文件名为："+name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("https://www.zhihuishu.com/assets/images/newschool-logo.png","1.jpg");
        TestCallable t2 = new TestCallable("https://i2.hdslb.com/bfs/face/83bb511365da513c55aa3d1958524f3b7db40684.jpg@128w_128h_1o.webp","2.jpg");
        TestCallable t3 = new TestCallable("https://image.zhihuishu.com/zhs/ablecommons/demo/201804/8bd7921d786148e0a990dc9bfa8ff9cc.jpg","3.jpg");
//        不使用线程池
//        FutureTask<Boolean> r1=new FutureTask<Boolean>(t1);
//        new Thread(r1).start();
//        Boolean rs1 = r1.get();


        //创建执行服务
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        //提交执行
        Future<Boolean> r1 = executorService.submit(t1);
        Future<Boolean> r2 = executorService.submit(t2);
        Future<Boolean> r3 = executorService.submit(t3);
        //获取结果
        Boolean rs1 = r1.get();
        Boolean rs2 = r2.get();
        Boolean rs3 = r3.get();
        //关闭服务
        executorService.shutdownNow();
    }
}

class WebDownLoad {

    public void download(String url, String name) throws IOException {

        URL PhotoUrl = new URL(url);
        HttpURLConnection urlConnection = (HttpURLConnection) PhotoUrl.openConnection();

        InputStream inputStream = urlConnection.getInputStream();
        FileOutputStream fos = new FileOutputStream(name);
        byte[] buffer = new byte[1024];
        int len;
        while ((len = inputStream.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }
        fos.close();
        inputStream.close();
        urlConnection.disconnect();

    }
}