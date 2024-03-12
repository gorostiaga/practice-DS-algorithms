package com.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListToArray {
    public static void main(String[] args) {
        List<Integer> listA = new ArrayList<>();
        listA.add(1);
        listA.add(2);
        listA.add(3);
        listA.add(4);
        listA.add(5);

        int[] arrayB = new int[]{1,2,3,4,5};

        //List to array
        int[] arrayA = listA.stream().mapToInt(Integer::intValue).toArray();
        System.out.println("arrayA");
        for(var i : arrayA) System.out.println(i);

        //array to list
        List<Integer> listB = Arrays.stream(arrayB).boxed().collect(Collectors.toList());
        listB.add(6); // listB is totally separated from arrayB no UnsupportedOperationException
        System.out.println("listB");
        for(var i : listB) System.out.println(i);

        // List<Integer> to Integer[]
        Integer[] intsA = listA.toArray(Integer[]::new);
    }
}
