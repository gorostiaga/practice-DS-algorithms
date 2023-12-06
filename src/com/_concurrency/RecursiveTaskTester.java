package com._concurrency;

import java.util.concurrent.RecursiveTask;

class Sum extends RecursiveTask<Double> {
     double[] array;
     int start, end;
     final int seqComputing = 500;


    public Sum(double[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Double compute() {
        double sum = 0;
        if(end-start < seqComputing){
            for (int i=start;i<end;i++){
                sum += array[i];
            }
        } else {
            int mid = (start+end)/2;

            // divide the task
            Sum subTask1 = new Sum(array, start, mid);
            Sum subTask2 = new Sum(array, mid, end);

            // start the substasks, the tasks are not suspended
            subTask1.fork();
            subTask2.fork();

            // we wait for the subtasks to finish
            sum = subTask1.join() + subTask2.join();
        }
        return sum;
    }
}

public class RecursiveTaskTester {

    public static void main(String[] args) {
        double[] nums = new double[5000];
        for(int i=0; i < nums.length; i++)
            nums[i] = (double) (((i%2) == 0) ? i : -i) ;

        Sum sum = new Sum(nums, 0, nums.length);

        double result = sum.invoke();

        System.out.println("result = " + result);
    }
}
