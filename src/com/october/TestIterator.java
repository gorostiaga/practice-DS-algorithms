package com.october;

import java.util.ArrayList;

public class TestIterator {

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(2);
        al.add(3);
        al.add(5);
        al.add(2);
        al.add(9);
        al.add(7);
        int counter =0;

        for(int i : al){
            i = 1;
        }
        for(int i: al) System.out.println(i);
    }
}
