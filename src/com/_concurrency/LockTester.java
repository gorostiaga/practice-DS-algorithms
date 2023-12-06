package com._concurrency;

import java.util.concurrent.locks.ReentrantLock;

class SharedResource {
    static int count = 0;
}

class Thread3 implements Runnable {
    String name;
    ReentrantLock rl;

    public Thread3(String name, ReentrantLock rl) {
        this.name = name;
        this.rl = rl;
    }

    @Override
    public void run() {
        rl.lock();
        SharedResource.count++;
        System.out.println(name+": " + SharedResource.count);
        try {

            Thread.sleep(500);
        } catch (InterruptedException e){
            System.out.println(e);
        }
        rl.unlock();
    }
}

public class LockTester {

    public static void main(String[] args) {
        ReentrantLock rl = new ReentrantLock();
        new Thread(new Thread3("A", rl)).start();
        new Thread(new Thread3("B", rl)).start();
    }
}
