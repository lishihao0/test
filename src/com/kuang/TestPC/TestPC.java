package com.kuang.TestPC;

//测试生产者消费者模型：利用缓冲区--管程法

//生产者、消费者、产品、缓冲区
public class TestPC {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();

        new Producer(container).start();
        new Consumer(container).start();
    }
}

class Producer extends Thread{
    SynContainer container;
    public Producer(SynContainer container){
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            container.push(new Chicken(i));
            System.out.println("生产了第"+i+"只鸡");
        }
    }
}



class Consumer extends Thread{
    SynContainer container;
    public Consumer(SynContainer container){
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {

            System.out.println("消费了第"+container.pop().id+"只鸡");
        }
    }
}


class Chicken{
    int id;

    public Chicken(int id) {
        this.id = id;
    }
}
//缓冲区
class SynContainer{
    //需要定义一个容器大小
    Chicken[] chickens = new Chicken[10];
    //计数器
    int count = 0;

    //生产者放入产品
    public synchronized void push(Chicken chicken){

        //如果容器满了，就要等待消费之消费
        if (count == chickens.length){
            try {
                System.out.println("容器满了");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果没满继续放入
        chickens[count] = chicken;
        count++;

        //生产完了通知消息这消费
        this.notifyAll();
    }

    //消费者消费产品
    public synchronized Chicken pop(){
        //判断能否消费
        if(count == 0){
            try {
                //等待生产者生产
                System.out.println("消费完了");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果可以消费
        count--;
        Chicken chicken = chickens[count];

        //消费完，通知生产者生产
        this.notifyAll();
        return chicken;
    }
}