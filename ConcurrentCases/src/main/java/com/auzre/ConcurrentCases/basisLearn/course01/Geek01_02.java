package com.auzre.ConcurrentCases.basisLearn.course01;

public class Geek01_02 {

    public static void main(String[] args) {
        m1();
    }

    public static void m1(){
        int a = 777;
        m2();
    }

    public static void m2(){
        int a = 555;
        m3();
    }

    public static void m3(){
        int a = 999;
        m4();
    }

    public static void m4(){
        int a = 2222;
        m5();
    }

    public static void m5(){
        System.out.println("断点挺住");
    }



}
