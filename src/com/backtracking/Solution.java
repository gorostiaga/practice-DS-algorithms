package com.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    static List<List<Integer>> result;
    static int[] nums;
    static List<Integer> temp;

    public static void main(String[] args) {

        int[] intNums= {1,2,3};
        permute(intNums);

    }

    private static List<List<Integer>> permute(int[] nums) {

        result = new ArrayList<>();
        temp = new ArrayList();
        Solution.nums = nums;
        backtrack();
        return result;

    }

    private static void backtrack(){
        if(temp.size()==3) {
            result.add(new ArrayList<>(temp));
            return; }

        for(int i= 0; i<nums.length; i++){
            if(temp.contains(nums[i])) continue;
            temp.add(nums[i]);
            backtrack();
            temp.remove(temp.size()-1);
        }
    }
}
