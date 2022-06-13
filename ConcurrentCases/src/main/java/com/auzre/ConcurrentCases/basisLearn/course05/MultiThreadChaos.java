package com.auzre.ConcurrentCases.basisLearn.course05;

public class MultiThreadChaos {

    public static void main(String[] args) {
        DataHolder dataHolder = new DataHolder();
        DataHolder dataHolder2 = new DataHolder();
        Thread increaseThread = new Thread(new ChangeData(-2,Integer.MAX_VALUE/50,dataHolder));
        Thread decreaseThread = new Thread(new ChangeData(2,Integer.MAX_VALUE/50,dataHolder2));
        System.out.println("执行开始");
        increaseThread.start();
        decreaseThread.start();
    }
}
