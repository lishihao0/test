package com.kuang.TestPC;

public class TestPC2 {
    public static void main(String[] args) {
        TV tv = new TV();
        new Player(tv).start();
        new Watcher(tv).start();
    }



}

class Player extends Thread{

    TV tv = new TV();
    public Player(TV tv){
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i%2 == 0){
                tv.play("大决战");
            }else {
                tv.play("抖音");
            }
        }
    }
}



class Watcher extends Thread{
    TV tv = new TV();
    public Watcher(TV tv){
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            tv.watch();
        }
    }
}

class TV{
    //演员表演，观众等待  T
    //观众观看，演员等待  F

    String voice;
    boolean flag = true;

    public synchronized void play(String voice){
        if (!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("表演了："+voice);
        //通知观众看
        this.notifyAll();
        this.voice=voice;
        this.flag = !this.flag;
    }

    public synchronized void watch(){
        if (flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("观众看表演"+voice);

        this.notifyAll();
        this.flag = !this.flag;
    }

}