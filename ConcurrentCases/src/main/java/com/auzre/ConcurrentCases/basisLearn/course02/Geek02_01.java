package com.auzre.ConcurrentCases.basisLearn.course02;

public class Geek02_01 {

    public static final String TEXT = "营销2.0项目设计，是通过领域驱动设计DDD思想进行建模开发的，拥有很好的扩展性\n" + "....";

    public static void main(String[] args) {
        System.out.println("程序开始，执行线程的名字叫做" + Thread.currentThread().getName());

        for (int i = 1; i <= 2; i++) {
            Thread thread = new Thread(new PrintStoryRunnable(TEXT, 200 * i), "我的线程-" + i);
            thread.start();
        }
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

    public static void printSlowly(String text, long interval) throws InterruptedException {
        for (char ch : text.toCharArray()) {
            Thread.sleep(interval);
            System.out.print(ch);
        }
        System.out.println();
    }

}
