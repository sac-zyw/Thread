package com.sac.demo;

/**
 * @Author : SAC
 * @create 2022/6/13 21:17
 */
public class TestJoin implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("线程vip..." + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();

        for (int i = 0; i < 100; i++) {
            if (i == 50) {
                thread.join();
            }
            System.out.println("主线程..." + i);
        }
    }
}
