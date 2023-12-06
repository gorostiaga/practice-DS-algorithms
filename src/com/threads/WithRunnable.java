package com.threads;



class MyThread2 implements Runnable{
    @Override
    public void run() {
        try {
            for (int i = 0; i < 6; i++) {
                System.out.println("counter MyThread2 :" + i);
                Thread.sleep(500);
            }
        }
        catch (InterruptedException e){
            System.out.println("Child interrupted SHIT!");
        }
        System.out.println("Exiting of child MyThread2!");

    }
}

public class WithRunnable {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        mt.t.start();

        MyThread2 mt2 = new MyThread2();
        Thread thread2 = new Thread(mt2, "Druxxx");
        thread2.start();

        try {
            for (int i=0; i<6;i++){
                System.out.println("counter in main: "+i);
                Thread.sleep(1);
            }
        }
        catch (InterruptedException e){
            System.out.println("Maint thread interrupted! Bitch!");
        }
        System.out.println("Maint thread exiting");
    }
}
