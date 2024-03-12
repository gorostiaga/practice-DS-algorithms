package com.pruebas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainTester {

    public static void main(String[] args) {
        /*String name = "Pepe";
        name = "analero";
        int n = 30%15;
        System.out.println(n);*/
/*        Outer outer = new Outer();
        Outer.NonStaticInner inner = outer.new NonStaticInner();
        inner.test();*/

        List<Person> people = new ArrayList<>();
        people.add(new Person("Lucho", 54));
        people.add(new Person("Penecio", 85));
        people.add(new Person("Analero", 23));
        people.add(new Person("Cujus", 8));

        Collections.sort(people, (p1, p2)-> p2.compareTo(p1));


        for(var i : people)
            System.out.println(i);

    }
    public static void change (int a){
        a = 1000;
    }
}
