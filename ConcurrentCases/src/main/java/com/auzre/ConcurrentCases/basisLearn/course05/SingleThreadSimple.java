package com.auzre.ConcurrentCases.basisLearn.course05;

public class SingleThreadSimple {

    public static void main(String[] args) {
        DataHolder dataHolder = new DataHolder();

        ChangeData increase = new ChangeData(2,Integer.MAX_VALUE,dataHolder);
        increase.run();
        ChangeData decrease = new ChangeData(-2,Integer.MAX_VALUE,dataHolder);
        decrease.run();

    }
}
