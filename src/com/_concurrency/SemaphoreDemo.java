package com._concurrency;

import java.util.concurrent.Semaphore;

class Shared {
    static int counter =0;
}

class IncThread implements Runnable{

    Semaphore sem;
    String name;

    public IncThread(Semaphore sem, String name) {
        this.sem = sem;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            sem.acquire();
            for(int i=0; i<6;i++){
                Shared.counter++;
                System.out.println(name+" : " +Shared.counter);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("WTF interrupted");
        }
        sem.release();
    }
}

class DecThread implements Runnable {

    Semaphore sem;
    String name;

    public DecThread(Semaphore sem, String name) {
        this.sem = sem;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            sem.acquire();
            for(int i=0; i<6;i++){
                Shared.counter--;
                System.out.println(name+" : " +Shared.counter);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("WTF interrupted");
        }
        sem.release();
    }
}

public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);
        Thread t1 = new Thread(new IncThread(sem, "Increaser"));
        Thread t2 = new Thread(new DecThread(sem, "Decreaser"));
        t1.start();
        t2.start();
    }
}
