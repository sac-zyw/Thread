package com.sac.sync;

/**
 * @Author : SAC
 * @create 2022/6/13 23:09
 */
public class UnSafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket station = new BuyTicket();

        new Thread(station, "老百姓").start();
        new Thread(station, "当官的").start();
        new Thread(station, "黄牛党").start();
    }
}

class BuyTicket implements Runnable {
    private int ticketNums = 100;
    boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            try {
                buy();
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //synchronized 同步方法，锁的是this
    private synchronized void buy() {
        if (ticketNums <= 0) {
            flag = false;
            return;
        }
        System.out.println(Thread.currentThread().getName() + "买到了第" + ticketNums-- + "张票");
    }
}
