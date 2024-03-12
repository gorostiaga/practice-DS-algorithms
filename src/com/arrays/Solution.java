package com.arrays;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
/*        String s = "AnagrAm", t = "nAgaram";
        int[] nums = {3,2,4};
        int target = 6;
        System.out.println(twoSum(nums,target));*/

       /* int[] nums = {0,3,7,2,5,8,4,6,0,1,-5};
        List<Integer> list  = new ArrayList<>();
        TreeSet<Integer> tl = new TreeSet<>();
        for(int i : nums) {
            list.add(i);
            tl.add(i);
        }
        int max1 = Arrays.stream(nums).max().orElseThrow();
        int max = list.stream().max((a, b) -> b-a).get();
        System.out.println(tl.pollLast());
        System.out.println(tl.pollLast()); */
        String[] pepes = new String[]{"mierda", "carajo"};
        List<String> list = Arrays.stream(pepes).collect(Collectors.toList());
        list.add("7");

        for(String i : pepes) System.out.println(i);
        System.out.println("-------");
        for(String i : list) System.out.println(i);


    }
    public static boolean isAnagram(String s, String t) {
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        Arrays.sort(ta);
        Arrays.sort(sa);
        return Arrays.equals(sa, ta);

    }

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            map.put(nums[i], i);
            int compliment = target -nums[i];
            if(map.containsKey(compliment)) return new int[]{i, map.get(compliment)};
        }

        return null;

    }

    public static int longestConsecutive(int[] nums) {

        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int max = 0;

        for(Integer i : set){
            Integer l = i-1;
            Integer r = i+1;
            while(set.remove(l)) l--;
            while(set.remove(r)) r++;
            max = Math.max(max, r-l+1);
            if(set.isEmpty()) return max;
        }
        return max;

    }
}
