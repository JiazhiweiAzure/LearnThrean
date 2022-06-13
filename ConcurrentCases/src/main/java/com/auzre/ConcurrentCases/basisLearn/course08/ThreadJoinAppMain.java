package com.auzre.ConcurrentCases.basisLearn.course08;

import java.util.ArrayList;
import java.util.List;

public class ThreadJoinAppMain {
    // 内容链表的容器
    private static final List<String> CONTENTS = new ArrayList<>();
    // 工作时长
    private static long WORKING_DURATION = 0;

    public static void main(String[] args) throws InterruptedException {
        // 主线程的开始时间
        long mainStart = System.currentTimeMillis();
        // 线程容器
        List<Thread> threads = new ArrayList<>();
        // 创建10个线程
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + ":开始抓取网页内容");
                long start = System.currentTimeMillis();
                String content = getContentFromWeb();
                long threadWorkingDuration = System.currentTimeMillis() - start;
                System.out.println(Thread.currentThread().getName() + ":抓取网页内容结束");
                synchronized (CONTENTS) {
                    CONTENTS.add(content);
                    WORKING_DURATION += threadWorkingDuration;
                }
            }, "线程" + i);
            thread.start();
            threads.add(thread);
        }
        Thread.sleep(1);
        System.out.println("-------------- 主线程开始join -------------");
        for (Thread thread: threads) {
            try {
                String name = thread.getName();
                System.out.println(" ------------ 主线程开始join " + name + " ------------ ");
                thread.join();
                System.out.println(" ------------ 主线程join " + name + " 结束 ------------ ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(" ------------ 主线程join结束，获取的内容为： ------------ ");
        CONTENTS.forEach(s->{
            System.out.println(s.length());
            System.out.println(s);
        });
        long mainWorkDuration = System.currentTimeMillis() - mainStart;
        System.out.println("工作线程累计工作时间：" + WORKING_DURATION);
        System.out.println("主线程工作时间：" + mainWorkDuration);
    }

    private static String getContentFromWeb() {
        StringBuffer ret = new StringBuffer();
        // 随机生成四位整数
        int len = ((int) (Math.random() * 1000000) % 4096 + 1024);
        for (int i = 0; i < len; i++) {
            // 随机生成26之前整数
            int rand = ((int) (Math.random() * 1000)) % 26;
            char ch = (char) (rand + 'a');
            ret.append(ch);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return ret.toString();
    }
}
