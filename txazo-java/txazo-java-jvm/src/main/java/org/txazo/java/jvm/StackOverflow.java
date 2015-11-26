package org.txazo.java.jvm;

public class StackOverflow {

    private int i;

    private void plus() {
        i++;
        plus();
    }

    public static void main(String[] args) {
        StackOverflow stackOverflow = new StackOverflow();
        try {
            stackOverflow.plus();
        } catch (StackOverflowError e) {
            System.err.println("Stack deepth " + stackOverflow.i);
        }
    }

}
