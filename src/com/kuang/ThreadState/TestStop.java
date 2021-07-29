package com.kuang.ThreadState;

public class TestStop implements Runnable{

    private boolean flag = true;
    @Override
    public void run() {
        while (flag){
            System.out.println("Thread run....");
        }
    }
    //设置线程停止的方法
    public void stop(){
        this.flag = false;
    }


    public static void main(String[] args) {
        //先开启线程
        TestStop testStop = new TestStop();
        new Thread(testStop).start();


        for (int i = 0; i < 1000; i++) {
            System.out.println("Thread main...."+i);
            if (i == 900) {
                testStop.stop();
                System.out.println("Thread run 该停止了");
            }
        }
    }
}
