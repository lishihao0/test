package com.kuang.ThreadState;

public class TestYield implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程开始");
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+"线程结束");
    }

    public static void main(String[] args) {
        TestYield testYield = new TestYield();
        new Thread(testYield,"a").start();
        new Thread(testYield,"b").start();
    }
}
