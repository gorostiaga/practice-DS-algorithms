package com.threads;

public class Tester {

    public static void main(String[] args) throws Exception{
        Thread t = Thread.currentThread();

        for(int i=0; i<5;i++){
            System.out.println(i);
            Thread.sleep(1000);
        }
    }
}
