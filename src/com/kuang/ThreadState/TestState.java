package com.kuang.ThreadState;

public class TestState {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("线程结束");
        });


        //观测线程状态：
        Thread.State state = thread.getState(); //获取初始状态：New
        System.out.println(state);

        thread.start();
        state = thread.getState();  //更新线程状态：Run
        System.out.println(state);

        while (state != Thread.State.TERMINATED){//只要线程不终止就不断更新状态
            Thread.sleep(100);
            state = thread.getState();
            System.out.println(state); //输出状态
        }
    }
}
