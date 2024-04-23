package com.inhertance;

public class Tester {

    public static void main(String[] args) {
        SubClass sc = new SubClass();
        sc.publicMethod();
        //here we are calling the subclass method
        sc.privateMethod();
    }
}
