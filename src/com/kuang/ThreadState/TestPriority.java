package com.kuang.ThreadState;

public class TestPriority {
    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName()+"--->"+Thread.currentThread().getPriority());

        MyPriority myPriority = new MyPriority();

        Thread t1 = new Thread(myPriority);
        Thread t2 = new Thread(myPriority);
        Thread t3 = new Thread(myPriority);
        Thread t4 = new Thread(myPriority);
        Thread t5 = new Thread(myPriority);


        //先设置优先级再启动
        t1.setPriority(Thread.MIN_PRIORITY);
        t1.start();

        t2.setPriority(3);
        t2.start();

        t3.setPriority(6);
        t3.start();

        t4.setPriority(4);
        t4.start();

        t5.setPriority(Thread.MAX_PRIORITY);
        t5.start();
    }
}

class MyPriority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"--->"+Thread.currentThread().getPriority());
    }
}
