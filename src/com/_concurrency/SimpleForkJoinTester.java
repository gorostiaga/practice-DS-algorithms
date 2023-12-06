package com._concurrency;

import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

class ArraySqr extends RecursiveAction {

    // Selected with no criterion
    final int seqThreashold = 1000;
    double[] array;
    int start;
    int end;

    public ArraySqr(double[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if(end-start < seqThreashold){
            for(int i = start; i<end; i++)
                array[i] = Math.sqrt(array[i]);
        } else {
            // here is the divide and conquer strategy
            int mid = (start+end)/2;
            invokeAll(new ArraySqr(array, start, mid), new ArraySqr(array, mid, end));
        }
    }
}

public class SimpleForkJoinTester {
    public static void main(String[] args) {
        double[] array = new double[1000000];

        for (int i=0; i<array.length;i++){
            array[i] = (double) i;
            if (i<100)
                System.out.println("first "+ array[i]);
        }

        ArraySqr task = new ArraySqr(array,0, array.length);

        // no need to call a common pool o create ur own ForkJoinPool
        // also ForkJoinPool fjp = ForkJoinPool.commonPool(); fjp.invoke(task); is valid and sometimes more used
        task.invoke();
        for (int i=0; i<100;i++){
            System.out.println("mod "+ array[i]);
        }

        // to obtain the level of parallelism (the number of cores)
        ForkJoinPool fjp = new ForkJoinPool();
        System.out.println("level of parallelism: "+ fjp.getParallelism());

    }
}
