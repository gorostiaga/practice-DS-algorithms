package com.streams;

import java.util.ArrayList;
import java.util.List;

public class StreamSpliteratorTester {

    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        myList.add("Perra");
        myList.add("Anal");
        myList.add("Ki cos");
        myList.add("Tara");
        myList.add("Analero 4ever");
        myList.add("Malditos");
        myList.add("HAHAHAHAHA");
        myList.add("Joker");
        myList.add("Dishendo");
        myList.add("Pepe");
        myList.add("Mamani");

        myList.spliterator().forEachRemaining(n -> System.out.println(n));

        Integer a  = new Integer(2);
        Integer b  = new Integer(2);

        if(a==b) System.out.println("true");
        else System.out.println("false");

    }
}
