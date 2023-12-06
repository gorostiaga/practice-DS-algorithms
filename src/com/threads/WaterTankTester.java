package com.threads;

import java.awt.*;
import java.util.Random;

class ProducerTank implements Runnable {
    Random random = new Random();
    Thread t;
    WaterTankMonitor monitor;

    public ProducerTank(WaterTankMonitor monitor) {
        this.monitor = monitor;
        t = new Thread(this, "Producer");
    }

    @Override
    public void run() {
        while (true){
            try{
                int time = random.nextInt(2000)+1;
                Thread.sleep(time);
                monitor.fill();
            }
            catch (InterruptedException e){
                System.out.println("Thread interrupted");
            }
        }
    }
}

class ConsumerTank implements Runnable{
    Random random = new Random();
    Thread t;
    WaterTankMonitor monitor;

    public ConsumerTank(WaterTankMonitor monitor) {
        this.monitor = monitor;
        t = new Thread(this, "Consumer");
    }

    @Override
    public void run() {
        while (true){
            try{
                int time = random.nextInt(2000)+1;
                Thread.sleep(time);
                monitor.empty();

            } catch (InterruptedException e){
                System.out.println("The thread interrupted");
            }
        }

    }
}



public class WaterTankTester {

    public static void main(String[] args) {

        WaterTank tank = new WaterTank(true);
        WaterTankMonitor monitor = new WaterTankMonitor(tank);
        ProducerTank producerTank = new ProducerTank(monitor);
        ConsumerTank consumerTank = new ConsumerTank(monitor);
        producerTank.t.start();
        consumerTank.t.start();
        System.out.println("Press control c to finish");
        try{
            consumerTank.t.join();
            producerTank.t.join();
        } catch (InterruptedException e){
            System.out.println("WTF!");
        }

    }
}
