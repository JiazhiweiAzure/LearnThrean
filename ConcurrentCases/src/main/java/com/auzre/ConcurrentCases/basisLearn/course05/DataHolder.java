package com.auzre.ConcurrentCases.basisLearn.course05;

public class DataHolder {
    private long number = 0;

    // TODO 一个synchronized解决问题
    public synchronized void change(long delta) {
        number += delta;
    }

    public void print() {
        System.out.println("Number=" + number);
    }
}
