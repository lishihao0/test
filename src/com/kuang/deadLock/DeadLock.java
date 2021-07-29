package com.kuang.deadLock;

//死锁：多个线程拿着对方的资源不放手
public class DeadLock {
    public static void main(String[] args) {
        makeup LI = new makeup(0,"李世豪");
        makeup HU = new makeup(1,"胡伟华");
        LI.start();
        HU.start();
    }
}

//口红
class Lipstick{

}
//镜子
class mirror{

}

//化妆
class makeup extends Thread{
    //每个资源只有一份
    static Lipstick lipstick = new Lipstick();
    static mirror mirror = new mirror();

    int choice;  //选择
    String name; //名字

    public makeup(int choice,String name){
        super(name);
        this.choice = choice;
        //this.name = name;
    }

    @Override
    public void run() {
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //化妆，互相持有对方所需资源的锁
    public void makeup() throws InterruptedException {
        if (choice == 0){
            synchronized (lipstick){
                System.out.println(Thread.currentThread().getName()+"拿到了口红的锁");
                Thread.sleep(1000);
            }
            synchronized (mirror){
                System.out.println(Thread.currentThread().getName()+"一秒后拿到了镜子的锁");
            }
        }else {
            synchronized (mirror){
                System.out.println(Thread.currentThread().getName()+"拿到了镜子的锁");
                Thread.sleep(1000);
            }
            synchronized (lipstick){
                System.out.println(Thread.currentThread().getName()+"两秒后拿到了口红的锁");
            }
        }
    }
}