package com.sac.deadLock;

/**
 * @Author : SAC
 * @create 2022/6/14 20:58
 */

public class Lock1 {
    public static void main(String[] args) {
        化妆 灰姑娘 = new 化妆(0, "灰姑娘");
        化妆 白雪公主 = new 化妆(1, "白雪公主");
        灰姑娘.start();
        白雪公主.start();
    }
}

//口红
class LipStick {

}

//镜子
class Mirror {

}

class 化妆 extends Thread {
    static LipStick lipStick = new LipStick();
    static Mirror mirror = new Mirror();

    int choice;
    String name;

    化妆(int choice, String name) {
        this.choice = choice;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            makeup();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void makeup() throws InterruptedException {
        if (choice == 0) {
            synchronized (lipStick) {
                System.out.println(this.name + "获得口红的锁");
                Thread.sleep(1000);
                synchronized (mirror) {
                    System.out.println(this.name + "获得镜子的锁");
                }
            }
        } else {
            synchronized (mirror) {
                System.out.println(this.name + "获得镜子的锁");
                Thread.sleep(2000);
                synchronized (lipStick) {
                    System.out.println(this.name + "获得口红的锁");
                }
            }
        }
    }
}