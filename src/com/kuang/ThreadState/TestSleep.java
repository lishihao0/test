package com.kuang.ThreadState;

public class TestSleep implements Runnable {

    //票数
    private int TicketNum = 10;

    @Override
    public void run() {
        while (true){

            if (TicketNum<=0){
                break;
            }
            //模拟延时：
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+"---->拿到了第"+TicketNum--+"张票");
        }
    }

    public static void main(String[] args) {
        TestSleep testSleep = new TestSleep();

        new Thread(testSleep,"李世豪").start();
        new Thread(testSleep,"胡伟华").start();
        new Thread(testSleep,"李婉琼").start();
    }
}
