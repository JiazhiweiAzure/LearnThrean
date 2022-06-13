package com.auzre.ConcurrentCases.basisLearn.course10;

public class UseThreadLocalAppMain {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Thread workingThread = new Thread(()->{
                System.out.println("开始处理......");
                 PerformanceTracker.reset();
                 InputHandler inputHandler = new InputHandler();
                 String content = inputHandler.getInput();
                 DBQuery query = new DBQuery();
                 query.query();
            });
        }
    }

}
