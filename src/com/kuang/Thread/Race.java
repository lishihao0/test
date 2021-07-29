package com.kuang.Thread;

//模拟龟兔赛跑
public class Race implements Runnable {

    private static String winner;


    @Override
    public void run() {
        for (int i = 0; i <= 101; i++) {

            //模拟兔子睡觉
            if (Thread.currentThread().getName().equals("兔子") && i%10==0){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //判断比赛是否结束
            boolean flag = gameOver(i);
            if (flag){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"跑了"+i+"步");


        }
    }

    //判断是否完成比赛
    private boolean gameOver(int step){
        if (winner!=null){
            return true;
        }{
            if (step >= 100){
                winner = Thread.currentThread().getName();
                System.out.println("Winner is "+winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new Thread(new Race(),"兔子").start();
        new Thread(new Race(),"乌龟").start();
    }
}
