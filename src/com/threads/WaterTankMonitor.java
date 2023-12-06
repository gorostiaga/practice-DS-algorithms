package com.threads;

public class WaterTankMonitor {

    WaterTank tank;

    public WaterTankMonitor(WaterTank tank) {
        this.tank = tank;
    }

    synchronized void empty() throws InterruptedException{
        while (tank.isEmpty()){
            wait();
        }
        System.out.println("emptying the fucking tank");
        tank.setEmpty(true);
        notify();
    }

   synchronized void fill() throws InterruptedException{
        while(!tank.isEmpty()){
            wait();
        }
       System.out.println("Filling this piece of shit tank");
        tank.setEmpty(false);
        notify();
    }
}
