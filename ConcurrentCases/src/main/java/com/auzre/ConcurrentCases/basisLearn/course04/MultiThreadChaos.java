package com.auzre.ConcurrentCases.basisLearn.course04;

public class MultiThreadChaos {

    public static void main(String[] args) {
        DataHolder dataHolder = new DataHolder();
        Thread increaseThread = new Thread(new ChangeData(-2,Integer.MAX_VALUE,dataHolder));
        Thread decreaseThread = new Thread(new ChangeData(2,Integer.MAX_VALUE,dataHolder));
        System.out.println("执行开始");
        increaseThread.start();
        decreaseThread.start();
    }
}
