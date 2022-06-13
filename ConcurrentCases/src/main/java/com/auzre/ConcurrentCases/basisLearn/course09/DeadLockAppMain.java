package com.auzre.ConcurrentCases.basisLearn.course09;

public class DeadLockAppMain {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("程序开始");
        AppResources appResources = new AppResources();
        Thread t1 = new Thread(new Task1(appResources));
        t1.start();
        Thread t2 = new Thread(new Task2(appResources));
        t2.start();
        t1.join();
        t2.join();
        System.out.println("程序结束");
    }
}
