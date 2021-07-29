package com.kuang.Thread;

public class TestThread1 extends Thread{
    @Override
    public void run() {
        //run方法线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("李世豪"+i);
        }
    }

    public static void main(String[] args) {
        //main方法线程  主线程
        //创建一个线程对象
        TestThread1 testThread1 = new TestThread1();
        //调用start方法开启线程
        testThread1.start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("胡伟华"+i);
        }
    }
}
