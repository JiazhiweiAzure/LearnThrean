package com.auzre.ConcurrentCases.basisLearn.course03;


public class Geek03_01 {

    public static final String TEXT = "营销2.0项目设计，是通过领域驱动设计DDD思想进行建模开发的，拥有很好的扩展性\n" + "....";

    public static void main(String[] args) {
        System.out.println("程序开始，执行线程的名字叫做" + Thread.currentThread().getName());

        for (int i = 1; i <= 2; i++) {
            Thread thread = new Thread(new PrintStoryRunnable(TEXT, 200 * i), "我的线程-" + i);
            // TODO 可以在start之前设置线程为守护线程
            thread.setDaemon(true);
            // TODO 可以随时改变线程（和是不是守护线程没有关系）的优先级，但是作用不能保证
            thread.setPriority(Thread.MAX_PRIORITY);
            thread.start();
        }
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

    public static void printSlowly(String text, long interval) throws InterruptedException {
        for (char ch : text.toCharArray()) {
            Thread.sleep(interval);
            System.out.print(ch);
        }
        System.out.println();
    }
}
