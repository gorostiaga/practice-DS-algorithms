package com.streams;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestArrayStreamsC {

    public static void main(String[] args) {
        // Creating a primitive int array
        int[] intArray = { 1, 2, 3, 4, 5 };

        // Arrays.stream()
        IntStream stream = Arrays.stream(intArray);
        // Displaying elements in Stream
        stream.forEach(System.out::println);

        // Stream.of
        Stream<int[]> stream2 = Stream.of(intArray);
        // Displaying elements in Stream2
        stream2.forEach(System.out::println);
    }
}
