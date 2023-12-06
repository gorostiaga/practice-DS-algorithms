package com.binarysearch;

public class Solution {

    public static void main(String[] args) {

        int[] nums = {11,13,15,17,10};
        //System.out.println(search(nums, 0));
        System.out.println(findMin(nums));
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
}
