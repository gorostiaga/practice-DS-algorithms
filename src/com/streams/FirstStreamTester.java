package com.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class FirstStreamTester {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>();
        myList.add((int) (Math.random()*100));
        myList.add((int) (Math.random()*100));
        myList.add((int) (Math.random()*100));
        myList.add((int) (Math.random()*100));
        myList.add((int) (Math.random()*100));
        myList.add((int) (Math.random()*100));
        myList.add((int) (Math.random()*100));
        myList.add((int) (Math.random()*100));
        myList.add((int) (Math.random()*100));
        myList.add((int) (Math.random()*100));
        myList.add((int) (Math.random()*100));


        System.out.println("original list: " + myList);

        Stream<Integer> myStream = myList.stream();
        int min = myStream.min(Integer::compare).orElse(null);
        System.out.println("the min is: "+min);

        Stream<Integer> sortedStream = myList.stream().sorted();
        System.out.println("the sorted list");
        sortedStream.forEach(n -> System.out.print(n+" "));
        System.out.println();

        Stream<Integer> oddStream = myList.stream().sorted().filter(n -> (n%2)!=0);
        System.out.println("only odds");
        oddStream.forEach(n-> System.out.print(n+" "));

    }
}
