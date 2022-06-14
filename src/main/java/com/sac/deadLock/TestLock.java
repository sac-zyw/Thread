package com.sac.deadLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author : SAC
 * @create 2022/6/14 21:19
 */
public class TestLock {
    public static void main(String[] args) {
        TestLock2 testLock2 = new TestLock2();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
    }

}

class TestLock2 implements Runnable {
    int ticketNums = 10;
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();//加锁
                if (ticketNums > 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(ticketNums--);
                } else {
                    break;
                }
            } finally {
                lock.unlock();//解锁
            }
        }
    }
}