package com._concurrency;

import java.util.concurrent.Semaphore;

class Q {
    int i;
    boolean isSetting = true;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}

class Consumer implements Runnable{

    public Thread t;
    Q q;
    String name;
    Semaphore sem;

    public Consumer(Q q, String name, Semaphore sem) {
        this.q = q;
        this.name = name;
        this.sem = sem;
        t = new Thread(this);
    }

    @Override
    public void run() {
        try{
            for(int i=0; i<20; i++){
              //  while (!q.isSetting){
                    sem.acquire();
                    System.out.println(name+ " get "+ q.getI());
                    Thread.sleep(1000);
                 //   q.isSetting = true;
                    sem.release();
                //}
            }
        } catch (InterruptedException e){
            System.out.println("WTF Interrupted");
        }

    }
}
class Producer implements Runnable{
    public Thread t;
    Q q;
    String name;
    Semaphore sem;

    public Producer(Q q, String name, Semaphore sem) {
        this.q = q;
        this.name = name;
        this.sem = sem;
        t = new Thread(this);
    }

    @Override
    public void run() {
        try{
            for (int i=0; i<20; i++){
               // while (q.isSetting){
                    sem.acquire();
                    q.setI(i);
                    System.out.println(name +" set "+i);
                    Thread.sleep(1000);
                   // q.isSetting = false;
                    sem.release();
               // }
            }

        }catch (InterruptedException e){
            System.out.println("WTF Interrupted");
        }

    }
}

public class PCSemaphore {

    public static void main(String[] args) {
        Q q = new Q();
        Semaphore sem = new Semaphore(1);
        Producer prod = new Producer(q, "producer", sem);
        Consumer consu = new Consumer(q,"consumer", sem);
        prod.t.start();
        consu.t.start();
    }

}
