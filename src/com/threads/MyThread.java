package com.threads;

public class MyThread implements  Runnable{
    Thread t;
    String name;

    int time;
    public MyThread() {
        t = new Thread(this, "PepeLucho");
        System.out.println("Child thread: "+ t);
    }

    public  MyThread(String name){
        this.name = name;
        t = new Thread(this, name);
        System.out.println("New thread: "+ t);
    }

    public  MyThread(String name, int time){
        this.time = time;
        this.name = name;
        t = new Thread(this, name);
        System.out.println("New thread: "+ t);
    }
    @Override
    public void run() {
        try {
            for (int i = 0; i < 6; i++) {
                System.out.println(name+" : " + i);
                Thread.sleep(time == 0?500:time);
            }
        }
        catch (InterruptedException e){
            System.out.println(name + " interrupted SHIT!");
        }
        System.out.println(name + " exiting");
    }
}
