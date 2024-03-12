package com.codility;

import java.util.PriorityQueue;

public class BoundedSlice {

    public static void main(String[] args) {
        int k = 2;
        int[] array = {3, 5, 7, 6, 3};
        System.out.println(solution(k, array));
    }

    public static int solution(int K, int[] A) {
        // Implement your solution here

        int l=0, r=0, counter=0;
        PriorityQueue<Integer> maxH = new PriorityQueue<>((a, b) -> b-a),
                minH = new PriorityQueue<>();
        int n = A.length;

        while(l<n){
            maxH.add(A[r]);
            minH.add(A[r]);
            if(maxH.peek() - minH.peek() <= K) {
                counter++;
                r++;
            }
            else{
                l++;
                r=l;
                maxH.clear();
                minH.clear();
            }
            if(r>=n) {
                l++;
                r=l;
                maxH.clear();
                minH.clear();
            }

        }

        return counter;
    }
}
