package com.linkedlist;

public class Solution {


    public static void main(String[] args) {

        int[] nums = {1,3,2,2,5,4};



    }

    public static int findDuplicate(int[] nums) {
        int len = nums.length;
        for (int num : nums) {
            int idx = Math.abs(num);
            if (nums[idx] < 0) {
                return idx;
            }
            nums[idx] = -nums[idx];
        }

        return len;
    }



}
