package com.auzre.ConcurrentCases.basisLearn.course07;

import java.util.Queue;

public class Producer<T> {
    private Queue<T> tasks;
    private int maxTaskCount = 0;

    public Producer(Queue<T> tasks, int maxTaskCount) {
        this.tasks = tasks;
        this.maxTaskCount = maxTaskCount;
    }
    public void produce(T task) throws InterruptedException {
        synchronized (tasks){
            while (tasks.size() >= maxTaskCount){
                System.out.println("生产者线程进入等待："+Thread.currentThread().getName());
                tasks.wait();
            }
            tasks.add(task);
            tasks.notifyAll();
        }

    }
}

