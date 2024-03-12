package com.binarysearch;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {

        int[] nums = {11,13,15,17,10};
        //System.out.println(search(nums, 0));
        int[] piles = {30,11,23,4,20};
        int h = 5;



        System.out.println(minEatingSpeed(piles, h));
    }

    private static int search(int[] nums, int target) {

        int l=0, r=nums.length-1;

        while (l<=r){
            int mid = (r+l)/2;
            // ordered on the left
            if (nums[mid] == target) return mid;
            if(nums[mid]>= nums[l]){
                if(nums[l]<=target && target<nums[mid]) r=mid-1;
                else l = mid+1;
            }
            // ordered on the right
            else {
                if(nums[mid]<target && target<=nums[r]) l=mid+1;
                else r=mid-1;
            }
        }
        return -1;
    }
    private static int findMin(int[] nums) {

        int n = nums.length, l=0, r=n-1;

        while(l<=r){
            if(nums[l]<nums[r]) return nums[l];

            int mid = (r+l)/2;
            if(nums[mid]>=nums[l]){
                l = mid+1;
            } else {
                r=mid;
            }
        }
        return nums[l];
    }

    public static int minEatingSpeed(int[] piles, int h) {

        int max = Arrays.stream(piles).max().orElse(0);
        int min = Integer.MAX_VALUE;
        int[] inter = IntStream.rangeClosed(1, max).toArray();
        int l=0, r=piles.length;
        while(l<=r){
            int mid = (r+l)/2;
            int time = checker(inter[mid], piles);
            if(time>h) l = mid+1;
            else if(time<h) r = mid-1;
            else {
                min = Math.min(min, inter[mid]);
                r = mid-1;
            }
        }
        return min;


    }

    private static int checker(int n, int[] piles){
        int time =0;
        for(int i : piles){
            int temp = i;
            while(temp>0){
                temp -= n;
                time++;
            }
        }
        return time;
    }
}
