package com.codility;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public int solution(int[] A){
        List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());
        int i =1;
        while (true){
            if(!list.contains(i)) return i;
            i++;
        }


        //return -1;
    }

}
