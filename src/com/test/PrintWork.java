package com.test;

public class PrintWork {

    private boolean flag = true;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void printWork() {
        while (this.flag) {
            System.out.println("printing work");
        }
    }
}
