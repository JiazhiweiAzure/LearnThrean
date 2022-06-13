package com.auzre.ConcurrentCases.basisLearn.course06;

import java.util.concurrent.TimeUnit;

public class ThreadWaitNotify {
    public static void main(String[] args) {
        // 创建一个锁实例
        Object locker = new Object();
        // 工作时间
        int workingSec = 2;
        // 线程数目
        int threadCount = 5;
        // 循环创建线程
        for (int i = 0; i < threadCount; i++) {
            // 创建一个新线程
            new Thread(() -> {
                //
                System.out.println(getName() + ":线程开始工作......");
                try {
                    synchronized (locker) {
                        sleepSec(workingSec);
                        locker.wait();
                        System.out.println(getName() + ":线程继续......");
                        sleepSec(2);
                        System.out.println(getName() + ":线程结束......");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "工作线程" + i).start();
        }
        System.out.println("---------------唤醒线程开始Sleep---------------");
        sleepSec(workingSec - 1);
        System.out.println("---------------唤醒线程sleep结束---------------");
        synchronized (locker) {
            for (int i = 0; i < threadCount; i++) {
                System.out.println("-------------开始逐个唤醒--------------");
                locker.notify();
            }
        }

    }


    private static void sleepSec(int sec) {
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(sec));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static String getName() {
        return Thread.currentThread().getName();
    }
}
