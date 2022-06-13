package com.auzre.ConcurrentCases.basisLearn.course10;

public class InputHandler {
    public String getInput() {
        return produceString();
    }

    private String produceString() {
        PerformanceTracker.startPhase();
        StringBuffer ret = new StringBuffer();
        for (int i = 0; i < 128; i++) {
            int rand = ((int) (Math.random() * 1000)) % 26;
            char ch = (char) (rand + 'a');
            ret.append(ch);
        }
        PerformanceTracker.endPhase("InputGen");
        return ret.toString();
    }
}
