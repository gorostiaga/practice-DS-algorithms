package com._concurrency;

import java.util.concurrent.CountDownLatch;

class Thread2 implements Runnable {

    CountDownLatch cdl;
    Thread t;

    public Thread2(CountDownLatch cdl) {
        this.cdl = cdl;
        t = new Thread(this);
    }

    @Override
    public void run() {
        for(int i=5; i>0;i--){
            System.out.println("counter: "+i);
            cdl.countDown();
        }
    }
}

public class ContDownLatchTester {

    public static void main(String[] args) {
        CountDownLatch cdl  = new CountDownLatch(5);
        Thread2 thread2 = new Thread2(cdl);
        thread2.t.start();
        System.out.println("Main thread waiting for the latch releasing");
        try {
            cdl.await();
        } catch (InterruptedException e){
            System.out.println("WTF interrupted!");
        }
        System.out.println("Exiting from main");
    }

}
