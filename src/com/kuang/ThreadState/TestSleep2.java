package com.kuang.ThreadState;


import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSleep2 {


    public static void main(String[] args) throws InterruptedException {
        //打印系统时间
        Date startDate = new Date(System.currentTimeMillis());//获取当前系统时间
        while (true){
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(startDate));
            Thread.sleep(1000);
            startDate = new Date(System.currentTimeMillis());//更新当前时间
        }

    }

    //模拟倒计时
    public static void tenDown() throws InterruptedException {
        int num = 10;
        while (true){
            System.out.println(num--);
            Thread.sleep(1000);
            if (num <= 0){
                break;
            }
        }

    }
}
