package com.inhertance;

public class SubClass extends SuperClass{

    public void privateMethod(){
        // compile error
        //super.privateMethod();
    }
}
