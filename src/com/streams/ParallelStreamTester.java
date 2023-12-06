package com.streams;

import java.util.ArrayList;
import java.util.List;

public class ParallelStreamTester {
    public static void main(String[] args) {

        List<Double> myList = new ArrayList<>();
        myList.add(Math.random()*100);
        myList.add(Math.random()*100);
        myList.add(Math.random()*100);
        myList.add(Math.random()*100);

        System.out.println("Initial list: "+myList);

        double result = myList.parallelStream().reduce(1.0, (a,b)-> a*Math.sqrt(b), (a,b)-> a*b);
        System.out.println("The product is: "+result);

        double result2 = myList.parallelStream().reduce(1.0, (a,b)-> a*Math.sqrt(b));
        System.out.println("The maming result is: "+result2);

    }
}
