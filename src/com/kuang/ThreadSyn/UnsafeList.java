package com.kuang.ThreadSyn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class UnsafeList {
    public static void main(String[] args) throws InterruptedException {
//        List<String> list = new ArrayList<String>();
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
//                synchronized (list){
//                    list.add(Thread.currentThread().getName());
//                }
                list.add(Thread.currentThread().getName());

            }).start();
        }
        Thread.sleep(100);
        System.out.println(list.size());
    }
}
