package com.threads;

class Q2{
    int n;
    boolean valueSet = false;
    synchronized int get(){
        while(!valueSet)
            try{
                wait();
            } catch (InterruptedException e ){
                System.out.println("InterruptedException caught");
            }
        valueSet = false;
        System.out.println("Got: " + n+" valueSet = "+valueSet);
        notify();
        return n;
    }

    synchronized void put(int n){
        while(valueSet)
            try {
                wait();
            } catch (InterruptedException e){
                System.out.println("InterruptedException caught");
            }
        this.n=n;
        valueSet = true;
        System.out.println("Put: " + n +" valueSet = "+valueSet);
        notify();
    }
}

class Producer2 implements Runnable {
    Q2 q;
    Thread t;
    Producer2(Q2 q) {
        this.q = q;
        t = new Thread(this, "Producer");
    }

    @Override
    public void run() {
        int i=0;
        for(int j=0; j<100;j++){
            q.put(i++);
        }
    }
}

class Consumer2 implements Runnable{
    Q2 q;
    Thread t;
    public Consumer2(Q2 q){
        this.q=q;
        t = new Thread(this);
    }

    @Override
    public void run() {
        for(int j=0; j<100;j++){
            q.get();
        }
    }
}

public class PCFixed {
    public static void main(String[] args) {
        Q2 q = new Q2();
        Producer2 p = new Producer2(q);
        Consumer2 c = new Consumer2(q);

        p.t.start();
        c.t.start();

        try {
            p.t.join();
            c.t.join();
        } catch (InterruptedException e) {
            System.out.println("shit");
        }

        System.out.println("Main terminated.");
    }
}
