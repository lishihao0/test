package com.kuang.ThreadSyn;

import java.util.concurrent.locks.ReentrantLock;

//不安全的买票
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket station = new BuyTicket();

        new Thread(station,"李世豪").start();
        new Thread(station,"胡伟华").start();
        new Thread(station,"李婉琼").start();
    }

}


class BuyTicket implements Runnable{

    private int TicketNum = 10;
    boolean flag = true; //外部停止方式
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        //买票
        while (flag){
            try {
                lock.lock();
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private void buy() throws InterruptedException {

        //判断是否有票
        if (TicketNum <= 0){
            flag = false;
            return;
        }
        //模拟延时
//        Thread.sleep(100);
        //买票
        System.out.println(Thread.currentThread().getName()+"拿到了第"+TicketNum--);

    }
}