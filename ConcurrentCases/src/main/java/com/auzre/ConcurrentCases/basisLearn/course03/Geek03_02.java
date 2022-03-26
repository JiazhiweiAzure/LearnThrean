package com.auzre.ConcurrentCases.basisLearn.course03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Geek03_02 {

    public static final String TEXT = "营销2.0项目设计，是通过领域驱动设计DDD思想进行建模开发的，拥有很好的扩展性\n" + "....";

    public static void main(String[] args) throws InterruptedException {
        System.out.println("程序开始，执行线程的名字叫做" + Thread.currentThread().getName());
        List<Thread> threads = new ArrayList<>();
        for (int i = 1; i <= 1; i++) {
//            Thread thread = new Thread(new Geek02_01.PrintStoryRunnable(TEXT, 200 * i), "我的线程-" + i);
            Thread thread = new Thread(new NotHandleInterrupt(TimeUnit.SECONDS.toMillis(8)),"我的线程-"+ i);
            threads.add(thread);
            thread.start();
        }
        Thread.sleep(TimeUnit.SECONDS.toMillis(5));
        System.out.println();
        System.out.println("开始 interrupt 线程");
        threads.forEach(Thread::interrupt);
        System.out.println("interrupt 线程结束，继续sleep 五秒钟");
        Thread.sleep(TimeUnit.SECONDS.toMillis(5));
        System.out.println("启动线程结束，名字叫做" + Thread.currentThread().getName());
    }

    static class PrintStoryRunnable implements Runnable {
        private String text;
        private long interval;

        public PrintStoryRunnable(String text, long interval) {
            this.text = text;
            this.interval = interval;
        }

        @Override
        public void run() {
            try {
                double num = Math.random();
                System.out.println("程序开始，执行线程的名字叫做" + Thread.currentThread().getName());
                printSlowly(text, interval);
                System.out.println(Thread.currentThread().getName() + "执行结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class NotHandleInterrupt implements Runnable {

        private long duration;

        public NotHandleInterrupt(long duration) {
            this.duration = duration;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "执行开始");
            long start = System.currentTimeMillis();
            long counter = 0;
            boolean isInterrupted = Thread.currentThread().isInterrupted();
            System.out.println(Thread.currentThread().getName() + "的isInterrupted=" + isInterrupted);
            while (true) {
                counter++;
                if (isInterrupted != Thread.currentThread().isInterrupted()) {
                    isInterrupted = Thread.currentThread().isInterrupted();
                    System.out.println("发现线程" + Thread.currentThread().getName() + "的isInterrupted变化为：" + isInterrupted);
                }
                if (System.currentTimeMillis() - start > duration) {
                    break;
                }
            }
            System.out.println(Thread.currentThread().getName() + "执行结束");


        }
    }


    public static void printSlowly(String text, long interval) throws InterruptedException {
        for (char ch : text.toCharArray()) {
            Thread.sleep(interval);
            System.out.print(ch);
        }
        System.out.println();
    }
}
