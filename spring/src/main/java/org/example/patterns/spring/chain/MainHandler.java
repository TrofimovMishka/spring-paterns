package org.example.patterns.spring.chain;

public class MainHandler {

    // Open close principle broken!!!
    public void handle(DataObject t){
        handle1(t);
        handle2(t);
        handle3(t);
    }
    // add new feature,  change this class

    private void handle3(DataObject t) {
    }

    private void handle2(DataObject t) {
    }

    private void handle1(DataObject t) {
    }
}
// Solution in MainHandler2:

