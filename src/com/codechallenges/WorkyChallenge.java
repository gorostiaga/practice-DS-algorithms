package com.codechallenges;

import java.util.*;
import java.util.stream.Collectors;

public class WorkyChallenge {

    public static void main(String[] args) {

        String[] doorsBitch = {"Room Number 1", "Secret room"};
        String[] doorsBitch2 = {"Portal 1", "Portal 2", "Portal 3"};
        String[] doorsBitch3 = {"Door to nowhere", "Door to nowhere 2"};
        String[] codes = {"910","811"};
        System.out.println(doors(doorsBitch, codes));

    }

    private static String doors (String[] doorsFitting, String[] codes){
        List<String> doorList = Arrays.stream(doorsFitting).collect(Collectors.toList());
        String result = "";

        Map<String, List<String>> map = new TreeMap<>();

        for(var code : codes){
            List<String> tempList = new ArrayList<>();
            for(var i : doorList){
                String temp = codeGenerator(i);
                if(code.equals(temp)) {
                    tempList.add(i);
                }
            }
            map.put(code, tempList);
        }

        for(var i : map.entrySet()){
            List<String> finalList = i.getValue();
            for(var j : finalList){
                result = result+ j+"-"+i.getKey()+";";
            }
        }


        return result != null ? result : "no door";
    }

    private static String codeGenerator(String s){
        int lowerCases=0, digits=0, isRoom=0;
        for(var i : s.toCharArray()){
            if(Character.isDigit(i)) digits++;
            if(Character.isLowerCase(i)) lowerCases++;
        }
        String temp = s.toLowerCase();
        if(temp.contains("room")) isRoom=1;

        return Integer.toString(lowerCases)+Integer.toString(isRoom)+Integer.toString(digits);
    }
}
