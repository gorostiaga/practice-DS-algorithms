package com.codechallenges;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Baseball {

    public static void main(String[] args) {

        String[] ops1 = {"5", "2", "C", "D", "+"};
        System.out.println(operator(ops1));

        String[] ops2 = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println(operator(ops2));

        String[] ops3 = {"1"};
        System.out.println(operator(ops3));


    }

    private static int operator(String[] ops){

        List<Integer> results = new ArrayList<>();
        for(String i : ops){
            if(isInt(i)) results.add(Integer.parseInt(i));
            else if (i.equals("+")) {
                int temp = results.get(results.size()-1) + results.get(results.size()-2); 
                results.add(temp);                 
            } else if (i.equals("D")) {
                int temp = results.get(results.size()-1) *2;
                results.add(temp);
            } else if (i.equals("C")) {
                results.remove(results.size()-1);
            }
        }
        return results.stream().mapToInt(Integer::intValue).sum();
    }

    private static boolean isInt(String n){
        try{
            Integer.parseInt(n);
            return true;
        } catch (NumberFormatException e) {
            return false; 
        }
    }
}
