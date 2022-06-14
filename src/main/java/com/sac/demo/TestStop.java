package com.sac.demo;

/**
 * @Author : SAC
 * @create 2022/6/13 20:59
 */
public class TestStop implements Runnable {
    private boolean flag = true;//外部停止位

    @Override
    public void run() {
        int i = 0;
        while (true) {//线程体使用该标识
            System.out.println("run... Thread" + i++);
        }
    }

    public void stop() {//对外提供方法修改标识
        this.flag = false;
    }

    public static void main(String[] args) {
        TestStop testStop = new TestStop();
        new Thread(testStop).start();
        for (int i = 0; i < 100; i++) {
            System.out.println("main " + i);
            if (i == 90) {
                testStop.stop();
                System.out.println("线程停止了");
            }
        }
    }
}
