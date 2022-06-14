package com.sac.demo;

/**
 * @Author : SAC
 * @create 2022/6/13 21:11
 */
public class TestYield {
    public static void main(String[] args) {
        MyYield myYield = new MyYield();

        new Thread(myYield,"a").start();
        new Thread(myYield,"b").start();
    }
}

class MyYield implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程开始");
        Thread.yield();//礼让
        System.out.println(Thread.currentThread().getName() + "线程停止");
    }
}