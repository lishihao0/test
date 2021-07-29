package com.kuang.Thread;

//抢票问题
public class TestRunnable implements Runnable {

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
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+"---->拿到了第"+TicketNum--+"张票");
        }
    }

    public static void main(String[] args) {
        new Thread(new TestRunnable(),"李世豪").start();
        new Thread(new TestRunnable(),"胡伟华").start();
        new Thread(new TestRunnable(),"李婉琼").start();
    }
}
