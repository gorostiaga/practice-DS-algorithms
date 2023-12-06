package com.threads;

class NewThread extends Thread {

/*    public NewThread() {
        super("PepeLucho");
    }*/

    @Override
    public void run() {
        try {
            for(int i=0; i<6; i++){
                System.out.println("Thread: "+i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("WTF!");
        }
    }
}

public class WithThread {

    public static void main(String[] args) {

        NewThread nt = new NewThread();
        nt.start();

    }
}
