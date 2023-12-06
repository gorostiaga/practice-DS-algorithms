package com._concurrency;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;

class MakeString implements Runnable {
    String s;
    Exchanger<String> ex = new Exchanger<>();

    public MakeString(Exchanger<String> ex) {
        this.ex = ex;
        s = new String();
    }

    @Override
    public void run() {
        char ch = 'A';
        for(int i=0; i<3;i++){
            for(int j=0;j<5;j++)
                s += ch++;

            try{
               String result = ex.exchange(s);
                System.out.println("From makestring: "+result);
            } catch (InterruptedException e){
                System.out.println(e);
            }
        }
    }
}

class UseString implements Runnable {
    Exchanger<String> ex = new Exchanger<>();
    String stg;

    public UseString(Exchanger<String> ex) {
        this.ex = ex;
    }

    @Override
    public void run() {
        for(int i=0; i<3;i++){
            try {
              stg = ex.exchange("Mierda");
                System.out.println("from usestring: "+stg);
            } catch (InterruptedException e){
                System.out.println(e);
            }
        }
    }
}

public class ExchangerTester {
    public static void main(String[] args) {
        Exchanger<String> ex = new Exchanger<>();
        new Thread(new MakeString(ex)).start();
        new Thread(new UseString(ex)).start();

    }

}
