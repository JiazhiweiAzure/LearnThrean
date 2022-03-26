package com.auzre.ConcurrentCases.basisLearn.course01;

public class Geek01_01 {

    public static void main(String[] args) throws InterruptedException {
        printSlowly("当你努力快要撑不住的时候，困难也快要撑不住了。",300);
    }

    public static void printSlowly(String text, long interval) throws InterruptedException {
        for (char ch : text.toCharArray()){
            Thread.sleep(interval);
            System.out.print(ch);
        }
        System.out.println();
    }
}
