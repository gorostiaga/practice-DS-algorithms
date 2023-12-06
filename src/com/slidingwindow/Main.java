package com.slidingwindow;

public class Main {

    public static void main(String[] args) {
       String s1 = "adc", s2 = "dcda";
        Solution sol = new Solution();
        sol.checkInclusion(s1, s2);
    }

    public static boolean checkInclusion(String s1, String s2) {
        int l=0, r=0;
        int[] map = new int[26];
        for(char i : s1.toCharArray()) map[i-'a']++;

        while(r<s2.length()){
            map[s2.charAt(r)-'a']--;
            if(r-l+1<s1.length()){
                r++;
                continue;
            }
            if(zeroMap(map)) return true;
            else map[s2.charAt(l++)-'a']++;

        }
        return false;


    }

    private static boolean zeroMap(int[] m){
        for(int i : m){
            if(i != 0) return false;
        }
        return true;
    }
}
