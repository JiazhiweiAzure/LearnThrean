package com.auzre.ConcurrentCases.basisLearn.course08;

public class RandomNum {

    public static void main(String[] args) {
        System.out.println((Math.random() * 1000000) );
        System.out.println((Math.random() * 1000000) % 4096);
        System.out.println((Math.random() * 1000000) % 4096);
        System.out.println((Math.random() * 1000000) % 4096);
        System.out.println((Math.random() * 1000000) % 4096);
        System.out.println("---------------------------------------");
        System.out.println((Math.random() * 1000) % 26);
        System.out.println((Math.random() * 1000) % 26);
        System.out.println((Math.random() * 1000) % 26);
        System.out.println((Math.random() * 1000) % 26);
        System.out.println((Math.random() * 1000) % 26);

    }
}
