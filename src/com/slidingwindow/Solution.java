package com.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String minWindow(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray())
        {map.put(c,0);}

        for (char c : t.toCharArray()){
            if(map.containsKey(c))
                map.put(c,map.get(c)+1);
            else
                return "";
        }
        int counter=t.length(), begin=0, end=0, d=Integer.MAX_VALUE, head=0;

        while(end<s.length()){
            char c1 = s.charAt(end);
            if(map.get(c1)>0) counter--;
            map.put(c1,map.get(c1)-1);
            end++;
            while(counter == 0){
                if(end-begin < d) {
                    d=end -begin;
                    head = begin;
                }
                char c2 = s.charAt(begin);
                map.put(c2, map.get(c2)+1);
                if(map.get(c2) > 0) counter++;

                begin++;
            }
        }
        return d==Integer.MAX_VALUE ? "": s.substring(head, d+head);

    }

    public boolean checkInclusion(String s1, String s2) {
        int[] a = new int[26];
        char[] s1c = s1.toCharArray();
        char[] s2c = s2.toCharArray();

        for(char i : s1c){
            a[i - 'a']++;
        }

        int l = 0, r=0;

        while(r<s2c.length){
            if(--a[s2c[r] - 'a']>=0){
                if(r-l+1 == s1c.length) return true;
                r++;
            }
            else {
                while(l<r){
                    a[s2c[l] - 'a']++;
                    l++;
                }
                r=l;
            }
        }
        return false;

    }
}
