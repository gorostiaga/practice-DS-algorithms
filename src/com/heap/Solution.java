package com.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {

        Queue<Integer> fuck = new PriorityQueue<>((a,b) -> b-a);
        fuck.add(3);
        fuck.add(4);
        fuck.add(1);
        fuck.add(6);
        fuck.add(43);
        fuck.add(7);
        fuck.add(6);

        System.out.println(fuck.poll());
        System.out.println(fuck.poll());
        System.out.println(fuck.poll());

    }

}
