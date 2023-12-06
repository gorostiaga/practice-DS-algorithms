package com.streams;


import java.util.Arrays;

public class ArrayStreamTester {

    public static int getMaxOc(int[] a, int k){
        return (int) Arrays.stream(a).filter(n-> n == k).count();
    }

    public static void main(String[] args) {
        int[] a = {1,5,8,9,4,7,2,5,4,1,2,5,4,1,5,54,1,1,1,5,5,3};
        int k = 1;
        System.out.println(getMaxOc(a,k));
    }
}
