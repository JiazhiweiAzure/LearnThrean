package com.auzre.ConcurrentCases.basisLearn.course04;

public class DataHolder {
    private long number = 0;

    public void change(long delta) {
        number += delta;
    }

    public void print() {
        System.out.println("Number=" + number);
    }
}
