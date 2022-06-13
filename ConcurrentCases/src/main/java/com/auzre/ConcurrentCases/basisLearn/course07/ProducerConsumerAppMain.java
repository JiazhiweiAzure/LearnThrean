package com.auzre.ConcurrentCases.basisLearn.course07;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class ProducerConsumerAppMain {
    public static final Object LOCKER = new Object();

    public static void main(String[] args) {
        // 创建模拟存放生成urls地址
        Queue<String> urls = new LinkedList<>();
        // 生产者模拟生产urls 最大生产1024个
        Producer<String> producer = new Producer<>(urls, 1024);
        // 消费者消费urls 都是操作urls队列的url
        Consumer<String> consumer = new Consumer<>(urls);
        // 创建3个消费线程，
        for (int i = 0; i < 3; i++) {
            Thread producethread = new Thread(() -> {
                while (true) {
                    try {
                        String url = produceURL();
                        producer.produce(url);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }, "生产者-" + i);
            producethread.start();
        }
        for (int i = 0; i < 100; i++) {
            Thread consumerThread = new Thread(() -> {
                while (true) {
                    try {
                        String url = consumer.consume();
                        processURL(url);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "消费者-" + i);
            consumerThread.start();
        }


    }

    private static String produceURL() {
        StringBuffer ret = new StringBuffer();
        ret.append("www.");
        for (int i = 0; i < 6; i++) {
            int rand = (int) ((Math.random() * 1000) % 26);
            char ch = (char) (rand + 'a');
            ret.append(ch);
        }
        ret.append(".com");
        return ret.toString();
    }

    private static void processURL(String url) throws InterruptedException {
        System.out.println("开始处理：" + url);
        Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        System.out.println("处理完成：" + url);


    }
}
