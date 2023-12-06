package com.test22sep;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        int[] candles = {3, 2, 1, 3};
        System.out.println(birthdayCakeCandles(candles));
    }

    static int birthdayCakeCandles (int[] candles) {

        int max = Integer.MIN_VALUE;
        Map<Integer, Integer> hm = new HashMap<>();
        int result;
        // for get Max elemt
        for (int i : candles){
            max = Math.max(max, i);
            hm.put(i, hm.getOrDefault(hm.get(i), 0)+1);
        }
        result = hm.get(max);

       return result;


    }
}
