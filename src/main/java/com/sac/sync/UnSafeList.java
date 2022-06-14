package com.sac.sync;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : SAC
 * @create 2022/6/13 23:40
 */
public class UnSafeList {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                list.add(Thread.currentThread().getName());
            }).start();
        }
        Thread.sleep(1000);
        System.out.println(list.size());
    }
}
