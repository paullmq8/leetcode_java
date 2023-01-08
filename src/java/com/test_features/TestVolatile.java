package com.test_features;

class Job extends Thread {

    public Job(PrintWork printWork) {
        printWork.printWork();
    }

    @Override
    public void run() {
    }
}

public class TestVolatile {

    public static void main(String[] args) {

    }
}
