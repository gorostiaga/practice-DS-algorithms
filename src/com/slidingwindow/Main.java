package com.slidingwindow;

public class Main {

    public static void main(String[] args) {
       String s1 = "ab", s2 = "eidbaooo";
        Solution sol = new Solution();
       // sol.checkInclusion(s1, s2);
        //System.out.println(checkInclusion2(s1, s2));
        String s = "AABABBA";
        int k = 1;
        sol.characterReplacement(s, k);
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

    public static boolean checkInclusion2(String s1, String s2) {

        int[] s1Temp = new int[26];
        for(char i : s1.toCharArray()) s1Temp[i-'a']++;

        for(int i =0; i< s1.length(); i++){
            s1Temp[s2.charAt(i)-'a']--;
        }
        int l=0, r=s1.length()-1;

        while(r<s2.length()){
            if(isZero(s1Temp)) return  true;
            if(l<s2.length()-1) s1Temp[s2.charAt(l++) -'a']++;
            if(r<s2.length()-1) s1Temp[s2.charAt(++r)-'a']--;
        }

        return false;


    }

    private static boolean isZero(int[] n){
        for(int i: n){
            if(i != 0) return false;
        }
        return true;
    }
}
