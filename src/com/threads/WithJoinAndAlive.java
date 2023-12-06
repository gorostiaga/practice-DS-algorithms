package com.threads;



public class WithJoinAndAlive {

    public static void main(String[] args) {

        MyThread mt1 = new MyThread("one");
        MyThread mt2 = new MyThread("two");
        MyThread mt3 = new MyThread("three");
        MyThread mt4 = new MyThread("four", 5000);

        mt1.t.start();
        mt2.t.start();
        mt3.t.start();
        mt4.t.start();


        try {

            mt1.t.join();
            mt2.t.join();
            mt3.t.join();
            mt4.t.join(10000);
            System.out.println("Waiting threads to finish..");
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        System.out.println("Main Thread exiting");
    }
}
