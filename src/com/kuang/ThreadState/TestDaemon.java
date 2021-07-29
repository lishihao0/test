package com.kuang.ThreadState;

public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        Thread thread = new Thread(god);
        thread.setDaemon(true); //false表示为用户线程，默认为用户线程
        thread.start();

        new Thread(new You()).start();
    }
}

class God implements Runnable{

    @Override
    public void run() {
        while(true){
            System.out.println("上帝与你同在");
        }
    }
}


class You implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("开心生活每一天");
        }
        System.out.println("=====goodbye======");
    }
}
