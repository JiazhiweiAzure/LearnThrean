package com.auzre.ConcurrentCases.basisLearn.course09;

import java.util.concurrent.TimeUnit;

public class Task1 implements Runnable {

    private AppResources appResources;

    public Task1(AppResources appResources) {
        this.appResources = appResources;
    }

    @Override
    public void run() {
        synchronized (appResources.getResourceInput()) {
            System.out.println("Task1得到了Input资源");
            System.out.println("Task1开始工作......");
            try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(2));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("尝试获去获取Printer资源");
            synchronized (appResources.getResourcePrinter()) {
                System.out.println("Task1得到了Printer资源");
                System.out.println("Task1继续工作......");
                try {
                    Thread.sleep(TimeUnit.SECONDS.toMillis(2));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
