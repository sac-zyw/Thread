package com.sac.demo;

/**
 * @Author : SAC
 * @create 2022/6/13 22:49
 */
public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();
        Thread thread = new Thread(god);
        thread.setDaemon(true);
        thread.start();
        new Thread(you).start();
    }
}

class You implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("开心的活着");
        }
        System.out.println("goodbye world");
    }
}

class God implements Runnable {
    @Override
    public void run() {
        while (true) System.out.println("上帝保佑着你");
    }
}

