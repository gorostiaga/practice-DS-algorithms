package com.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStreamTester {

    public static void main(String[] args) {
        int[] iArray = {1, 2, 3, 4, 5};
        IntStream iStream = Arrays.stream(iArray);
        //List<Integer> list = iStream.collect(Collectors.toList());
        //List<Integer> intList = IntStream.rangeClosed(1, 5)
               // .collect(Collectors.toList());
    }
}
